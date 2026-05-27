# Creator Tools (Bedrock Edition)

A professional Minecraft Bedrock Creator Tools Pack featuring advanced camera systems, privacy tools, and optimization features built with the Script API (JavaScript).

## 📦 Project Structure

```
Bedrock-Camera-Mod/
├── CreatorToolsBP/                    # Behavior Pack
│   ├── manifest.json                  # Pack manifest with dependencies
│   └── scripts/
│       ├── main.js                    # Main entry point & player management
│       ├── camera.js                  # Camera preset & adjustment logic
│       ├── privacy.js                 # Privacy toggle management
│       ├── optimization.js            # Optimization feature management
│       └── ui.js                      # UI form creation & handling
│
├── CreatorToolsRP/                    # Resource Pack
│   ├── manifest.json                  # Pack manifest with dependencies
│   ├── ui/
│   │   ├── camera_menu.json           # Camera tools UI layout
│   │   ├── privacy_menu.json          # Privacy tools UI layout
│   │   └── optimization_menu.json     # Optimization tools UI layout
│   │
│   └── camera_presets/
│       ├── cinematic.json             # Cinematic preset config
│       ├── side.json                  # Side-view preset config
│       ├── orbit.json                 # Orbit preset config
│       ├── topdown.json               # Top-down preset config
│       └── static.json                # Static preset config
│
└── README.md
```

## 🎥 Camera System

### 5 Professional Camera Presets

1. **Cinematic** - Smooth third-person camera for professional cinematic footage
   - Distance: 4 blocks | Height: 1.5 blocks | Tilt: 15° | FOV: 70° | Smoothness: 0.95

2. **Side** - Fixed side-view perfect for platformers
   - Distance: 5 blocks | Height: 1.2 blocks | Side Offset: 3 blocks | FOV: 80°

3. **Orbit** - Dynamic orbiting camera
   - Distance: 6 blocks | Height: 2 blocks | Orbit Speed: 2 units/sec | Tilt: 25°

4. **Top-Down** - Bird's-eye view
   - Height: 8 blocks | Tilt: 90° (straight down) | FOV: 85°

5. **Static** - Fixed professional camera
   - Static Distance: 6 blocks | Height: 1.6 blocks | No motion effects

### Fully Adjustable Sliders

- Camera Distance (0-15 blocks)
- Camera Height (-5 to 10 blocks)
- Side Offset (-5 to 5 blocks)
- Camera Tilt (-90° to 90°)
- Field of View (30° to 110°)
- Smoothness (0.0-1.0)
- Orbit Distance (3-20 blocks)
- Orbit Rotation Speed (0.5-10 units/sec)
- Static Distance (2-20 blocks)

### Features

- ✅ Preview mode to test settings before applying
- ✅ Smooth cinematic third-person camera
- ✅ No camera sway, bob, wobble, or motion sickness effects
- ✅ Smooth interpolation between positions
- ✅ All presets fully customizable via sliders
- ✅ Camera reset to default option

## 🛡️ Privacy Tools

Toggle these privacy features in your custom UI:

- **Hide Server IPs** - Prevent server IP addresses from appearing in chat
- **Hide Chat** - Hide all chat messages from view
- **Hide Player Names** - Obscure player names in nametags and chat
- **Hide HUD** - Remove on-screen HUD elements
- **Hide Coordinates** - Remove coordinate display

**Use Cases:**
- Stream/recording without exposing sensitive information
- Clean footage for YouTube/Twitch
- Protect privacy of players on your server

## 🚀 Optimization Boost

### Individual Optimization Features

- **Lower Particle Density** - Reduce visual effects (~20% FPS gain)
- **Lower Animation Tick Rate** - Reduce animation updates (~15% gain)
- **Disable Post-Processing** - Remove bloom, motion blur (~25% gain)
- **Simplify Entity Rendering** - Reduce entity complexity (~20% gain)

### Low-Impact Mode

Enable all optimizations at once for up to **80% performance gain estimate**.

**Real-time Performance Impact Calculator** - See estimated FPS improvement percentage.

## 🎮 User Interface

### Main Menu with 3 Sections

1. **🎥 Camera Tools**
   - Quick-select buttons for all 5 presets
   - Fine-tune individual settings
   - Reset camera option

2. **🛡️ Privacy Tools**
   - 5 toggle switches for each privacy feature
   - Easy enable/disable

3. **🚀 Optimization**
   - Individual optimization toggles
   - Low-Impact Mode master toggle
   - Real-time performance impact display

### UI Features

- Color-coded buttons and labels
- Sliders with precise controls
- Toggle switches for binary options
- Descriptive labels and helpful text
- Consistent navigation

## 📝 Installation

### For Creators

1. Download both packs:
   - `CreatorToolsBP` (Behavior Pack)
   - `CreatorToolsRP` (Resource Pack)

2. Move to Bedrock Edition pack folder:
   - **Windows**: `%appdata%\.minecraft\behavior_packs` and `resource_packs`
   - **macOS**: `~/Library/Application Support/minecraft/behavior_packs` and `resource_packs`

3. Enable both packs in world settings (Behavior Pack first, then Resource Pack)

4. Open chat and use `!tools` to access the menu

## 🚀 Quick Start Commands

```
!tools              # Open main menu
!camera             # Open camera tools
!privacy            # Open privacy settings
!optimize           # Open optimization settings
!preset cinematic   # Apply cinematic preset directly
!preset side        # Apply side preset
!preset orbit       # Apply orbit preset
!preset topdown     # Apply top-down preset
!preset static      # Apply static preset
```

## 📊 Technical Details

**Behavior Pack UUID**: `12345678-1234-5678-1234-567812345601`
**Resource Pack UUID**: `12345678-1234-5678-1234-567812345602`
**Min Engine Version**: 1.20.0

**Dependencies**:
- `@minecraft/server` v1.8.0+
- `@minecraft/server-ui` v1.2.0+

## 📋 Feature Checklist

- ✅ 5 camera presets with full specifications
- ✅ All adjustable sliders (9 total)
- ✅ Preview button functionality
- ✅ Smooth cinematic camera
- ✅ 5 Privacy toggles
- ✅ 4 Optimization features + Master toggle
- ✅ Custom UI menu with tabs/sections
- ✅ Per-player settings management
- ✅ Dynamic UI updates
- ✅ Complete folder structure
- ✅ Proper manifests with UUIDs and dependencies

## 📚 Documentation

See [IMPLEMENTATION.md](IMPLEMENTATION.md) for detailed implementation notes and feature descriptions.

---

**Ready to stream or create professional Minecraft content!**