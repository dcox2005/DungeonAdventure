package dungeon;

public class RoomFactory 
{
	private static boolean roomWithEntrance;
	private static boolean roomWithExit;
	private static boolean currentRoomEntrance;
	private static boolean currentRoomExit;
	private static int roomCount;
	private static int pillarOOCount;
	private static int entranceProbability;
	private static int exitProbability;

	public static Room createRoom()
	{					//Room (boolean northDoor, boolean eastDoor, boolean southDoor, boolean westDoor, boolean entrance, boolean exit, boolean pillarOfOO)
		Room newRoom = new Room(hasNorthDoor(), hasEastDoor(), hasSouthDoor(), hasWestDoor(), hasEntrance(), hasExit(), hasPillar());
		roomCount++;
		currentRoomEntrance = false;
		currentRoomExit = false;
		return newRoom;
	}//end createRoom()
	
	private static boolean hasNorthDoor()
	{
		if (roomCount < 6)
			return false;
		
		return true;
	}//end hasNorthDoor()
	
	private static boolean hasSouthDoor()
	{
		if (roomCount > 20)
			return false;
		
		return true;
	}//end hasSouthDoor()
	
	private static boolean hasEastDoor()
	{
		if (roomCount == 5 || roomCount == 10 || roomCount == 15 || roomCount == 20 || roomCount == 25)
			return false;
		
		return true;
	}//end hasEastDoor()
	
	private static boolean hasWestDoor()
	{
		if (roomCount == 1 || roomCount == 6 || roomCount == 11 || roomCount == 16 || roomCount == 21)
			return false;
		
		return true;
	}//end hasWestDoor()
	
	private static boolean hasEntrance()
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
	
	private static boolean hasExit()
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
	
	private static boolean hasPillar()
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
