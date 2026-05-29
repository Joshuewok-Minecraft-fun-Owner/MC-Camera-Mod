#!/bin/bash

# Creator Tools Auto-Release Script
# Smart daily release script - only creates releases when code changes
# Safe to run every day!

set -e

# Colors
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
RED='\033[0;31m'
NC='\033[0m'

# Get last version tag
get_last_version() {
    git describe --tags --abbrev=0 2>/dev/null | sed 's/.*v//; s/-[a-z]*$//' || echo "0.0.0"
}

# Increment patch version (1.0.0 -> 1.0.1)
bump_patch() {
    local v="$1"
    local patch=$(($(echo "$v" | cut -d. -f3) + 1))
    echo "$(echo "$v" | cut -d. -f1-2).${patch}"
}

# Check if code changed since last release
code_changed() {
    local last_tag=$(git describe --tags --abbrev=0 2>/dev/null || echo "")
    if [ -z "$last_tag" ]; then
        return 0  # First release
    fi
    
    # Count commits since last tag
    local new_commits=$(git log "${last_tag}"..HEAD --oneline 2>/dev/null | wc -l)
    [ "$new_commits" -gt 0 ]
}

# Main
main() {
    echo -e "${BLUE}╔════════════════════════════════════╗${NC}"
    echo -e "${BLUE}║  Creator Tools Auto-Release v2.0  ║${NC}"
    echo -e "${BLUE}╚════════════════════════════════════╝${NC}"
    echo ""
    
    # Show usage if no args
    if [ "$#" -eq 0 ]; then
        local last_version=$(get_last_version)
        echo -e "${GREEN}Current Version:${NC} v${last_version}"
        echo ""
        echo -e "${YELLOW}Usage:${NC}"
        echo "  ${BLUE}./release.sh auto${NC}   - Smart release (only if code changed)"
        echo "  ${BLUE}./release.sh 1.0.2${NC}  - Force release with version"
        echo ""
        return 0
    fi
    
    # Check git status
    if [ -n "$(git status --porcelain)" ]; then
        echo -e "${RED}❌ Uncommitted changes:${NC}"
        git status --short
        exit 1
    fi
    
    # Check branch
    if [ "$(git rev-parse --abbrev-ref HEAD)" != "main" ]; then
        echo -e "${RED}❌ Must be on main branch${NC}"
        exit 1
    fi
    
    echo -e "${GREEN}✅ Git clean${NC}"
    echo ""
    
    local version=""
    
    # Auto mode
    if [ "$1" = "auto" ]; then
        if ! code_changed; then
            echo -e "${YELLOW}⏭️  No code changes since last release${NC}"
            echo -e "Skipping release to prevent duplicates 😊${NC}"
            echo ""
            echo -e "${BLUE}💡 Tip: Run this daily! It auto-skips unchanged code.${NC}"
            return 0
        fi
        
        version=$(bump_patch "$(get_last_version)")
        echo -e "${GREEN}📈 Code changes detected!${NC}"
        echo -e "Auto-bumping: v$(get_last_version) → v${version}"
        echo ""
    else
        version="$1"
        echo -e "${GREEN}🔧 Manual version: v${version}${NC}"
        echo ""
    fi
    
    # Create tags
    echo -e "${YELLOW}📌 Creating release tags...${NC}"
    git tag "v${version}-bedrock-mcaddon"
    git tag "v${version}-bedrock-folders"
    git tag "v${version}-java"
    echo -e "${GREEN}✅ Tags created${NC}"
    echo ""
    
    # Push
    echo -e "${YELLOW}📤 Pushing to GitHub...${NC}"
    git push origin "v${version}-bedrock-mcaddon" "v${version}-bedrock-folders" "v${version}-java"
    echo -e "${GREEN}✅ Pushed!${NC}"
    echo ""
    
    echo -e "${GREEN}🎉 Release v${version} created!${NC}"
    echo ""
    echo -e "${BLUE}View here:${NC} https://github.com/Joshuewok-Minecraft-fun-Owner/MC-Camera-Mod/releases"
    echo ""
}

main "$@"
