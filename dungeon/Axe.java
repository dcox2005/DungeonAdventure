package dungeon;


public class Axe implements Weapon {
	
private String name;
	
	public Axe() {
		this.name = " Axe ";
	}
	
	
	@Override
	public String weaponName() 
	{
		return this.name;
	}//end weaponName
	
	@Override
	public String toString() 
	{
		return " swings thier massive battle axe at ";
	}//end weaponName

}
