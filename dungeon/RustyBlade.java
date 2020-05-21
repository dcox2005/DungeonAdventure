package dungeon;

public class RustyBlade implements Weapon 
{	
private String name;
	
	public RustyBlade() {
		this.name = " Rusty Blade ";
	}
	@Override
	public String weaponName() 
	{
		return this.name;
	}//end weaponName
	
	@Override
	public String toString() {
		String str = " slices a rusty sword at ";
	return str;
	}
}//end RustyBlade
