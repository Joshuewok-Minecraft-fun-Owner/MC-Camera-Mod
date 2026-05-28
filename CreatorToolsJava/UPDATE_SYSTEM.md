# Java Edition Auto-Update System

## How It Works

Creator Tools includes an automatic update checker that runs at startup and periodically checks for new versions.

### Update Check Process

1. **Startup Check** (First)
   - On startup, the UpdateChecker thread begins
   - Connects to GitHub API to get latest release info
   - Compares versions

2. **Version Comparison**
   - Checks semantic versioning (e.g., 1.0.0 vs 1.0.1)
   - Handles major, minor, and patch updates
   - Only notifies if newer version found

3. **Notification**
   - In-game chat message with new version
   - Download link to latest release
   - Non-intrusive notification

### GitHub Releases Integration

Latest release info is fetched from:
```
https://api.github.com/repos/Joshuewok-Minecraft-fun-Owner/Bedrock-Camera-Mod/releases/latest
```

### Auto-Publishing Workflow

When you push a tag:
```bash
git tag v1.0.1
git push origin v1.0.1
```

GitHub Actions automatically:
1. Builds the JAR with Gradle
2. Creates a GitHub Release
3. Uploads the JAR file
4. Updates the API endpoint
5. Mod downloads update notification

### Supported Update Channels

- **Stable**: Full releases (v1.0.0, v1.0.1)
- **Beta**: Pre-releases (v1.0.0-beta.1)
- **Latest**: Always the most recent version

### Version Compatibility

| Version | Minecraft | Fabric | Status |
|---------|-----------|--------|--------|
| 1.0.0   | 1.20.1    | 0.14+  | Latest |
| 1.0.1   | 1.20.1    | 0.14+  | Next (if released) |
| 1.1.0   | 1.21+     | 0.15+  | Planned |

## Setting Up Auto-Updates

### For Developers

1. **Enable GitHub Actions**
   - Settings → Actions → Enable

2. **Create Release**
   ```bash
   git tag v1.0.1
   git push origin v1.0.1
   ```

3. **Workflow runs automatically**
   - Builds mod
   - Creates release
   - Uploads JAR
   - Updates available to all players

### For Players

- Updates are checked automatically
- No action needed!
- Optional: Manual download from GitHub

## Manual Version Updates

If you need to target a specific Minecraft version:

1. **Update gradle.properties**
   ```properties
   minecraft_version=1.21
   fabric_version=0.91.3+1.21
   ```

2. **Update fabric.mod.json**
   ```json
   "depends": {
     "minecraft": "1.21"
   }
   ```

3. **Build and release**
   ```bash
   ./gradlew build
   git tag vX.X.X
   git push origin vX.X.X
   ```

## Troubleshooting Auto-Updates

### Check Failed?
- No internet connection → Works offline, silently fails
- GitHub temporarily down → Checked again next startup
- Rate limited → GitHub allows 60 requests/hour

### Update Not Showing?
- Close and restart Minecraft
- Check console for update checker logs
- Manually check GitHub releases

### Build Failed?
- GitHub Actions shows error
- Check workflow logs
- Fix issue and tag again

## Update Frequency

| Type | Frequency |
|------|-----------|
| Bug Fixes | As needed |
| New Features | Monthly |
| Minecraft Updates | Within 1 week |
| Fabric Updates | Auto-handled |

---

The update system is fully automated and requires no manual intervention!
