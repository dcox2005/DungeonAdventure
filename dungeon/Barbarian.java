package dungeon;

public class Barbarian  extends Hero
{

	Barbarian(String userName) 
	{
		super(userName);
		this.setHitPoints(150);
		this.setAttackSpeed(5);
		this.setChanceToHit(0.7);
		this.setDamageMin(45);
		this.setDamageMax(70);
		this.setChanceToBlock(0.1);
		this.setSpecialAbility(new CrushingBlow());
		this.setWeapon(new MightySword());				//TODO Update to Axe when it gets created.
	}//end constructor

}//end Barbarian Class
