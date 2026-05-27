import { world } from "@minecraft/server";

export class CameraManager {
  constructor() {
    this.presets = {
      cinematic: {
        name: "Cinematic",
        distance: 4,
        height: 1.5,
        sideOffset: 0,
        tilt: 15,
        fov: 70,
        smoothness: 0.95
      },
      side: {
        name: "Side",
        distance: 5,
        height: 1.2,
        sideOffset: 3,
        tilt: 0,
        fov: 80,
        smoothness: 0.85
      },
      orbit: {
        name: "Orbit",
        distance: 6,
        height: 2,
        sideOffset: 0,
        tilt: 25,
        fov: 75,
        smoothness: 0.9,
        orbitDistance: 5,
        orbitRotationSpeed: 2
      },
      topdown: {
        name: "Top-Down",
        distance: 0,
        height: 8,
        sideOffset: 0,
        tilt: 90,
        fov: 85,
        smoothness: 0.8
      },
      static: {
        name: "Static",
        distance: 0,
        height: 1.6,
        sideOffset: 0,
        tilt: 0,
        fov: 80,
        smoothness: 1.0,
        staticDistance: 6
      }
    };

    this.cameraStates = new Map();
  }

  getPresets() {
    return this.presets;
  }

  getPreset(name) {
    return this.presets[name.toLowerCase()] || this.presets.cinematic;
  }

  previewPreset(player, presetName, customSettings = {}) {
    const preset = this.getPreset(presetName);
    const settings = { ...preset, ...customSettings };

    // Store preview state
    this.cameraStates.set(player.id, {
      isPreview: true,
      preset: presetName,
      settings: settings,
      originalCamera: null
    });

    this.applyCameraSettings(player, settings);
    player.sendMessage(`§6[Preview] Previewing ${preset.name} camera preset`);
  }

  applyPreset(player, presetName, playerSettings) {
    const preset = this.getPreset(presetName);
    
    // Merge with player's custom adjustments
    const finalSettings = {
      ...preset,
      ...playerSettings.cameraSettings
    };

    this.cameraStates.set(player.id, {
      isPreview: false,
      preset: presetName,
      settings: finalSettings
    });

    this.applyCameraSettings(player, finalSettings);
    player.sendMessage(`§aCamera preset applied: ${preset.name}`);
  }

  applyCameraSettings(player, settings) {
    try {
      // Apply camera pitch (tilt)
      const pitchValue = Math.max(-90, Math.min(90, settings.tilt));
      player.camera.setCamera("free", {
        position: this.calculateCameraPosition(player, settings),
        rotation: { x: pitchValue, y: 0 }
      });

      // Store effective settings
      this.cameraStates.set(player.id, {
        ...this.cameraStates.get(player.id),
        appliedAt: Date.now()
      });
    } catch (error) {
      console.warn(`[Camera] Error applying camera settings: ${error}`);
    }
  }

  calculateCameraPosition(player, settings) {
    const playerPos = player.location;
    const playerHeading = player.getRotation().y * (Math.PI / 180);

    let x = playerPos.x;
    let y = playerPos.y + settings.height;
    let z = playerPos.z;

    // Side offset
    if (settings.sideOffset !== 0) {
      x += Math.cos(playerHeading + Math.PI / 2) * settings.sideOffset;
      z += Math.sin(playerHeading + Math.PI / 2) * settings.sideOffset;
    }

    // Distance offset (behind player)
    if (settings.distance > 0) {
      x -= Math.cos(playerHeading) * settings.distance;
      z -= Math.sin(playerHeading) * settings.distance;
    }

    return { x, y, z };
  }

  updateCameraDistance(player, value, playerSettings) {
    playerSettings.cameraSettings.distance = Math.max(0, Math.min(15, value));
    this.applyCameraSettings(player, playerSettings.cameraSettings);
  }

  updateCameraHeight(player, value, playerSettings) {
    playerSettings.cameraSettings.height = Math.max(-5, Math.min(10, value));
    this.applyCameraSettings(player, playerSettings.cameraSettings);
  }

  updateCameraSideOffset(player, value, playerSettings) {
    playerSettings.cameraSettings.sideOffset = Math.max(-5, Math.min(5, value));
    this.applyCameraSettings(player, playerSettings.cameraSettings);
  }

  updateCameraTilt(player, value, playerSettings) {
    playerSettings.cameraSettings.tilt = Math.max(-90, Math.min(90, value));
    this.applyCameraSettings(player, playerSettings.cameraSettings);
  }

  updateCameraFOV(player, value, playerSettings) {
    playerSettings.cameraSettings.fov = Math.max(30, Math.min(110, value));
    // FOV would be applied at render time in real implementation
  }

  updateCameraSmoothness(player, value, playerSettings) {
    playerSettings.cameraSettings.smoothness = Math.max(0, Math.min(1, value));
  }

  updateOrbitDistance(player, value, playerSettings) {
    playerSettings.cameraSettings.orbitDistance = Math.max(3, Math.min(20, value));
  }

  updateOrbitRotationSpeed(player, value, playerSettings) {
    playerSettings.cameraSettings.orbitRotationSpeed = Math.max(0.5, Math.min(10, value));
  }

  updateStaticDistance(player, value, playerSettings) {
    playerSettings.cameraSettings.staticDistance = Math.max(2, Math.min(20, value));
  }

  resetCamera(player) {
    try {
      player.camera.clear();
      this.cameraStates.delete(player.id);
      player.sendMessage(`§aCamera reset to default`);
    } catch (error) {
      console.warn(`[Camera] Error resetting camera: ${error}`);
    }
  }

  getCameraState(playerId) {
    return this.cameraStates.get(playerId) || null;
  }
}
