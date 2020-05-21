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

    public Sorceress()
	{
		super("Sorceress");
//		, 75, 5, .7, 25, 50, .3);
		this.setHitPoints(75);
		this.setAttackSpeed(5);
		this.setChanceToHit(0.7);
		this.setDamageMin(25);
		this.setDamageMax(50);
		this.setChanceToBlock(0.3);
    }//end constructor

	public void increaseHitPoints()
    {
	    int hPoints;
		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);
/*		System.out.println(name + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ hitPoints);
*/		System.out.println(this.getName() + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: " + this.getHitPoints());
		System.out.println();
    }//end increaseHitPoints()



}//end Sorceress class
