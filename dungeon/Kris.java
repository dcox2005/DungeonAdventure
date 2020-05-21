package dungeon;

public class Kris implements Weapon 
{	
private String name;
	
	public Kris() {
		this.name = " Kris ";
	}
	@Override
	public String weaponName() 
	{
		return this.name;
	}//end weaponName
	@Override
	public String toString() 
	{
		return " jabs his kris at ";
	}
}//end Kris
