# 🚀 Quick Start Guide - Creator Tools

## Installation (2 minutes)

### 🟢 Easy Method (Recommended): Use .mcaddon File

1. **Download**: `CreatorTools.mcaddon` file
2. **Install**: Double-click the file (Minecraft will import automatically)
   - **Windows**: File will open in Minecraft
   - **macOS/iOS**: Open with Minecraft
   - **Android**: Use Files app → Open with Minecraft
3. Done! Both packs are installed.

---

### 🔵 Manual Method: Copy Packs Folder

If the .mcaddon method doesn't work, manually copy folders:

Navigate to your Minecraft Bedrock pack folders:
- **Windows**: `%appdata%\.minecraft\behavior_packs` and `resource_packs`
- **macOS**: `~/Library/Application Support/minecraft/behavior_packs` and `resource_packs`
- **Linux**: `~/.minecraft/behavior_packs` and `resource_packs`

Copy the folders:
- `CreatorToolsBP` → behavior_packs/
- `CreatorToolsRP` → resource_packs/

### 2. Enable Packs in World
1. Create a new world or open an existing one
2. Go to **Settings** → **Resource Packs**
3. Add **CreatorToolsRP** (Resource Pack)
4. Go to **Behavior Packs**
5. Add **CreatorToolsBP** (Behavior Pack)
6. Click **Create** or **Apply**

### 3. Start Using!
Open chat and type: `!tools`

---

## 🎮 Main Menu

Once you run `!tools`, you'll see the main menu with 3 sections:

### 🎥 Camera Tools
- Select from 5 presets (Cinematic, Side, Orbit, Top-Down, Static)
- Click "Adjust Settings" to fine-tune with sliders
- Use "Reset Camera" to go back to default
- Try preview mode before applying

### 🛡️ Privacy Tools
- Toggle to hide server IPs
- Toggle to hide chat messages
- Toggle to hide player names
- Toggle to hide HUD elements
- Toggle to hide coordinates
Perfect for streaming or recording!

### 🚀 Optimization
- Enable individual optimizations as needed
- Use "Low-Impact Mode" to enable all at once
- See real-time performance impact percentage

---

## ⌨️ Chat Commands

**Main Commands:**
```
!tools              → Open main menu
!camera             → Go directly to camera tools
!privacy            → Go directly to privacy tools
!optimize           → Go directly to optimization tools
```

**Quick Preset Application:**
```
!preset cinematic   → Apply cinematic immediately
!preset side        → Apply side camera
!preset orbit       → Apply orbit camera
!preset topdown     → Apply top-down camera
!preset static      → Apply static camera
```

---

## 🎥 Camera Presets Overview

### Cinematic (Professional Filmmaker)
- Smooth third-person view behind the player
- Perfect for storytelling and cinematic shots
- Distance: 4 blocks, Height: 1.5 blocks
- Tilt: 15°, FOV: 70°

### Side (Platformer Games)
- Fixed side-view camera
- Great for action sequences and platforming
- Distance: 5 blocks, Offset: 3 blocks to the side
- Height: 1.2 blocks

### Orbit (Dynamic Showcase)
- Camera circles around the player
- Perfect for showing off builds or players
- Distance: 6 blocks, Height: 2 blocks
- Orbits at adjustable speed

### Top-Down (Bird's Eye View)
- Looking straight down from above
- Great for strategy games or demonstrations
- Height: 8 blocks, Tilt: 90°

### Static (Fixed Position)
- Camera stays in one fixed position
- Professional for interviews or setups
- Static Distance: 6 blocks

---

## 🛠️ Adjusting Camera Settings

### How to Customize:
1. Open Camera Tools: `!camera`
2. Choose a preset or "Adjust Settings"
3. Use sliders to customize:
   - **Distance**: How far back the camera is (0-15 blocks)
   - **Height**: How high/low the camera is (-5 to 10 blocks)
   - **Side Offset**: Move camera left/right (-5 to 5 blocks)
   - **Tilt**: Angle of the camera (-90° to 90°)
   - **FOV**: Zoom level (30° to 110°)
   - **Smoothness**: How smooth camera motion is (0-1)

### Preview Mode:
- Before applying settings, toggle "Preview" ON
- This lets you see how the camera looks without permanently applying it
- Great for testing different values!

---

## 🎬 Streaming Setup Example

1. Open `!tools` → **Camera Tools**
2. Select **Cinematic** preset
3. Go to `!tools` → **Privacy Tools**
4. Enable: Hide Server IPs, Hide Chat, Hide Coordinates
5. Go to `!tools` → **Optimization**
6. Enable: Low-Impact Mode (for better FPS)

Now you're ready to stream with professional camera and clean visuals!

---

## 📊 Performance Impact

The optimization tools estimate performance improvement:
- **Lower Particle Density**: +20% FPS
- **Lower Animation Tick Rate**: +15% FPS
- **Disable Post-Processing**: +25% FPS
- **Simplify Entity Rendering**: +20% FPS
- **Low-Impact Mode** (All): ~80% FPS improvement

Try enabling them one at a time to see what works for your system!

---

## 💡 Pro Tips

**Tip 1**: Save your favorite settings by remembering the slider values
**Tip 2**: Use Preview mode to test before applying changes
**Tip 3**: Combine privacy tools with cinematic camera for clean streaming
**Tip 4**: Use Low-Impact Mode if you're experiencing lag
**Tip 5**: The camera follows your movement - try walking while using different presets!

---

## ❓ Troubleshooting

### Can't see the menu?
- Make sure you enabled both packs (Behavior Pack FIRST, then Resource Pack)
- Try typing the command again: `!tools`

### Camera isn't moving?
- Some presets have fixed positions (Top-Down, Static)
- Switch to Cinematic or Side for moving cameras
- Make sure you Applied the preset, not just previewed it

### Performance is still low?
- Go to `!optimize` and enable Low-Impact Mode
- Reduce render distance in world settings
- Disable fancy graphics in video settings

### Settings reset when I leave?
- Settings are saved per-player in the current world session
- They persist as long as you're in the world
- For persistence across worlds, you'd need a database system

---

## 📁 File Locations

If you need to troubleshoot or modify the packs:

```
CreatorToolsBP/
  └── scripts/
      ├── main.js          (Main logic)
      ├── camera.js        (Camera system)
      ├── privacy.js       (Privacy toggles)
      ├── optimization.js  (Optimization)
      └── ui.js            (Menu interface)

CreatorToolsRP/
  ├── camera_presets/      (Preset configurations)
  └── ui/                  (Menu layouts)
```

---

## 🎓 Learning More

For detailed technical information:
- Read [README.md](README.md) for complete documentation
- Read [IMPLEMENTATION.md](IMPLEMENTATION.md) for technical details
- Read [VALIDATION_REPORT.md](VALIDATION_REPORT.md) for validation details

---

## ✨ You're All Set!

Your Creator Tools pack is ready to use. Type `!tools` in chat to get started!

Happy creating! 🎬🎮
