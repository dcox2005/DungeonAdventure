package dungeon;

public class Archer extends Hero
{

	Archer(String userName) 
	{
		super(userName);
		this.setHitPoints(70);
		this.setAttackSpeed(7);
		this.setChanceToHit(0.8);
		this.setDamageMin(20);
		this.setDamageMax(40);
		this.setChanceToBlock(0.6);
		this.setSpecialAbility(new SupriseAttack());	//TODO Update to MultiShot when it gets created
		this.setWeapon(new Kris());						//TODO Update to Bow when it gets created
    }//end constructor

}//end Archer class
