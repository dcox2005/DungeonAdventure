package dungeon;


public class Bow implements Weapon
{	
	private String name;
	
	public Bow() {
		this.name = " Bow ";
	}
	
	
	@Override
	public String weaponName() 
	{
		return this.name;
	}//end weaponName
	
	@Override
	public String toString() 
	{
		return " uses thier bow to shoot and arrow at ";
	}//end weaponName

}//end bow
