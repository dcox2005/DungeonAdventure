
public class Axe implements Weapon {
	
private String name;
	
	public Club() {
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
		return " Swings thier massive battle axe at ";
	}//end weaponName

}
