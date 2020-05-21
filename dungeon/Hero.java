package dungeon;

/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 *  from DungeonCharacter.  A Hero has battle choices: regular attack and a
 *  special skill which is defined by the classes derived from Hero.
 *
 *  class variables (all are directly accessible from derived classes):
 *    chanceToBlock -- a hero has a chance to block an opponents attack
 *    numTurns -- if a hero is faster than opponent, their is a possibility
 *                for more than one attack per round of battle
 *
 *  class methods (all are public):
 *    public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	  public void readName()
	  public boolean defend()
	  public void subtractHitPoints(int hitPoints)
	  public void battleChoices(DungeonCharacter opponent)

 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private int numTurns;
	private SpecialAbility specialAbility;

//calls base constructor and gets name of hero from user
	public Hero(String name)
	{
		super(name); 
	}//end constructor

/*-------------------------------------------------------
defend determines if hero blocks attack

Receives: nothing
Returns: true if attack is blocked, false otherwise

This method calls: Math.random()
This method is called by: subtractHitPoints()
---------------------------------------------------------*/
	public boolean defend()
	{
		return Math.random() <= chanceToBlock;
	}//end defend()
	
/*-------------------------------------------------------
subtractHitPoints checks to see if hero blocked attack, if so a message
is displayed, otherwise base version of this method is invoked to
perform the subtraction operation.  This method overrides the method
inherited from DungeonCharacter promoting polymorphic behavior

Receives: hit points to subtract
Returns: nothing

This method calls: defend() or base version of method
This method is called by: attack() from base class
---------------------------------------------------------*/
	public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(this.getName() + " BLOCKED the attack!");
		}//end if
		
		else
			super.subtractHitPoints(hitPoints);
		
	}//end subtractHitPoints()

/*-------------------------------------------------------
battleChoices will be overridden in derived classes.  It computes the
number of turns a hero will get per round based on the opponent that is
being fought.  The number of turns is reported to the user.  This stuff might
go better in another method that is invoked from this one...

Receives: opponent
Returns: nothing

This method calls: getAttackSpeed()
This method is called by: external sources
---------------------------------------------------------*/
	public void battleChoices(DungeonCharacter opponent){
		int choice;
	    numTurns = this.getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

				do
				{
				    System.out.println("1. Attack Opponent");
				    System.out.println("2. " + this.specialAbility.getName());
				    System.out.print("Choose an option: ");
				    choice = Keyboard.readInt();

				    switch (choice)
				    {
					    case 1: this.attack(opponent);
					        break;
					    case 2: this.specialAbility.preform(this, opponent);
					        break;
					    default:
					        System.out.println("invalid choice!");
				    }//end switch

					 this.setNumTurns(this.getNumTurns() - 1);
			if (this.getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + this.getNumTurns());

		}while(this.getNumTurns() > 0);

		    }//end battleChoices method

/*----------------------------Getters-------------------------------------
 */
	
	public double getChanceToBlock() 
	{
		return this.chanceToBlock;
	}//end getChanceToBlock

	public int getNumTurns() 
	{
		return this.numTurns;
	}//end getNumTurns
	
/*----------------------------Setters-------------------------------------
*/	

	public void setChanceToBlock(double chanceToBlock) 
	{
		if (chanceToBlock < 0)
			throw new IllegalArgumentException("chanceToBlock passed into Hero setChanceToBlock was less than 0: " + chanceToBlock);
		
		this.chanceToBlock = chanceToBlock;
	}//end setChanceToBlock

	public void setNumTurns(int numTurns) 
	{
		if (numTurns < 0)
			throw new IllegalArgumentException("numTurns passed into Hero setNumTurns was 0 or less: " + numTurns);
		
		this.numTurns = numTurns;
	}//end setNumTurns
	
	public void setSpecialAbility(SpecialAbility specialAbility) {
		this.specialAbility = specialAbility;
	}//end setSpecialAbility()
	
}//end Hero class
