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
    public Warrior()
	{
		super("Warrior");
//		, 125, 4, .8, 35, 60, .2);
		this.setHitPoints(125);
		this.setAttackSpeed(4);
		this.setChanceToHit(0.8);
		this.setDamageMin(35);
		this.setDamageMax(60);
		this.setChanceToBlock(0.2);
    }//end constructor

	public void crushingBlow(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
//			System.out.println(name + " lands a CRUSHING BLOW for " + blowPoints
//								+ " damage!");
			System.out.println(this.getName() + " lands a CRUSHING BLOW for " + blowPoints + " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		
		else
		{
//			System.out.println(name + " failed to land a crushing blow");
			System.out.println(this.getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed

	}//end crushingBlow method

	public void attack(DungeonCharacter opponent)
	{
//		System.out.println(name + " swings a mighty sword at " +
//							opponent.getName() + ":");
		System.out.println(this.getName() + " swings a mighty sword at " + opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

   

}//end Warrior class
