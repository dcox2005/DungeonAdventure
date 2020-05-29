package dungeon;

public class Room 
{
	private HealingPotion healingPotion;							//
	private VisionPotion visionPotion;								//
	private Monster enemy;											//
	private boolean pillarOfOO;										//
	private boolean hasPit;											//
	private boolean hasEntrance;									//
	private boolean hasExit;										//
	private boolean northDoor, eastDoor, southDoor, westDoor;		//
	private int numberOfThingsInRoom;
	
	Room (boolean northDoor, boolean eastDoor, boolean southDoor, boolean westDoor, boolean entrance, boolean exit, boolean pillarOfOO)
	{
		this.northDoor = northDoor;
		this.eastDoor = eastDoor;
		this.southDoor = southDoor;
		this.westDoor = westDoor;
		this.hasEntrance = entrance;
		this.hasExit = exit;
		this.pillarOfOO = pillarOfOO;
		this.healingPotion =generateHealingPotion();
		this.visionPotion = generateVisionPotion();
		this.enemy = generateMonster();
		this.hasPit = generatePit();
		
	}//end constructor
	
	private HealingPotion generateHealingPotion()
	{
		if (hasEntrance() == true || hasExit() == true)
			return null;				//rooms with an entrance/exit will have nothing else
		
		int randomNumber = (int)(Math.random() * 100);
		if (randomNumber < 11)
			return new HealingPotion();
		
		return null;	//set potion to null if room doesn't get one.
	}//end getHealingPotion()
	
	private VisionPotion generateVisionPotion()
	{
		if (hasEntrance() == true || hasExit() == true)
			return null;				//rooms with an entrance/exit will have nothing else
		
		int randomNumber = (int)(Math.random() * 100);
		if (randomNumber < 11)
			return new VisionPotion();
		
		return null;	//set potion to null if room doesn't get one.
	}//end getHealingPotion()
	
	private Monster generateMonster()
	{
		if (hasEntrance() == true || hasExit() == true)
			return null;				//rooms with an entrance/exit will have nothing else
		
		int randomNumber = (int)(Math.random() * 100);
		if (randomNumber < 31)
			return MonsterFactory.createMonster();;
		
		return null;	//set Monster to null if the room doesn't have one.
	}//end getMonster()
	
	private boolean generatePit()
	{
		if (hasEntrance() == true || hasExit() == true)
			return false;				//rooms with an entrance/exit will have nothing else
		
		int randomNumber = (int)(Math.random() * 100);
		if (randomNumber < 11)
			return true;
		
		return false;	//set pit to false if room doesn't get one.
	}//end generatePit()
	
	private boolean hasEntrance()
	{
		return this.hasEntrance;
	}//end hasEntrance()
	
	private boolean hasExit()
	{
		return this.hasExit;
	}//end hasExit()
	
	@Override
	public String toString()
	{
		String roomString = null;
		return roomString;
	}//end toString
	
	private String topOrBottomWithDoor()
	{
		return "*-*";
	}//end topWithDoor()
	
	private String topOrBottomWithWall()
	{
		return "***";
	}//end topWithWall()
	
	private String sideDoor()
	{
		return "|";
	}//end sideDoor()
	
	private String sideWall()
	{
		return "*";
	}//end sideWall()
	

}//end Room class
