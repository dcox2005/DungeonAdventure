package dungeon;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Sorceress extends Hero
{
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

    Sorceress(String userName)
	{
		super(userName);
		this.setHitPoints(75);
		this.setAttackSpeed(5);
		this.setChanceToHit(0.7);
		this.setDamageMin(25);
		this.setDamageMax(50);
		this.setChanceToBlock(0.3);
		this.setSpecialAbility(new SelfHeal(MIN_ADD, MAX_ADD));
		this.setWeapon(new Fireball());
    }//end constructor
    
}//end Sorceress class
