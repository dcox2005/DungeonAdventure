import dungeon.*;

/**
 * Title: Dungeon.java
 *
 * Work:
 * 
 * Team: 
 * Held twice weekly meetings to discuss project and assign work
 * worked together to adjust stats and design structures
 * provided feedback and assisted eachother as needed
 * -------------------------------------------------------------------
 * David Cox Work:
- created new Archer class and assigned discussed stats.
- created new Barbarian class and assigned discussed stats
- created new Room class with all methods
- created new Dungeon class with almost all methods. Some methods were added by others to accomodate the needs of other classes.
- wrote JUnit for Room class
- wrote JUnit for Dungeon class
- updated UML to current status, used the original UML that was worked on by all teammates from earlier project.
- created new BackPackItem interface, used as a reference only for now. Meant for future expandability
- created base for new PillarOfOO class, just wrote the outline. Methods were written by other teammates
- created base for new VisionPotion class, just wrote the outline. Methods were written by other teammates
- created base for new HealingPotion class, just wrote the outline. Methods were written by other teammates
-------------------------------------------------------------------------------------------------------------
Darrik Teller Work:
-Created new Kitten Class and assigned discussed stats
-Created new BabyDragon Class and assigned discussed stats
-Created Axe Class and all methods
-Created Bow Class and all methods
-Created Affection Class and all methods
-Created Dungeon Adventure Class and methods
-Wrote Vision Potion Method
-Wrote Healing Potion method
-Wrote helper methods that allowed for smooth gamplay in hero class

Justin Plett work:
    •    Creation of attack interface with the use of flyweight pattern
    •    Creation of multi shot attack 
    •    Creation of fields for PillarOO and all potions within the hero class along 
    	 with there accompanying getters and setters
    •    Creation of junit tests for the attack different attack methods to test whether the various 
    	 attacks when performed worked.
    •    Created string for useitem in pillarOfOO.
    •    Other small simple various changes not really impacting overall running of program

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
		    	System.out.println("1. Go North ");
		    	System.out.println("2. Go East ");
		    	System.out.println("3. Go South ");
		    	System.out.println("4. Go West ");
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
		System.out.println("Thanks For Playing!");
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
		System.out.println("\nView whole Dungeon is 19\n");
		
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



























