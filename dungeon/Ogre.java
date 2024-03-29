package dungeon;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Ogre extends Monster
{
    Ogre()
	{
		super("Oscar the Ogre");
		this.setHitPoints(200);
		this.setAttackSpeed(2);
		this.setChanceToHit(0.6);
		this.setChanceToHeal(0.1);
		this.setDamageMin(30);
		this.setDamageMax(50);
		this.setMinHeal(30);
		this.setMaxHeal(50);
		this.setWeapon(new Club());
    }//end constructor

}//end Ogre class