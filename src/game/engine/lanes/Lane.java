package game.engine.lanes;

import java.util.ArrayList;
import java.util.PriorityQueue;
import game.engine.base.Wall;
import game.engine.titans.*;
import game.engine.weapons.*;

public class Lane implements Comparable<Lane> {
	private final Wall laneWall;
	private int dangerLevel = 0;
	private final PriorityQueue<Titan> titans;
	private final ArrayList<Weapon> weapons;

	public Lane(Wall laneWall) {
		this.laneWall = laneWall;
		titans = new PriorityQueue<Titan>();
		weapons = new ArrayList<Weapon>();
	}

	public int compareTo(Lane o) {
		return dangerLevel - o.dangerLevel;
	}

	public int getDangerLevel() {
		return dangerLevel;
	}

	public void setDangerLevel(int dangerLevel) { //set?
		this.dangerLevel = dangerLevel;
	}

	public Wall getLaneWall() {
		return laneWall;
	}

	public PriorityQueue<Titan> getTitans() {
		return titans;
	}

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

}
