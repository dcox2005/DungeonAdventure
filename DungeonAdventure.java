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
		printInstruction();
		
		
		do
		{	theHero = HeroFactory.createNewHero(); //chooseHero();
			theDungeon = new Dungeon();
			int [] local = theDungeon.getHeroLocation();
			
			System.out.println();
			System.out.println("Your Starting Location is: " +"[" + local[0] +"]" + "[" + local[1] + "]");
		
		   
		    do{  local = theDungeon.getHeroLocation();
		    	
		    	System.out.println("How would you like to continue");
		    	System.out.println("0. Get Status");
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
		    
		    	case 0: System.out.print(theHero.getName() + " has " + theHero.getHitPoints() +" hit points " + 
		    	theHero.getnumOfHealingPotion() + " healing potions \n " + theHero.getnumOfVisionPotion() + 
		    			" vision potions and has found " +
		    			theHero.getNumOfPillarsFound()+ " Pillars of OO\n");
		    			break;  
			    case 1: local = theDungeon.getHeroLocation();
	    				theDungeon.newLocation(theHero, local[0] - 1, local[1]);
	    				break;  
			    case 2: local = theDungeon.getHeroLocation();
			    		theDungeon.newLocation(theHero, local[0], local[1]+1);
			    		break;
			    case 3: local = theDungeon.getHeroLocation();
	    				theDungeon.newLocation(theHero, local[0] + 1, local[1]);
	    				break;
			    case 4: local = theDungeon.getHeroLocation();
	    				theDungeon.newLocation(theHero, local[0], local[1] - 1);
	    				break;
			    case 5: theHero.UseVision(theDungeon);
			    		break;
			    case 6: theHero.UseHealing();
			    		break;
			    case 19: System.out.print(theDungeon.printFullDungeon());
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
	
	private static void printInstruction() {
		System.out.println("Welcome to Dungeon Adventure");
		System.out.println("First you will select a character");
		System.out.println("Next you will select an awesome name");
		System.out.println("You will be able to move North, South, East, West");
		System.out.println("You will be collect the 4 Pillars of OO and find the exit to win");
		System.out.print( "Some Things to know: \n M - Multiple Items\n P - Pit \n I - Entrance (In) \n"
				+ " O - Exit (Out)\n V - Vision Potion \n H - Healing Potion\n E - Empty Room\n X - Monster\n"
				+ " Y - Pillar of OO\n");
		System.out.println("Good Luck, The adventure begins");
		
	}

	public static boolean playAgain()
	{
		char again;
		System.out.println("GAME OVER");
		System.out.println("Play again (y/n)?");
		again = Keyboard.readChar();
		return (again == 'Y' || again == 'y');
	}//end playAgain method



}//end DungeonAdventure class



























