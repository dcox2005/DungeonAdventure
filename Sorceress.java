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
		this.setSpecialAbility(new SelfHeal(MIN_ADD, MAX_ADD));
    }//end constructor
}//end Sorceress class