package dungeon;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Thief extends Hero
{
    public Thief()
	{
		super("Thief");
//		, 75, 6, .8, 20, 40, .5);
		this.setHitPoints(75);
		this.setAttackSpeed(6);
		this.setChanceToHit(0.8);
		this.setDamageMin(20);
		this.setDamageMax(40);
		this.setChanceToBlock(0.5);
    }//end constructor

	public void surpriseAttack(DungeonCharacter opponent)
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
/*			System.out.println("Surprise attack was successful!\n" +
								name + " gets an additional turn.");
			numTurns++;
*/
			System.out.println("Surprise attack was successful!\n" + this.getName() + " gets an additional turn.");
			this.setNumTurns(this.getNumTurns() + 1);
			attack(opponent);
		}//end surprise
		
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}//end else if
		
		else
		    attack(opponent);
		
	}//end surpriseAttack method

    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;
		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Surprise Attack");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();
		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: surpriseAttack(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

/*			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);
*/
		    this.setNumTurns(this.getNumTurns() - 1);
			if (this.getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + this.getNumTurns());

		}while(this.getNumTurns() > 0);
		    
    }//end battleChoices
    
}//end Thief class