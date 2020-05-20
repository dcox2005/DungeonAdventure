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
    public Skeleton()
	{
		super("Sargath the Skeleton");
//		, 100, 3, .8, .3, 30, 50, 30, 50);
		this.setHitPoints(100);
		this.setAttackSpeed(3);
		this.setChanceToHit(0.8);
		this.setChanceToHeal(0.3);
		this.setDamageMin(30);
		this.setDamageMax(50);
		this.setMinHeal(30);
		this.setMaxHeal(50);
    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
//		System.out.println(name + " slices his rusty blade at " +
//							opponent.getName() + ":");
		System.out.println(this.getName() + " slices his rusty blade at " + opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack

}//end Skeleton class