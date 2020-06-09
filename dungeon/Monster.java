package dungeon;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public abstract class Monster extends DungeonCharacter
{
	private double chanceToHeal;
	private int minHeal, maxHeal;

	protected Monster(String name)
	{
		super(name);
	}//end monster construcotr

	private void heal()
	{
		boolean canHeal;
		int healPoints;
		canHeal = (Math.random() <= chanceToHeal) && (this.getHitPoints() > 0);
		if (canHeal)
		{
			healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
			addHitPoints(healPoints);
			System.out.println(this.getName() + " healed itself for " + healPoints + " points.\n" + "Total hit points remaining are: " + this.getHitPoints());
			System.out.println();
		}//end can heal

	}//end heal()

	public void getAttacked(int hitPoints)
	{
		super.subtractHitPoints(hitPoints);
		heal();
	}//end subtractHitPoints()
 
/*----------------------------Getters-------------------------------------
 */	
	

	public double getChanceToHeal() 
	{
		return this.chanceToHeal;
	}//end getChanceToHeal
	

	public final int getMinHeal() 
	{
		return this.minHeal;
	}//endgetMinHeal
	

	public final int getMaxHeal() 
	{
		return this.maxHeal;
	}//end getMaxHeal
	
/*----------------------------Setters-------------------------------------
 */	
	

	public void setChanceToHeal(final double chanceToHeal) 
	{
		if (chanceToHeal < 0)
			throw new IllegalArgumentException("chanceToHeal passed into Monster setChanceToHeal was less than 0: " + chanceToHeal);
		
		this.chanceToHeal = chanceToHeal;
	}//end setChanceToHeal
	

	public void setMinHeal(final int minHeal) 
	{
		if (minHeal < 0)
			throw new IllegalArgumentException("minHeal passed into Monster setMinHeal was less than 0: " + minHeal);
		
		this.minHeal = minHeal;
	}//end setMinHeal
	

	public void setMaxHeal(final int maxHeal) 
	{
		if (maxHeal < 0)
			throw new IllegalArgumentException("maxHeal passed into Monster setMaxHeal was less than 0: " + maxHeal);
		
		if (maxHeal < this.minHeal)
			throw new IllegalArgumentException("maxHeal (" + maxHeal + ") passed into Monster setMaxHeal was less than minHeal ( " + this.minHeal + ")");		
		
		this.maxHeal = maxHeal;
	}//end setMaxHeal
	
	public boolean dropHealing() {
		int randomNumber = (int)(Math.random() * 100);
		if (randomNumber < 11)
			return true;
		return false;
	}

}//end Monster class