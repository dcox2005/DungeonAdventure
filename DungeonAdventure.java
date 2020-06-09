import dungeon.*;

/**
 * Title: Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * I.M. Knurdy
 *
 * History:
 *  11/4/2001: Wrote program
 *    --created DungeonCharacter class
 *    --created Hero class
 *    --created Monster class
 *    --had Hero battle Monster
 *    --fixed attack quirks (dead monster can no longer attack)
 *    --made Hero and Monster abstract
 *    --created Warrior
 *    --created Ogre
 *    --made Warrior and Ogre battle
 *    --added battleChoices to Hero
 *    --added special skill to Warrior
 *    --made Warrior and Ogre battle
 *    --created Sorceress
 *    --created Thief
 *    --created Skeleton
 *    --created Gremlin
 *    --added game play features to Dungeon.java (this file)
 *  11/27/2001: Finished documenting program
 * version 1.0
 */

/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/

public class DungeonAdventure
{
    public static void main(String[] args)
	{
		Hero theHero;
		Dungeon theDungeon;
		
		
		do
		{	theHero = HeroFactory.createNewHero(); //chooseHero();
			theDungeon = new Dungeon();
		  
		   
		    do{ int [] local = theDungeon.getHeroLocation();
		    	Room start = theDungeon.getRoom(local[0], local[1]);
		    	System.out.print("your are here \n" + start.toString() +"\n");
		    	System.out.println("1. Go North ^");
		    	System.out.println("2. Go East >");
		    	System.out.println("3. Go South v");
		    	System.out.println("4. Go West <");
		    	if(theHero.getnumOfVisionPotion() > 0)
		    	System.out.println("5. Use Vision Potion");
		    	if(theHero.getnumOfHealingPotion() > 0)
			    System.out.println("6. Use Healing Potion");
		    	System.out.print("Choose an option: ");
		    	int choice = Keyboard.readInt();
		    

		    switch (choice){	
		   
			    case 1: local = theDungeon.getHeroLocation();
	    				theDungeon.newLocation(theHero, local[0] + 1, local[1]);
	    				break;
			    case 2: local = theDungeon.getHeroLocation();
			    		theDungeon.newLocation(theHero, local[0], local[1]+1);
			    		break;
			    case 3: local = theDungeon.getHeroLocation();
	    				theDungeon.newLocation(theHero, local[0] - 1, local[1]);
	    				break;
			    case 4: local = theDungeon.getHeroLocation();
	    				theDungeon.newLocation(theHero, local[0], local[1] - 1);
	    				break;
			    case 5: theHero.UseVision(theDungeon);
			    		break;
			    case 6: theHero.UseHealing();
			    		break;
			    case 7: System.out.print(theDungeon.printFullDungeon());
		        		break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

		}while ((!theHero.victory(theDungeon)) && !theHero.defeated());
		
	}while(playAgain());

    }//end main method
    
/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	
	public static boolean playAgain()
	{
		char again;
		System.out.println("Play again (y/n)?");
		again = Keyboard.readChar();
		return (again == 'Y' || again == 'y');
	}//end playAgain method

/*
 * -------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------
	
	public static void battle(Hero theHero, Monster theMonster)
	{
		char pause = 'p';
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
		{
		    //hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			//let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = Keyboard.readChar();

		}//end battle loop

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}//end battle method
*/
}//end Dungeon class



























