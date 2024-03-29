package dungeon;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Gremlin extends Monster
{
    Gremlin()
	{
		super("Gnarltooth the Gremlin");
		this.setHitPoints(70);
		this.setAttackSpeed(5);
		this.setChanceToHit(0.8);
		this.setChanceToHeal(0.4);
		this.setDamageMin(15);
		this.setDamageMax(30);
		this.setMinHeal(20);
		this.setMaxHeal(40);
		this.setWeapon(new Kris());
    }//end constructor


}//end Gremlin class