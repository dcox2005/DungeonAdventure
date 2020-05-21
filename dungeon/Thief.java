package dungeon;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Thief extends Hero
{
    public Thief(String userName)
	{
		super(userName);
		this.setHitPoints(75);
		this.setAttackSpeed(6);
		this.setChanceToHit(0.8);
		this.setDamageMin(20);
		this.setDamageMax(40);
		this.setChanceToBlock(0.5);
		this.setSpecialAbility(new SupriseAttack());
		this.setWeapon(new Kris());
    }//end constructor
    
}//end Thief class
