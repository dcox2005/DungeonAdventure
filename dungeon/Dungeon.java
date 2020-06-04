package dungeon;

public class Dungeon
{
	private boolean roomWithEntrance;
	private boolean roomWithExit;
	private boolean currentRoomEntrance;
	private boolean currentRoomExit;
	private int roomCount;
	private int pillarOOCount;
	private int entranceProbability;
	private int exitProbability;
	private final int DUNGEON_COLUMNS = 7;
	private final int DUNGEON_ROWS = 7;
	private Room[][] dungeon = new Room[DUNGEON_ROWS][DUNGEON_COLUMNS];

	public Dungeon()
	{
		this.dungeon = createDungeon(); 
	}//end constructor
	
	private Room[][] createDungeon()
	{
		Room[][] dungeon = new Room[DUNGEON_ROWS][DUNGEON_COLUMNS];
		
		for (int row = 0; row < DUNGEON_ROWS; row++)
		{
			for (int column = 0; column < DUNGEON_COLUMNS; column++)
			{
				if (row == 0 || row == DUNGEON_ROWS - 1)
				{
					dungeon[row][column] = null;
				}//end if for top/bottom edge creation
				
				else if (column == 0 || column == DUNGEON_COLUMNS - 1)
				{
					dungeon[row][column] = null;
				}//end if for side edge creation
				
				else
				{
					dungeon[row][column] = createRoom();
				}//end else for creating a room
				
			}//end for column
			
		}//end for row
		
		return dungeon;
	}//end createDungeon()
	
	private Room createRoom()
	{					//Room (boolean northDoor, boolean eastDoor, boolean southDoor, boolean westDoor, boolean entrance, boolean exit, boolean pillarOfOO)
		roomCount++;
		Room newRoom = new Room(hasNorthDoor(), hasEastDoor(), hasSouthDoor(), hasWestDoor(), hasEntrance(), hasExit(), hasPillar());
		currentRoomEntrance = false;
		currentRoomExit = false;
		return newRoom;
	}//end createRoom()
	
	private boolean hasNorthDoor()
	{
		if (roomCount < 6)
			return false;
		
		return true;
	}//end hasNorthDoor()
	
	private boolean hasSouthDoor()
	{
		if (roomCount > 20)
			return false;
		
		return true;
	}//end hasSouthDoor()
	
	private boolean hasEastDoor()
	{
		if (roomCount == 5 || roomCount == 10 || roomCount == 15 || roomCount == 20 || roomCount == 25)
			return false;
		
		return true;
	}//end hasEastDoor()
	
	private boolean hasWestDoor()
	{
		if (roomCount == 1 || roomCount == 6 || roomCount == 11 || roomCount == 16 || roomCount == 21)
			return false;
		
		return true;
	}//end hasWestDoor()
	
	private boolean hasEntrance()
	{
		if (roomWithEntrance == true)
			return false;
		
		if (entranceProbability > 24)
		{
			currentRoomEntrance = true;
			roomWithEntrance = true;
			return true;
		}//end if entranceProbability
			
		if ((int)(Math.random() * 25) < 5)
		{
			currentRoomEntrance = true;
			roomWithEntrance = true;
			return true;
		}//end if random chance
		
		entranceProbability++;		
		return false;
	}//end hasEntrance()
	
	private boolean hasExit()
	{
		if (roomWithExit == true)
			return false;
		
		if (currentRoomEntrance)
		{
			exitProbability++;
			return false;
		}//end if curretnRoomEntrance

		if (exitProbability > 23)
		{
			currentRoomExit = true;
			roomWithExit = true;
			return true;
		}//end if exitProbability
			
		if ((int)(Math.random() * 25) < 5)
		{
			currentRoomExit = true;
			roomWithExit = true;
			return true;
		}//end if random chance
		
		exitProbability++;
		return false;
	}//end hasExit()
	
	private boolean hasPillar()
	{
		if (currentRoomEntrance || currentRoomExit)
			return false;
		
		if (pillarOOCount == 4)
			return false;
		
		if ((int)(Math.random() * 100) < 31)
		{
			pillarOOCount++;
			return true;
		}//end if
		
		if (roomCount > 20)
		{
			pillarOOCount++;
			return true;
		}//end if roomCount
		
		return false;
	}//end hasPillar()
	
	public String printFullDungeon()
	{
		String results = "";
		for (int row = 1; row < DUNGEON_ROWS - 1; row ++)
		{
			for (int column = 1; column < DUNGEON_COLUMNS - 1; column++)
			{
				results += dungeon[row][column].printRoomTopRow();
			}//end top column for loop
			
			results += "\n";
			for (int column = 1; column < DUNGEON_COLUMNS - 1; column++)
			{
				results += dungeon[row][column].printRoomCenterRow();
			}//end center column for loop
			
			results += "\n";
			for (int column = 1; column < DUNGEON_COLUMNS - 1; column++)
			{
				results += dungeon[row][column].printRoomBottomRow();
			}//end bottom column for loop
			
			results += "\n";
		}//end row for loop
		
		return results;
	}//end printFullDungeon
	
	public Room[][] getDungeon()
	{
		return this.dungeon;
	}//end getDungeon()

	public int[] getEntranceLocation()
	{
		int[] location = new int[2];
		for (int row = 1; row < DUNGEON_ROWS - 1; row ++)
		{
			for (int column = 1; column < DUNGEON_COLUMNS - 1; column++)
			{
				if (dungeon[row][column].hasEntrance())
				{
					location[0] = row;
					location[1] = column;
				}//end if entrance
				
			}//end column for loop
			
		}//end row for loop	
		
		return location;
		
	}//end getEntranceLocation()
	
	public void newLocation(Hero hero, int row, int column)
	{
		System.out.println(hero.getName() + " has entered room [" + row + "][" + column + "]");
		Room room = dungeon[row][column];
		room.setHero(hero);
		if (room.hasPit())
		{
			hero.subtractHitPoints(room.pitDamage());
			room.setHasPit(false);
		}//end if pit
		
		if (room.getHealingPotion() != null)
		{
			hero.setNumOfHealingPotion(hero.getnumOfHealingPotion() + 1);
			System.out.println(hero.getName() + " found a healing potion. " + hero.getName() + " now has ["
					+ hero.getnumOfHealingPotion() + "] healing potions");
			room.setHealingPotion(null);
		}//end if HealingPotion
		
		if (room.getVisionPotion() != null)
		{
			hero.setNumOfVisionPotion(hero.getnumOfVisionPotion() + 1);
			System.out.println(hero.getName() + " found a vision potion. " + hero.getName() + " now has ["
					+ hero.getnumOfVisionPotion() + "] vision potions");
			room.setVisionPotion(null);
		}//end if VisionPotion
		
		if (room.hasPillarOfOO())
		{
			hero.setNumOfPillarsFound(hero.getNumOfPillarsFound() + 1);
			System.out.println(hero.getName() + " found a Pillar Of OO. " + hero.getName() + " now has ["
					+ hero.getNumOfPillarsFound() + "] Pillars of OO. 4 Pillars are required to exit");
			room.setPillarOfOO(false);
		}//end if pillar
		
		if (room.getEnemy() != null)
		{
			System.out.println(hero.getName() + " found a monster in the room. " + hero.getName() + 
					" will now have to battl " + room.getEnemy().getName());
			//TODO What to do when an enemy is in the room
			room.setEnemy(null);
		}//end if enemy
		
		if (room.hasExit())
		{
			if (hero.getNumOfPillarsFound() >= 4)
			{
				System.out.println("You have reached the exit with all the pillars. You win.");
			}//end if
			
			else
			{
				System.out.println("You need to have all four Pillars of OO to exit. You currently have [" + 
							hero.getNumOfPillarsFound() + "] pillars. Keep going brave adventurer.");
			}//end else
				
		}//end if exit
	}//end newLocations()
	
}//end RoomFactory Class
