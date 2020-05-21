package dungeon;

public class Club implements Weapon
{	
	private String name;
	
	public Club() {
		this.name = " Club ";
	}
	
	
	@Override
	public String weaponName() 
	{
		return this.name;
	}//end weaponName
	
	@Override
	public String toString() 
	{
		return " slowly swings a club toward's ";
	}//end weaponName

}//end Club
