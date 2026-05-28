package com.creatortools.optimization;

/**
 * Manages optimization settings for Creator Tools
 */
public class OptimizationManager {
	private boolean lowerParticleDensity = false;
	private boolean lowerAnimationTickRate = false;
	private boolean disablePostProcessing = false;
	private boolean simplifyEntityRendering = false;
	private boolean lowImpactMode = false;

	public OptimizationManager() {
		// Initialize optimization manager
	}

	public void toggleLowerParticleDensity() {
		this.lowerParticleDensity = !this.lowerParticleDensity;
	}

	public void toggleLowerAnimationTickRate() {
		this.lowerAnimationTickRate = !this.lowerAnimationTickRate;
	}

	public void toggleDisablePostProcessing() {
		this.disablePostProcessing = !this.disablePostProcessing;
	}

	public void toggleSimplifyEntityRendering() {
		this.simplifyEntityRendering = !this.simplifyEntityRendering;
	}

	public void toggleLowImpactMode() {
		this.lowImpactMode = !this.lowImpactMode;
		if (this.lowImpactMode) {
			enableAllOptimizations();
		} else {
			disableAllOptimizations();
		}
	}

	private void enableAllOptimizations() {
		this.lowerParticleDensity = true;
		this.lowerAnimationTickRate = true;
		this.disablePostProcessing = true;
		this.simplifyEntityRendering = true;
	}

	private void disableAllOptimizations() {
		this.lowerParticleDensity = false;
		this.lowerAnimationTickRate = false;
		this.disablePostProcessing = false;
		this.simplifyEntityRendering = false;
	}

	public void resetAll() {
		this.lowImpactMode = false;
		disableAllOptimizations();
	}

	public int getPerformanceImpactPercentage() {
		int impact = 0;
		if (lowerParticleDensity) impact += 20;
		if (lowerAnimationTickRate) impact += 15;
		if (disablePostProcessing) impact += 25;
		if (simplifyEntityRendering) impact += 20;
		return Math.min(100, impact);
	}

	// Getters
	public boolean isLowerParticleDensity() { return lowerParticleDensity; }
	public boolean isLowerAnimationTickRate() { return lowerAnimationTickRate; }
	public boolean isDisablePostProcessing() { return disablePostProcessing; }
	public boolean isSimplifyEntityRendering() { return simplifyEntityRendering; }
	public boolean isLowImpactMode() { return lowImpactMode; }

	// Setters
	public void setLowerParticleDensity(boolean value) { this.lowerParticleDensity = value; }
	public void setLowerAnimationTickRate(boolean value) { this.lowerAnimationTickRate = value; }
	public void setDisablePostProcessing(boolean value) { this.disablePostProcessing = value; }
	public void setSimplifyEntityRendering(boolean value) { this.simplifyEntityRendering = value; }
	public void setLowImpactMode(boolean value) { this.lowImpactMode = value; }
}
