package game.engine.dataloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import game.engine.titans.TitanRegistry;
import game.engine.weapons.WeaponRegistry;

public class DataLoader {
	private static final String TITANS_FILE_NAME = "titans.csv";
	private static final String WEAPONS_FILE_NAME = "weapons.csv";

	public DataLoader() {
	}

	public static HashMap<Integer, TitanRegistry> readTitanRegistry() throws IOException {
		HashMap<Integer, TitanRegistry> hm = new HashMap<Integer, TitanRegistry>();
		BufferedReader br = new BufferedReader(new FileReader(TITANS_FILE_NAME)); // code, baseHealth, baseDamage,
																					// heightInMeters, speed,
																					// resourcesValue, dangerLevel
		String line = br.readLine();
		while (line != null) {
			String[] content = line.split(",");
			int titanCode = Integer.parseInt(content[0]);
			TitanRegistry titanReg = new TitanRegistry(titanCode, Integer.parseInt(content[1]),
					Integer.parseInt(content[2]), Integer.parseInt(content[3]), Integer.parseInt(content[4]),
					Integer.parseInt(content[5]), Integer.parseInt(content[6]));
			hm.put(titanCode, titanReg);
			line = br.readLine();
		}
		br.close();
		return hm;
	}

	public static HashMap<Integer, WeaponRegistry> readWeaponRegistry() throws IOException {
		HashMap<Integer, WeaponRegistry> hm = new HashMap<Integer, WeaponRegistry>();
		BufferedReader br = new BufferedReader(new FileReader(WEAPONS_FILE_NAME)); // code, price, damage, name, minRange, maxRange
		String line = br.readLine();
		while (line != null) {
			String[] content = line.split(",");
			int weaponCode = Integer.parseInt(content[0]);
			WeaponRegistry weaponReg; // WeaponRegistry(int code, int price, int damage, String name, int minRange, int maxRange)
			if (content.length == 6) {
				weaponReg = new WeaponRegistry(weaponCode, Integer.parseInt(content[1]), Integer.parseInt(content[2]),
						content[3], Integer.parseInt(content[4]), Integer.parseInt(content[5])); // VolleySpreadCannon
			} else {
				weaponReg = new WeaponRegistry(weaponCode, Integer.parseInt(content[1]), Integer.parseInt(content[2]),
						content[3]); // PiercingCannon, SniperCannon, WallTrap
			}
			hm.put(weaponCode, weaponReg);
			System.out.println(line);
			line = br.readLine();
		}
		br.close();
		return hm;
	}

	public static String getTitansFileName() {
		return TITANS_FILE_NAME;
	}

	public static String getWeaponsFileName() {
		return WEAPONS_FILE_NAME;
	}

}
