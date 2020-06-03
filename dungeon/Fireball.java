package dungeon;


public class Fireball implements Weapon{
	
private String name;
	
	public Fireball() {
		this.name = " fireball ";
	}
	
	public String toString() {
		return " propels a fireball at ";
	}

	@Override
	public String weaponName() {
		return this.name;
	}

}
