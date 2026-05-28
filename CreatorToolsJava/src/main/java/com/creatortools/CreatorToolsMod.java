package com.creatortools;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.creatortools.update.UpdateChecker;
import com.creatortools.camera.CameraManager;
import com.creatortools.privacy.PrivacyManager;
import com.creatortools.optimization.OptimizationManager;
import com.creatortools.ui.ScreenManager;

public class CreatorToolsMod implements ClientModInitializer {
	public static final String MOD_ID = "creatortools";
	public static final String MOD_VERSION = "1.0.0";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static CameraManager cameraManager;
	public static PrivacyManager privacyManager;
	public static OptimizationManager optimizationManager;
	public static UpdateChecker updateChecker;

	private static KeyBinding openMenuKey;

	@Override
	public void onInitializeClient() {
		LOGGER.info("Initializing Creator Tools v{}", MOD_VERSION);

		// Initialize managers
		cameraManager = new CameraManager();
		privacyManager = new PrivacyManager();
		optimizationManager = new OptimizationManager();
		updateChecker = new UpdateChecker();

		// Register keybindings
		registerKeybindings();

		// Register tick event
		ClientTickEvents.END_CLIENT_TICK.register(this::onClientTick);

		// Check for updates
		updateChecker.checkForUpdates();

		LOGGER.info("Creator Tools initialized successfully!");
	}

	private void registerKeybindings() {
		openMenuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			"key.creatortools.open_menu",
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_P,
			"category.creatortools"
		));
	}

	private void onClientTick(MinecraftClient client) {
		if (openMenuKey.wasPressed()) {
			if (client.currentScreen == null) {
				client.setScreen(new ScreenManager.MainMenuScreen(null));
			}
		}
	}
}
