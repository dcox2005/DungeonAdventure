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

}//end RoomFactory Class
