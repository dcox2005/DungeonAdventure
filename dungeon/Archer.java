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
		this.setSpecialAbility(AttackFactory.getMultishotAttack());
		this.setWeapon(new Bow());				
    }//end constructor

}//end Archer class
