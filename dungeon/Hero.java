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
	private int numTurns, numOfHealingPotion, numOfVisionPotion, numOfPillarsFound;
	private Attack specialAbility;

//calls base constructor and gets name of hero from user
	protected Hero(String name)
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
	private boolean defend()
	{
		return Math.random() <= chanceToBlock;
	}//end defend()
	

	public void getAttacked(int hitPoints)
	{
		if (defend())
		{
			System.out.println(this.getName() + " BLOCKED the attack!");
		}//end if
		
		else
			super.subtractHitPoints(hitPoints);
		
	}//end subtractHitPoints()


	public void battleChoices(DungeonCharacter opponent){
		int choice;
	    numTurns = this.getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

				do
				{
					do
					{
					    System.out.println("1. Attack Opponent");
					    System.out.println("2. " + this.specialAbility.getName());
					    System.out.print("Choose an option: ");
					    choice = Keyboard.readInt();
					} while(choice != 1 || choice != 2);

				    switch (choice)
				    {
					    case 1: attack(opponent);
					        break;
					    case 2: specialAbility.preform(this, opponent);
					        break;
					    default:
					        System.out.println("invalid choice!");
				    }//end switch

					 this.setNumTurns(this.getNumTurns() - 1);
			if (this.getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + this.getNumTurns());

		}while(this.getNumTurns() > 0 && opponent.getHitPoints() > 0);

		    }//end battleChoices method
	
	
	public String toString() {
		return "Name: " +getName()  +"\n" +"HitPoint: " +getHitPoints() +"\n" +"Number of Healing Potions: " +getnumOfHealingPotion()
				+"\n" +"Number of Visison Poitons: " +getnumOfVisionPotion() +"\n" +"Number of Pillers Found" +getNumOfPillarsFound();
		
	}

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
	
	public int getnumOfHealingPotion()
	{
		return numOfHealingPotion;
	}
	
	public int getnumOfVisionPotion()
	{
		return numOfVisionPotion;
	}
	
	public int getNumOfPillarsFound()
	{
		return numOfPillarsFound;
	}
	
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
	
	public void setSpecialAbility(Attack specialAbility) {
		this.specialAbility = specialAbility;
	}//end setSpecialAbility()
	
	public void setNumOfHealingPotion(int numOfPotions) {
		this.numOfHealingPotion = numOfPotions;
	}
	
	public void setNumOfVisionPotion(int numOfPotions) {
		this.numOfVisionPotion = numOfPotions;
	}
	
	public void setNumOfPillarsFound(int numOfPillars) {
		this.numOfPillarsFound = numOfPillars;
	}
	
	public void UseHealing() {
		HealingPotion.useItem(this);
		this.numOfHealingPotion = this.numOfHealingPotion -1;
		
	}
	
	public void UseVision(Dungeon dungeon) {
		VisionPotion.useItem(dungeon);
		this.numOfVisionPotion = this.numOfVisionPotion -1;
	}

	public boolean victory(Dungeon theDungeon) {
		int[] local = theDungeon.getHeroLocation();
		Room[][] room = theDungeon.getDungeon();
		if(room[local[0]][local[1]].hasExit() && this.getNumOfPillarsFound() == 4)
			return true;
		return false;
	}
	public boolean defeated() {
		return !this.isAlive(); 
	}
	
}//end Hero class
