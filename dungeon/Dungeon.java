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
		
		for (int row = 0; row < 7; row++)
		{
			for (int column = 0; column < 7; column++)
			{
				if (row == 0 || row == 6)
				{
					dungeon[row][column] = null;
				}//end if for top/bottom edge creation
				
				else if (column == 0 || column == 6)
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
		Room newRoom = new Room(hasNorthDoor(), hasEastDoor(), hasSouthDoor(), hasWestDoor(), hasEntrance(), hasExit(), hasPillar());
		roomCount++;
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
		
		if ((int)(Math.random() * 100) < 70)
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

}//end RoomFactory Class
