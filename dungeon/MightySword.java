package dungeon;

public class MightySword implements Weapon 
{	
private String name;
	
	public MightySword() {
		this.name = " Mighty Sword ";
	}
	@Override
	public String toString() 
	{
		return "swings a mighty sword at ";
	}//end 
	
	public String weaponName() {
		return this.name;
	}
	

}//end MightSword
