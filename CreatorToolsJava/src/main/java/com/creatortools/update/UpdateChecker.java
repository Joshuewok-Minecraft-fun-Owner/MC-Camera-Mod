package com.creatortools.update;

import com.creatortools.CreatorToolsMod;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
	private static final String GITHUB_API_URL = "https://api.github.com/repos/Joshuewok-Minecraft-fun-Owner/MC-Camera-Mod/releases";
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
			// Parse releases array and find the latest Java release
			JsonArray releases = JsonParser.parseString(response.body()).getAsJsonArray();
			
			for (int i = 0; i < releases.size(); i++) {
				JsonObject release = releases.get(i).getAsJsonObject();
				String tagName = release.get("tag_name").getAsString();
				
				// Only process Java releases
				if (!tagName.contains("-java")) {
					continue;
				}
				
				// Extract version from tag (v1.0.1-java -> 1.0.1)
				String version = tagName.replace("v", "").replace("-java", "");
				
				this.latestVersion = version;
				this.downloadURL = release.get("html_url").getAsString();

				if (isNewerVersion(version, MOD_VERSION)) {
					this.updateAvailable = true;
					LOGGER.info("Update available for Creator Tools: {} (current: {})", version, MOD_VERSION);
					LOGGER.info("Download at: {}", this.downloadURL);
				}
				break; // Found latest Java release, stop searching
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
