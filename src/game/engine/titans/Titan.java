package game.engine.titans;

import game.engine.interfaces.*;

public abstract class Titan implements Comparable<Titan>, Attacker, Attackee, Mobil{

	private final int baseHealth;
	private int currentHealth;
	private final int baseDamage;
	private final int heightInMeters;
	private int distanceFromBase;
	private int speed;
	private final int resourcesValue;
	private final int dangerLevel;

	public Titan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed,
			int resourcesValue, int dangerLevel) {
		this.baseHealth = baseHealth;
		currentHealth = baseHealth;
		this.baseDamage = baseDamage;
		this.heightInMeters = heightInMeters;
		this.distanceFromBase = distanceFromBase;
		this.speed = speed;
		this.resourcesValue = resourcesValue;
		this.dangerLevel = dangerLevel;
	}

	public int compareTo(Titan o) { // check sah wala la2 fel comparing also el syntax fel pdf eno byakhod Titan mesh Object
		int d1 = distanceFromBase;
		int d2 = o.distanceFromBase;
		if (d1 < d2) {
			return -1;
		}
		if (d1 > d2) {
			return 1;
		}
		return 0;
	}
	
	public int getDamage() {
		return baseDamage;
	}

	public int getDistance() {
		return distanceFromBase;
	}

	public void setDistance(int distance) {
		distanceFromBase = distance;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		if(currentHealth<0) {
			this.currentHealth=0;
			return;
		}
		this.currentHealth = currentHealth;
	}

	public int getDistanceFromBase() {
		return distanceFromBase;
	}

	public void setDistanceFromBase(int distanceFromBase) { //set?
		this.distanceFromBase = distanceFromBase;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getBaseHealth() {
		return baseHealth;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public int getHeightInMeters() {
		return heightInMeters;
	}

	public int getResourcesValue() {
		return resourcesValue;
	}

	public int getDangerLevel() {
		return dangerLevel;
	}

}
