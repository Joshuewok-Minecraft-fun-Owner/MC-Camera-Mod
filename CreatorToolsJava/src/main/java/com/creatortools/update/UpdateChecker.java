package com.creatortools.update;

import com.creatortools.CreatorToolsMod;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Auto-update checker for Creator Tools
 * Checks GitHub for new releases and notifies players
 */
public class UpdateChecker {
	private static final Logger LOGGER = LoggerFactory.getLogger("CreatorToolsUpdater");
	private static final String GITHUB_API_URL = "https://api.github.com/repos/Joshuewok-Minecraft-fun-Owner/Bedrock-Camera-Mod/releases/latest";
	private static final String MOD_VERSION = CreatorToolsMod.MOD_VERSION;

	private String latestVersion = null;
	private String downloadURL = null;
	private boolean updateAvailable = false;

	public UpdateChecker() {
		// Initialize update checker
	}

	/**
	 * Check for updates asynchronously
	 */
	public void checkForUpdates() {
		Thread updateThread = new Thread(() -> {
			try {
				checkForUpdatesSync();
			} catch (Exception e) {
				LOGGER.warn("Failed to check for updates: {}", e.getMessage());
			}
		});
		updateThread.setName("CreatorTools-UpdateChecker");
		updateThread.setDaemon(true);
		updateThread.start();
	}

	/**
	 * Synchronous update check
	 */
	private void checkForUpdatesSync() throws Exception {
		HttpClient client = HttpClient.newBuilder()
			.connectTimeout(Duration.ofSeconds(10))
			.build();

		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(GITHUB_API_URL))
			.header("Accept", "application/vnd.github+json")
			.GET()
			.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		if (response.statusCode() == 200) {
			JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
			String tagName = json.get("tag_name").getAsString().replace("v", "");
			
			this.latestVersion = tagName;
			this.downloadURL = json.get("html_url").getAsString();

			if (isNewerVersion(tagName, MOD_VERSION)) {
				this.updateAvailable = true;
				LOGGER.info("Update available for Creator Tools: {} (current: {})", tagName, MOD_VERSION);
				LOGGER.info("Download at: {}", this.downloadURL);
			}
		}
	}

	/**
	 * Compare version strings
	 * Returns true if newVersion > currentVersion
	 */
	private boolean isNewerVersion(String newVersion, String currentVersion) {
		String[] newParts = newVersion.split("\\.");
		String[] currentParts = currentVersion.split("\\.");

		int maxLength = Math.max(newParts.length, currentParts.length);

		for (int i = 0; i < maxLength; i++) {
			int newPart = i < newParts.length ? Integer.parseInt(newParts[i]) : 0;
			int currentPart = i < currentParts.length ? Integer.parseInt(currentParts[i]) : 0;

			if (newPart > currentPart) return true;
			if (newPart < currentPart) return false;
		}
		return false;
	}

	// Getters
	public String getLatestVersion() { return latestVersion; }
	public String getDownloadURL() { return downloadURL; }
	public boolean isUpdateAvailable() { return updateAvailable; }
	public String getCurrentVersion() { return MOD_VERSION; }
}
