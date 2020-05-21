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
		this.setSpecialAbility(new CrushingBlow());
    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
//		System.out.println(name + " swings a mighty sword at " +
//							opponent.getName() + ":");
		System.out.println(this.getName() + " swings a mighty sword at " + opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

   

}//end Warrior class
