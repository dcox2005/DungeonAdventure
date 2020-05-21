package dungeon;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Warrior extends Hero
{
    Warrior(String userName)
	{
		super(userName);
		this.setHitPoints(125);
		this.setAttackSpeed(4);
		this.setChanceToHit(0.8);
		this.setDamageMin(35);
		this.setDamageMax(60);
		this.setChanceToBlock(0.2);
		this.setSpecialAbility(new CrushingBlow());
		this.setWeapon(new MightySword());
    }//end constructor

}//end Warrior class
