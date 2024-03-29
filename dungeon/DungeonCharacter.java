package dungeon;

/**
 * Title: DungeonCharacter.java
 *
 * Description: Abstract Base class for inheritance hierarchy for a
 *              role playing game
 *
 *  class variables (all will be directly accessible from derived classes):
 *    name (name of character)
 *    hitPoints (points of damage a character can take before killed)
 *    attackSpeed (how fast the character can attack)
 *    chanceToHit (chance an attack will strike the opponent)
 *    damageMin, damageMax (range of damage the character can inflict on
 *     opponent)
 *
 *  class methods (all are directly accessible by derived classes):
 *    DungeonCharacter(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax)
	  public String getName()
	  public int getHitPoints()
	  public int getAttackSpeed()
	  public void addHitPoints(int hitPoints)
	  public void subtractHitPoints(int hitPoints) -- this method will be
	    overridden
	  public boolean isAlive()
	  public void attack(DungeonCharacter opponent) -- this method will be
	    overridden
 *
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public abstract class DungeonCharacter
{
	private String name;
	private int hitPoints;
	private int attackSpeed;
	private double chanceToHit;
	private int damageMin, damageMax;
	private Weapon weapon;
	
//-----------------------------------------------------------------
//explicit constructor to initialize instance variables -- it is called
// by derived classes
	protected DungeonCharacter(String name)
	{
		this.name = name;
	}//end constructor

/*-------------------------------------------------------
addHitPoints is used to increment the hitpoints a dungeon character has

Receives: number of hit points to add
Returns: nothing

This method calls: nothing
This method is called by: heal method of monsters and Sorceress
---------------------------------------------------------*/
	
	public void addHitPoints(int hitPoints)
	{
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		
		else
			this.hitPoints += hitPoints;
		
	}//end addHitPoints()

/*-------------------------------------------------------
subtractHitPoints is used to decrement the hitpoints a dungeon character has.
It also reports the damage and remaining hit points (these things could be
done in separate methods to make code more modular ;-)

Receives: number of hit points to subtract
Returns: nothing

This method calls: nothing
This method is called by: overridden versions in Hero and Monster
---------------------------------------------------------*/
	public void subtractHitPoints(int hitPoints)
	{
		if (hitPoints <0)
			System.out.println("Hitpoint amount must be positive.");
		
		else if (hitPoints >0)
		{
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			
			System.out.println(getName() + " took " +
								"<" + hitPoints + "> points of damage.");
			System.out.println(getName() + " now has " +
								getHitPoints() + " hit points remaining.");
			System.out.println();
		}//end else if

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");
		
	}//end subtractHitPoints()

/*-------------------------------------------------------
isAlive is used to see if a character is still alive by checking hit points

Receives: nothing
Returns: true is hero is alive, false otherwise

This method calls: nothing
This method is called by: unknown (intended for external use)
---------------------------------------------------------
*/
	
    public boolean isAlive()
	{
	  return (hitPoints > 0);
	}//end isAlive method

/*-------------------------------------------------------
attack allows character to attempt attack on opponent.  First, chance to hit
is considered.  If a hit can occur, then the damage is calculated based on
character's damage range.  This damage is then applied to the opponenet.

Receives: opponent being attacked
Returns: nothing

This method calls: Math.random(), subtractHitPoints()
This method is called by: overridden versions of the method in monster and
hero classes and externally
---------------------------------------------------------*/
    
	public void attack(DungeonCharacter opponent)
	{
		AttackFactory.getBasicAttack().preform(this, opponent);
	}//end attack method
	
	public abstract void getAttacked(int damage);

/*----------------------------Getters-------------------------------------
 */	
	
	public String getName()
	{
		return this.name;
	}//end getName
	
	public int getHitPoints()
	{
		return this.hitPoints;
	}//end getHitPoints	
	
	public int getAttackSpeed()
	{
		return this.attackSpeed;
	}//end getAttackSpeed	
	
	public double getChanceToHit() 
	{
		return this.chanceToHit;
	}//end getChanceToHit

	public int getDamageMin() 
	{
		return this.damageMin;
	}//end getDamageMin

	public int getDamageMax() 
	{
		return this.damageMax;
	}//end getDamageMax

	public Weapon getWeapon() 
	{
		return this.weapon;
	}//end getWeapon
	
/*----------------------------Setters-------------------------------------
 */
	
	protected void setName(final String name)
	{
		if (name == null)
			throw new IllegalArgumentException("name passed into DungeonCharacter setName was null");
		
		this.name = name;
	}//end setName

	protected void setHitPoints(final int hitPoints)
	{
		if (hitPoints <= 0)
			throw new IllegalArgumentException("hitPoints passed into DungeonCharacter setHitPoints was 0 or less: " + hitPoints);
		
		this.hitPoints = hitPoints;
	}//end setHitPoints
	
	public void setAttackSpeed(int attackSpeed) 
	{
		if (attackSpeed <= 0)
			throw new IllegalArgumentException("attackSpeed passed into DungeonCharacter setAttackSpeed was 0 or less: " + attackSpeed);
		
		this.attackSpeed = attackSpeed;
	}//end setAttackSpeed	
	
	public void setChanceToHit(final double chanceToHit) 
	{
		if (chanceToHit <= 0)
			throw new IllegalArgumentException("chanceToHit passed into DungeonCharacter setChanceToHit was 0 or less: " + chanceToHit);
		
		this.chanceToHit = chanceToHit;
	}//end setChanceToHit

	public void setDamageMin(final int damageMin) 
	{
		if (damageMin <= 0)
			throw new IllegalArgumentException("damageMin passed into DungeonCharacter setsetDamageMin was 0 or less: " + damageMin);
		
		this.damageMin = damageMin;
	}//end setDamageMin	
	
	public void setDamageMax(final int damageMax) 
	{
		if (damageMax <= 0)
			throw new IllegalArgumentException("damageMax passed into DungeonCharacter setDamageMax was 0 or less: " + damageMax);
		
		if (damageMax < damageMin)
			throw new IllegalArgumentException("damageMax (" + damageMax + ") passed into DungeonCharacter setDamageMax was less than damageMin: " + this.damageMin);
		
		this.damageMax = damageMax;
	}//end setDamageMax	

	public void setWeapon(Weapon weapon) 
	{
		if (weapon == null)
			throw new IllegalArgumentException("weapon object passed into DungeonCharacter setWeapon was null");
		
		this.weapon = weapon;
	}//end setWeapon	



	
	


	
	

	
	
	

}//end class Character

























