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
		String userName = createUserName();
		switch (userChoice)
		{
			case 1: 
				return createWarrior(userName);
		
			case 2: 
				return createSorceress(userName);
		
			case 3: 
				return createThief(userName);
		
			default:
			{
				System.out.println("That was not a valid choice. Please try again!");
				System.out.println();
				return createNewHero();
			}//end default choice		
		
		}//end userChoice switch
		
	}//end createNewHero
	
	private static Hero createWarrior(String userName)
	{
		return new Warrior(userName);
	}//end createWarrior
	
	private static Hero createSorceress(String userName)
	{
		return new Sorceress(userName);
	}//end createSorceress
	
	private static Hero createThief(String userName)
	{
		return new Thief(userName);
	}//end createTheif

	public static String createUserName()
	{
		System.out.print("Enter character name: ");
		return Keyboard.readString();
	}//end readName()
	
}//end HeroFactory
