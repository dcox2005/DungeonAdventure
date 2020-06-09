package dungeon;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Skeleton extends Monster
{
    Skeleton()
	{
		super("Sargath the Skeleton");
		this.setHitPoints(100);
		this.setAttackSpeed(3);
		this.setChanceToHit(0.8);
		this.setChanceToHeal(0.3);
		this.setDamageMin(30);
		this.setDamageMax(50);
		this.setMinHeal(30);
		this.setMaxHeal(50);
		this.setWeapon(new RustyBlade());
    }//end constructor

	

}//end Skeleton class