import { ActionFormData, ModalFormData } from "@minecraft/server-ui";

export class UIManager {
  constructor(cameraManager, privacyManager, optimizationManager) {
    this.cameraManager = cameraManager;
    this.privacyManager = privacyManager;
    this.optimizationManager = optimizationManager;
  }

  showMainMenu(player, playerSettings) {
    const form = new ActionFormData()
      .title("§l§6Creator Tools")
      .body("Select a tool to customize:")
      .button("§f🎥\nCamera Tools")
      .button("§f🛡️\nPrivacy Tools")
      .button("§f🚀\nOptimization")
      .button("§f❌\nClose");

    form.show(player).then((response) => {
      if (response.canceled) return;

      switch (response.selection) {
        case 0:
          this.showCameraMenu(player, playerSettings);
          break;
        case 1:
          this.showPrivacyMenu(player, playerSettings);
          break;
        case 2:
          this.showOptimizationMenu(player, playerSettings);
          break;
        case 3:
          player.sendMessage(`§7Tools menu closed`);
          break;
      }
    });
  }

  showCameraMenu(player, playerSettings) {
    const form = new ActionFormData()
      .title("§l§6Camera Tools")
      .body("Choose a camera preset or customize:")
      .button("§eCinematic")
      .button("§eSide")
      .button("§eOrbit")
      .button("§eTop-Down")
      .button("§eStatic")
      .button("§9Adjust Settings")
      .button("§7Reset Camera")
      .button("§cBack");

    form.show(player).then((response) => {
      if (response.canceled) return;

      switch (response.selection) {
        case 0:
          this.cameraManager.applyPreset(player, "cinematic", playerSettings);
          break;
        case 1:
          this.cameraManager.applyPreset(player, "side", playerSettings);
          break;
        case 2:
          this.cameraManager.applyPreset(player, "orbit", playerSettings);
          break;
        case 3:
          this.cameraManager.applyPreset(player, "topdown", playerSettings);
          break;
        case 4:
          this.cameraManager.applyPreset(player, "static", playerSettings);
          break;
        case 5:
          this.showCameraAdjustmentMenu(player, playerSettings);
          break;
        case 6:
          this.cameraManager.resetCamera(player);
          break;
        case 7:
          this.showMainMenu(player, playerSettings);
          break;
      }
    });
  }

  showCameraAdjustmentMenu(player, playerSettings) {
    const form = new ModalFormData()
      .title("§l§6Camera Settings")
      .slider("Camera Distance", 0, 15, 1, playerSettings.cameraSettings.distance)
      .slider("Camera Height", -5, 10, 0.5, playerSettings.cameraSettings.height)
      .slider("Side Offset", -5, 5, 0.5, playerSettings.cameraSettings.sideOffset)
      .slider("Camera Tilt", -90, 90, 1, playerSettings.cameraSettings.tilt)
      .slider("Field of View", 30, 110, 5, playerSettings.cameraSettings.fov)
      .slider("Smoothness", 0, 1, 0.05, playerSettings.cameraSettings.smoothness)
      .toggle("Preview", false);

    form.show(player).then((response) => {
      if (response.canceled) {
        this.showCameraMenu(player, playerSettings);
        return;
      }

      playerSettings.cameraSettings.distance = response.formValues[0];
      playerSettings.cameraSettings.height = response.formValues[1];
      playerSettings.cameraSettings.sideOffset = response.formValues[2];
      playerSettings.cameraSettings.tilt = response.formValues[3];
      playerSettings.cameraSettings.fov = response.formValues[4];
      playerSettings.cameraSettings.smoothness = response.formValues[5];

      if (response.formValues[6]) {
        // Preview mode
        this.cameraManager.previewPreset(player, playerSettings.cameraPreset || "cinematic", playerSettings.cameraSettings);
      } else {
        // Apply mode
        this.cameraManager.applyCameraSettings(player, playerSettings.cameraSettings);
        player.sendMessage(`§aCamera settings applied`);
      }

      this.showCameraMenu(player, playerSettings);
    });
  }

  showPrivacyMenu(player, playerSettings) {
    const privacySettings = playerSettings.privacySettings;
    
    const form = new ModalFormData()
      .title("§l§6Privacy Tools")
      .toggle("Hide Server IPs", privacySettings.hideServerIPs)
      .toggle("Hide Chat", privacySettings.hideChat)
      .toggle("Hide Player Names", privacySettings.hidePlayerNames)
      .toggle("Hide HUD", privacySettings.hideHUD)
      .toggle("Hide Coordinates", privacySettings.hideCoordinates);

    form.show(player).then((response) => {
      if (response.canceled) {
        this.showMainMenu(player, playerSettings);
        return;
      }

      const wasHideServerIPs = privacySettings.hideServerIPs;
      const wasHideChat = privacySettings.hideChat;
      const wasHidePlayerNames = privacySettings.hidePlayerNames;
      const wasHideHUD = privacySettings.hideHUD;
      const wasHideCoordinates = privacySettings.hideCoordinates;

      privacySettings.hideServerIPs = response.formValues[0];
      privacySettings.hideChat = response.formValues[1];
      privacySettings.hidePlayerNames = response.formValues[2];
      privacySettings.hideHUD = response.formValues[3];
      privacySettings.hideCoordinates = response.formValues[4];

      // Apply changes only if they've changed
      if (privacySettings.hideServerIPs !== wasHideServerIPs) {
        this.privacyManager.toggleHideServerIPs(player, playerSettings);
      }
      if (privacySettings.hideChat !== wasHideChat) {
        this.privacyManager.toggleHideChat(player, playerSettings);
      }
      if (privacySettings.hidePlayerNames !== wasHidePlayerNames) {
        this.privacyManager.toggleHidePlayerNames(player, playerSettings);
      }
      if (privacySettings.hideHUD !== wasHideHUD) {
        this.privacyManager.toggleHideHUD(player, playerSettings);
      }
      if (privacySettings.hideCoordinates !== wasHideCoordinates) {
        this.privacyManager.toggleHideCoordinates(player, playerSettings);
      }

      player.sendMessage(`§aPrivacy settings updated`);
      this.showMainMenu(player, playerSettings);
    });
  }

  showOptimizationMenu(player, playerSettings) {
    const optSettings = playerSettings.optimizationSettings;
    const performanceImpact = this.optimizationManager.calculatePerformanceImpact(playerSettings);

    const form = new ModalFormData()
      .title("§l§6Optimization Tools")
      .body(`Performance Impact Reduction: §a${performanceImpact}%`)
      .toggle("Lower Particle Density", optSettings.lowerParticleDensity)
      .toggle("Lower Animation Tick Rate", optSettings.lowerAnimationTickRate)
      .toggle("Disable Post-Processing", optSettings.disablePostProcessing)
      .toggle("Simplify Entity Rendering", optSettings.simplifyEntityRendering)
      .toggle("§c§lLow-Impact Mode (Enables All)", optSettings.lowImpactMode);

    form.show(player).then((response) => {
      if (response.canceled) {
        this.showMainMenu(player, playerSettings);
        return;
      }

      const wasLowerParticles = optSettings.lowerParticleDensity;
      const wasLowerAnimation = optSettings.lowerAnimationTickRate;
      const wasDisablePostProcessing = optSettings.disablePostProcessing;
      const wasSimplifyEntity = optSettings.simplifyEntityRendering;
      const wasLowImpactMode = optSettings.lowImpactMode;

      optSettings.lowerParticleDensity = response.formValues[0];
      optSettings.lowerAnimationTickRate = response.formValues[1];
      optSettings.disablePostProcessing = response.formValues[2];
      optSettings.simplifyEntityRendering = response.formValues[3];
      optSettings.lowImpactMode = response.formValues[4];

      // Apply changes
      if (optSettings.lowerParticleDensity !== wasLowerParticles) {
        this.optimizationManager.toggleLowerParticleDensity(player, playerSettings);
      }
      if (optSettings.lowerAnimationTickRate !== wasLowerAnimation) {
        this.optimizationManager.toggleLowerAnimationTickRate(player, playerSettings);
      }
      if (optSettings.disablePostProcessing !== wasDisablePostProcessing) {
        this.optimizationManager.toggleDisablePostProcessing(player, playerSettings);
      }
      if (optSettings.simplifyEntityRendering !== wasSimplifyEntity) {
        this.optimizationManager.toggleSimplifyEntityRendering(player, playerSettings);
      }
      if (optSettings.lowImpactMode !== wasLowImpactMode) {
        this.optimizationManager.toggleLowImpactMode(player, playerSettings);
      }

      const newImpact = this.optimizationManager.calculatePerformanceImpact(playerSettings);
      player.sendMessage(`§aOptimization settings updated. Performance impact: §e${newImpact}%`);
      this.showMainMenu(player, playerSettings);
    });
  }
}
