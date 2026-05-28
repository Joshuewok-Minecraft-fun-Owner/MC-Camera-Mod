package com.creatortools.privacy;

/**
 * Manages privacy settings for Creator Tools
 */
public class PrivacyManager {
	private boolean hideServerIPs = false;
	private boolean hideChat = false;
	private boolean hidePlayerNames = false;
	private boolean hideHUD = false;
	private boolean hideCoordinates = false;

	public PrivacyManager() {
		// Initialize privacy manager
	}

	public void toggleHideServerIPs() {
		this.hideServerIPs = !this.hideServerIPs;
	}

	public void toggleHideChat() {
		this.hideChat = !this.hideChat;
	}

	public void toggleHidePlayerNames() {
		this.hidePlayerNames = !this.hidePlayerNames;
	}

	public void toggleHideHUD() {
		this.hideHUD = !this.hideHUD;
	}

	public void toggleHideCoordinates() {
		this.hideCoordinates = !this.hideCoordinates;
	}

	public void resetAll() {
		this.hideServerIPs = false;
		this.hideChat = false;
		this.hidePlayerNames = false;
		this.hideHUD = false;
		this.hideCoordinates = false;
	}

	// Getters
	public boolean isHideServerIPs() { return hideServerIPs; }
	public boolean isHideChat() { return hideChat; }
	public boolean isHidePlayerNames() { return hidePlayerNames; }
	public boolean isHideHUD() { return hideHUD; }
	public boolean isHideCoordinates() { return hideCoordinates; }

	public boolean isPrivacyModeEnabled() {
		return hideServerIPs || hideChat || hidePlayerNames || hideHUD || hideCoordinates;
	}

	// Setters
	public void setHideServerIPs(boolean value) { this.hideServerIPs = value; }
	public void setHideChat(boolean value) { this.hideChat = value; }
	public void setHidePlayerNames(boolean value) { this.hidePlayerNames = value; }
	public void setHideHUD(boolean value) { this.hideHUD = value; }
	public void setHideCoordinates(boolean value) { this.hideCoordinates = value; }
}
