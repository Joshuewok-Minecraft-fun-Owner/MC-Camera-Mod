package com.creatortools.ui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import com.creatortools.CreatorToolsMod;

/**
 * Manages UI screens for Creator Tools
 */
public class ScreenManager {

	public static class MainMenuScreen extends Screen {
		public MainMenuScreen(Screen parent) {
			super(Text.literal("Creator Tools"));
		}

		@Override
		protected void init() {
			super.init();

			int centerX = this.width / 2;
			int centerY = this.height / 2;
			int buttonWidth = 150;
			int buttonHeight = 20;
			int spacing = 30;

			// Camera Tools Button
			this.addDrawableChild(new ButtonWidget(
				centerX - buttonWidth / 2,
				centerY - spacing,
				buttonWidth,
				buttonHeight,
				Text.literal("🎥 Camera Tools"),
				button -> this.client.setScreen(new CameraMenuScreen(this))
			));

			// Privacy Tools Button
			this.addDrawableChild(new ButtonWidget(
				centerX - buttonWidth / 2,
				centerY,
				buttonWidth,
				buttonHeight,
				Text.literal("🛡️ Privacy Tools"),
				button -> this.client.setScreen(new PrivacyMenuScreen(this))
			));

			// Optimization Button
			this.addDrawableChild(new ButtonWidget(
				centerX - buttonWidth / 2,
				centerY + spacing,
				buttonWidth,
				buttonHeight,
				Text.literal("🚀 Optimization"),
				button -> this.client.setScreen(new OptimizationMenuScreen(this))
			));

			// Close Button
			this.addDrawableChild(new ButtonWidget(
				centerX - buttonWidth / 2,
				centerY + spacing * 2,
				buttonWidth,
				buttonHeight,
				Text.literal("Close"),
				button -> this.client.setScreen(null)
			));
		}

		@Override
		public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
			this.renderBackground(matrices);
			super.render(matrices, mouseX, mouseY, delta);
		}

		@Override
		public boolean shouldCloseOnEsc() {
			return true;
		}
	}

	public static class CameraMenuScreen extends Screen {
		private final Screen parent;

		public CameraMenuScreen(Screen parent) {
			super(Text.literal("Camera Tools"));
			this.parent = parent;
		}

		@Override
		protected void init() {
			super.init();
			// Camera preset buttons would go here
			this.addDrawableChild(new ButtonWidget(
				this.width / 2 - 75, this.height - 30, 150, 20,
				Text.literal("Back"),
				button -> this.client.setScreen(parent)
			));
		}

		@Override
		public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
			this.renderBackground(matrices);
			this.drawCenteredString(matrices, this.textRenderer, "Select Camera Preset", this.width / 2, 20, 0xFFFFFF);
			super.render(matrices, mouseX, mouseY, delta);
		}

		@Override
		public boolean shouldCloseOnEsc() {
			return true;
		}
	}

	public static class PrivacyMenuScreen extends Screen {
		private final Screen parent;

		public PrivacyMenuScreen(Screen parent) {
			super(Text.literal("Privacy Tools"));
			this.parent = parent;
		}

		@Override
		protected void init() {
			super.init();
			// Privacy toggle buttons would go here
			this.addDrawableChild(new ButtonWidget(
				this.width / 2 - 75, this.height - 30, 150, 20,
				Text.literal("Back"),
				button -> this.client.setScreen(parent)
			));
		}

		@Override
		public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
			this.renderBackground(matrices);
			this.drawCenteredString(matrices, this.textRenderer, "Privacy Settings", this.width / 2, 20, 0xFFFFFF);
			super.render(matrices, mouseX, mouseY, delta);
		}

		@Override
		public boolean shouldCloseOnEsc() {
			return true;
		}
	}

	public static class OptimizationMenuScreen extends Screen {
		private final Screen parent;

		public OptimizationMenuScreen(Screen parent) {
			super(Text.literal("Optimization"));
			this.parent = parent;
		}

		@Override
		protected void init() {
			super.init();
			// Optimization toggle buttons would go here
			this.addDrawableChild(new ButtonWidget(
				this.width / 2 - 75, this.height - 30, 150, 20,
				Text.literal("Back"),
				button -> this.client.setScreen(parent)
			));
		}

		@Override
		public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
			this.renderBackground(matrices);
			this.drawCenteredString(matrices, this.textRenderer, "Optimization Tools", this.width / 2, 20, 0xFFFFFF);
			super.render(matrices, mouseX, mouseY, delta);
		}

		@Override
		public boolean shouldCloseOnEsc() {
			return true;
		}
	}
}
