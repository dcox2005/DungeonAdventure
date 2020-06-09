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

    Sorceress(String userName)
	{
		super(userName);
		this.setHitPoints(75);
		this.setAttackSpeed(5);
		this.setChanceToHit(0.7);
		this.setDamageMin(25);
		this.setDamageMax(50);
		this.setChanceToBlock(0.3);
		this.setSpecialAbility(AttackFactory.getSelfHealAttack());
		this.setWeapon(new Fireball());
    }//end constructor
    
}//end Sorceress class
