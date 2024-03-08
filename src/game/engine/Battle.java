package game.engine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap; //testing git
import java.util.PriorityQueue;

import game.engine.base.Wall;
import game.engine.dataloader.DataLoader;
import game.engine.lanes.Lane;
import game.engine.titans.Titan;
import game.engine.titans.TitanRegistry;
import game.engine.weapons.WeaponRegistry;
import game.engine.weapons.factory.WeaponFactory;

public class Battle {
	private static final int[][] PHASES_APPROACHING_TITANS = {
		{ 1, 1, 1, 2, 1, 3, 4 },
		{ 2, 2, 2, 1, 3, 3, 4 },
		{ 4, 4, 4, 4, 4, 4, 4 } 
	};
	private static final int WALL_BASE_HEALTH = 10000;
	private int numberOfTurns;
	private int resourcesGathered;
	private BattlePhase battlePhase;
	private int numberOfTitansPerTurn;
	private int score;
	private int titanSpawnDistance;
	private final WeaponFactory weaponFactory;
	private final HashMap<Integer, TitanRegistry> titansArchives;
	private final ArrayList<Titan> approachingTitans;
	private final PriorityQueue<Lane> lanes;
	private final ArrayList<Lane> originalLanes;

	public Battle(int numberOfTurns, int score, int titanSpawnDistance, int initialNumOfLanes, int initialResourcesPerLane) throws IOException{
		
		this.numberOfTurns = numberOfTurns;
		resourcesGathered = initialNumOfLanes * initialResourcesPerLane;
		battlePhase = BattlePhase.EARLY;
		numberOfTitansPerTurn = 1;
		this.score = score;
		this.titanSpawnDistance = titanSpawnDistance;
		weaponFactory = new WeaponFactory();
		titansArchives = DataLoader.readTitanRegistry();
		approachingTitans = new ArrayList<Titan>();
		lanes = new PriorityQueue<Lane>();
		originalLanes = new ArrayList<Lane>();
		initializeLanes(initialNumOfLanes);
	}
	
	private void initializeLanes(int numOfLanes) {
		for(int i=0;i<numOfLanes;i++) {
			Lane tmpLane = new Lane(new Wall(WALL_BASE_HEALTH));
			lanes.add(tmpLane);
			originalLanes.add(tmpLane);
		}
	}

	public int getNumberOfTurns() {
		return numberOfTurns;
	}

	public void setNumberOfTurns(int numberOfTurns) {
		this.numberOfTurns = numberOfTurns;
	}

	public int getResourcesGathered() {
		return resourcesGathered;
	}

	public void setResourcesGathered(int resourcesGathered) {
		this.resourcesGathered = resourcesGathered;
	}

	public BattlePhase getBattlePhase() {
		return battlePhase;
	}

	public void setBattlePhase(BattlePhase battlePhase) {
		this.battlePhase = battlePhase;
	}

	public int getNumberOfTitansPerTurn() {
		return numberOfTitansPerTurn;
	}

	public void setNumberOfTitansPerTurn(int numberOfTitansPerTurn) {
		this.numberOfTitansPerTurn = numberOfTitansPerTurn;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTitanSpawnDistance() {
		return titanSpawnDistance;
	}

	public void setTitanSpawnDistance(int titanSpawnDistance) {
		this.titanSpawnDistance = titanSpawnDistance;
	}

	public static int[][] getPhasesApproachingTitans() {
		return PHASES_APPROACHING_TITANS;
	}

	public static int getWallBaseHealth() {
		return WALL_BASE_HEALTH;
	}

	public WeaponFactory getWeaponFactory() {
		return weaponFactory;
	}

	public HashMap<Integer, TitanRegistry> getTitansArchives() {
		return titansArchives;
	}

	public ArrayList<Titan> getApproachingTitans() {
		return approachingTitans;
	}

	public PriorityQueue<Lane> getLanes() {
		return lanes;
	}

	public ArrayList<Lane> getOriginalLanes() {
		return originalLanes;
	}
	
//	public static void main(String[] args) throws IOException{
//		HashMap<Integer, TitanRegistry> hm= new HashMap<Integer, TitanRegistry>();
//		BufferedReader br = new BufferedReader(new FileReader("titans.csv")); //code, baseHealth, baseDamage, heightInMeters, speed, resourcesValue, dangerLevel
//		String line = br.readLine();
//		while (line != null) {
//			String[] content = line.split(",");
//			int titanCode = Integer.parseInt(content[0]);
//			TitanRegistry titanReg = new TitanRegistry(titanCode, Integer.parseInt(content[1]), Integer.parseInt(content[2]), Integer.parseInt(content[3]), Integer.parseInt(content[4]), Integer.parseInt(content[5]), Integer.parseInt(content[6]));
//			hm.put(titanCode, titanReg);
//			line = br.readLine();
//		}
//		br.close();
//	}

}
