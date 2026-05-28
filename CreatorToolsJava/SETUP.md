# Creator Tools - Java Edition Setup Guide

## Quick Start

### Prerequisites
- Java Development Kit (JDK) 17 or later
- Gradle (optional, included wrapper is used)
- Minecraft Launcher

### Building the Mod

```bash
# Navigate to Java project
cd CreatorToolsJava

# Make gradlew executable (Linux/Mac)
chmod +x gradlew

# Build the mod
./gradlew build    # Linux/Mac
gradlew.bat build  # Windows
```

Output JAR: `build/libs/CreatorTools-1.0.0.jar`

### Installation

1. Install Fabric Loader
   - Download: https://fabricmc.net/
   - Select Minecraft 1.20.1
   - Install

2. Install Fabric API
   - Download: https://modrinth.com/mod/fabric-api (for 1.20.1)
   - Place JAR in `mods` folder

3. Install Creator Tools
   - Place `CreatorTools-1.0.0.jar` in `mods` folder
   - Launch Minecraft

### Development Setup

```bash
# Generate IDE workspace
./gradlew genSources

# Build and test
./gradlew build

# Generate idea project
./gradlew idea
```

## Project Structure

```
CreatorToolsJava/
├── src/main/java/com/creatortools/
│   ├── CreatorToolsMod.java           (Main entry point)
│   ├── camera/CameraManager.java      (Camera system)
│   ├── privacy/PrivacyManager.java    (Privacy tools)
│   ├── optimization/OptimizationManager.java
│   ├── ui/ScreenManager.java          (GUI)
│   └── update/UpdateChecker.java      (Auto-update)
│
├── src/main/resources/
│   ├── fabric.mod.json               (Fabric metadata)
│   ├── creatortools.mixins.json      (Mixins config)
│   └── assets/creatortools/
│       └── lang/en_us.json           (Language file)
│
├── build.gradle                       (Build configuration)
├── settings.gradle                    (Gradle settings)
└── gradle.properties                  (Version info)
```

## Publishing Updates

### Create a New Release

```bash
# Tag the version
git tag v1.0.1

# Push to GitHub
git push origin v1.0.1

# GitHub Actions automatically:
# 1. Builds the JAR
# 2. Creates release
# 3. Uploads JAR
# 4. Updates players (via update checker)
```

### Update Minecraft Version

To support a new Minecraft version:

1. Update `gradle.properties`
   ```properties
   minecraft_version=1.21
   fabric_version=0.91.3+1.21
   loader_version=0.14.25
   ```

2. Update `fabric.mod.json`
   ```json
   "depends": {
     "minecraft": "1.21"
   }
   ```

3. Test build
   ```bash
   ./gradlew clean build
   ```

4. Release
   ```bash
   git tag v1.1.0
   git push origin v1.1.0
   ```

## Troubleshooting

### Build fails with Java version error
- Install JDK 17+
- Set JAVA_HOME environment variable
- Verify: `java -version`

### Mod won't load in Minecraft
- Ensure Fabric Loader installed
- Ensure Fabric API in mods folder
- Check Minecraft logs

### Update checker not working
- Check internet connection
- Verify GitHub is accessible
- Check console for errors

## Auto-Update System Details

See `UPDATE_SYSTEM.md` for comprehensive update information.

## Additional Resources

- Fabric Wiki: https://fabricmc.net/wiki/
- Minecraft Modding: https://minecraft.fandom.com/wiki/Tutorials/Mods
- GitHub Actions: https://github.com/features/actions
