package dungeon;

public class Fireball implements Weapon{
	
	private String name;
	
	public Fireball() {
		this.name = " Fireball";
	}
	
	public String toString() {
		return " casts a spell of fireball at ";
	}

	@Override
	public String weaponName() {
		// TODO Auto-generated method stub
		return this.name;
	}

}