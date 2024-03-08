package game.engine.weapons;

public class WeaponRegistry {
	private final int code;
	private int price;
	private final int damage;
	private String name;
	private int minRange;
	private int maxRange; //et2akedy mn ghaba2ek
	
	public WeaponRegistry(int code, int price) {
		this.code = code;
		this.price = price;
		damage = 0; // check law sah
	}

	public WeaponRegistry(int code, int price, int damage, String name) {
		this.code = code;
		this.price = price;
		this.damage = damage;
		this.name = name;
	}

	public WeaponRegistry(int code, int price, int damage, String name, int minRange, int maxRange) {
		this.code = code;
		this.price = price;
		this.damage = damage;
		this.name = name;
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public int getMinRange() {
		return minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public int getCode() {
		return code;
	}

	public int getDamage() {
		return damage;
	}
	

}
