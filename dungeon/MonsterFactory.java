package dungeon;

/*
 * This class is expressly for creating Monster characters in the DungeonAdventure
 * program.  This class is called by the games main method in Dungeon class.
 * This is the only place Monsters will be created.
 * 
 * Monsters are generated randomly
 */

public class MonsterFactory 
{
	public static Monster createMonster()
	{
		int randomChoice;
		randomChoice = (int)(Math.random() * 3) + 1;
		switch (randomChoice)
		{
			case 1: 
				return createOgre();
			
			case 2:
				return createGremlin();
			
			case 3:
				return createSkeleton();				
		
		}//end switch
		
		return null;
	}//end createMonster()
	
	private static Monster createOgre()
	{
		return new Ogre();
	}//end createOgre()
	
	private static Monster createGremlin()
	{
		return new Gremlin();
	}//end createGremlin()
	
	private static Monster createSkeleton()
	{
		return new Skeleton();
	}//end createSkeleton

}//end MonsterFactory
