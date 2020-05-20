package dungeon;

/*
 * This class is expressly for creating Hero characters in the DungeonAdventure
 * program.  This class is called by the games main method in Dungeon class.
 * This is the only place Heros will be created.
 */

public class HeroFactory 
{
	public static Hero createNewHero()
	{
		int userChoice;
		System.out.println("Choose a hero:\n" +
			       "1. Warrior\n" +
				   "2. Sorceress\n" +
				   "3. Thief");
		userChoice = Keyboard.readInt();
		switch (userChoice)
		{
			case 1: 
				return createWarrior();
		
			case 2: 
				return createSorceress();
		
			case 3: 
				return createThief();
		
			default:
			{
				System.out.println("That was not a valid choice. Please try again!");
				System.out.println();
				return createNewHero();
			}//end default choice		
		
		}//end userChoice switch
		
	}//end createNewHero
	
	private static Hero createWarrior()
	{
		return new Warrior();
	}//end createWarrior
	
	private static Hero createSorceress()
	{
		return new Sorceress();
	}//end createSorceress
	
	private static Hero createThief()
	{
		return new Thief();
	}//end createTheif

}//end HeroFactory
