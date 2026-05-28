# 🎮 Creator Tools - Java Edition (Fabric)

Professional camera, privacy, and optimization mod for Minecraft Java 1.20.1.

## 🚀 Quick Install (Players)

### Requirements
- Minecraft Java Edition 1.20.1
- Fabric Loader 0.14.0+
- Fabric API 0.91.3+

### Installation
1. Install [Fabric Loader](https://fabricmc.net/) for 1.20.1
2. Download [Fabric API](https://modrinth.com/mod/fabric-api) for 1.20.1 → place in `mods/`
3. Download `CreatorTools-1.0.0.jar` → place in `mods/`
4. Launch Minecraft and press **P** to open menu

## 📖 Usage

**Default Keybind**: Press **P** to open Creator Tools menu

### Features
- 🎥 **5 Camera Presets**: Cinematic, Side, Orbit, Top-Down, Static
- 🎯 **9 Camera Sliders**: Distance, Height, Tilt, FOV, Smoothness, etc.
- 🛡️ **5 Privacy Toggles**: Hide IPs, chat, names, HUD, coordinates
- 🚀 **4 Optimizations**: Particles, animations, post-processing, entity rendering
- 🔄 **Auto-Update System**: Automatic version checking with in-game notifications

## 🔧 Build from Source (Developers)

### Prerequisites
- Java Development Kit (JDK) 17+
- Git

### Steps
```bash
# Clone repo
git clone https://github.com/Joshuewok-Minecraft-fun-Owner/Bedrock-Camera-Mod
cd CreatorToolsJava

# Build the mod
chmod +x gradlew          # Linux/Mac only
./gradlew build           # Linux/Mac
gradlew.bat build         # Windows

# Output: build/libs/CreatorTools-1.0.0.jar
```

### Development Setup
```bash
# Generate IDE files
./gradlew genSources

# Setup IDEA IDE
./gradlew idea
```

## 🔄 Auto-Update System

Creator Tools automatically checks GitHub for updates:

### How It Works
1. **Startup**: Mod checks `https://api.github.com/repos/Joshuewok-Minecraft-fun-Owner/Bedrock-Camera-Mod/releases/latest`
2. **Version Check**: Compares current vs latest using semantic versioning
3. **Notification**: In-game chat message if newer version available
4. **Download Link**: One-click download provided

### For Developers: Releasing Updates

1. **Prepare and commit changes**
   ```bash
   git add .
   git commit -m "Add new feature"
   ```

2. **Create release tag**
   ```bash
   git tag v1.0.1
   git push origin v1.0.1
   ```

3. **GitHub Actions auto-publishes**
   - ✅ Builds JAR with Gradle
   - ✅ Creates GitHub Release
   - ✅ Uploads JAR file
   - ✅ Updates API endpoint
   - ✅ Players notified at next startup

### Version Format
Use semantic versioning: `v{major}.{minor}.{patch}`
- `v1.0.0` - Initial release
- `v1.0.1` - Bugfix
- `v1.1.0` - New features
- `v2.0.0` - Major changes

### Supported Versions
| Version | Minecraft | Status |
|---------|-----------|--------|
| 1.0.0 | 1.20.1 | Current |
| 1.1.0 | 1.21+ | Planned (after release) |

## ⚙️ Configuration

Settings stored in: `.minecraft/config/creatortools.json`

```json
{
  "cameraPreset": "cinematic",
  "privacySettings": {
    "hideServerIPs": false,
    "hideChat": false,
    "hidePlayerNames": false,
    "hideHUD": false,
    "hideCoordinates": false
  },
  "optimizationSettings": {
    "lowImpactMode": false
  }
}
```

## 🐛 Troubleshooting

| Issue | Solution |
|-------|----------|
| Menu won't open | Verify Fabric + Fabric API installed, press P |
| Mod not loading | Check console for errors, reinstall Fabric API |
| Update checker fails | No internet = works offline, check GitHub status |
| Performance issues | Enable Low-Impact Mode or individual optimizations |

## ✅ Compatibility

- ✅ Works with most client mods
- ✅ OptiFine compatible
- ✅ Singleplayer & Multiplayer
- ✅ Server-side mod NOT required

## 📦 Project Structure

```
CreatorToolsJava/
├── src/main/java/com/creatortools/
│   ├── CreatorToolsMod.java       (Entry point)
│   ├── camera/CameraManager.java
│   ├── privacy/PrivacyManager.java
│   ├── optimization/OptimizationManager.java
│   ├── ui/ScreenManager.java
│   └── update/UpdateChecker.java  (Auto-update)
├── build.gradle
├── gradle.properties
└── README.md
```

## 📝 License

MIT License - Open source and free to modify

---

**Version**: 1.0.0 | **Minecraft**: 1.20.1 | **Status**: Active
