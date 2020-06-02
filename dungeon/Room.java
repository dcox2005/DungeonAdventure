package dungeon;

public class Room 
{
	private HealingPotion healingPotion;							
	private VisionPotion visionPotion;								
	private Monster enemy;	
	private Hero hero;
	private boolean pillarOfOO;										
	private boolean hasPit;											
	private boolean hasEntrance;									
	private boolean hasExit;										
	private boolean northDoor, eastDoor, southDoor, westDoor;		
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
		this.hero = null;
		if (pillarOfOO == true)
			numberOfThingsInRoom++;		
	}//end constructor
	
	private HealingPotion generateHealingPotion()
	{
		if (hasEntrance() == true || hasExit() == true)
			return null;				//rooms with an entrance/exit will have nothing else
		
		int randomNumber = (int)(Math.random() * 100);
		if (randomNumber < 11)
		{
			numberOfThingsInRoom++;
			return new HealingPotion();
		}//end if
		
		return null;	//set potion to null if room doesn't get one.
	}//end getHealingPotion()
	
	private VisionPotion generateVisionPotion()
	{
		if (hasEntrance() == true || hasExit() == true)
			return null;				//rooms with an entrance/exit will have nothing else
		
		int randomNumber = (int)(Math.random() * 100);
		if (randomNumber < 11)
		{	
			numberOfThingsInRoom++;
			return new VisionPotion();
		}//end if
		
		return null;	//set potion to null if room doesn't get one.
	}//end getHealingPotion()
	
	private Monster generateMonster()
	{
		if (hasEntrance() == true || hasExit() == true)
			return null;				//rooms with an entrance/exit will have nothing else
		
		int randomNumber = (int)(Math.random() * 100);
		if (randomNumber < 31)
		{
			numberOfThingsInRoom++;
			return MonsterFactory.createMonster();
		}//end if
			
		return null;	//set Monster to null if the room doesn't have one.
	}//end getMonster()
	
	private boolean generatePit()
	{
		if (hasEntrance() == true || hasExit() == true)
			return false;				//rooms with an entrance/exit will have nothing else
		
		int randomNumber = (int)(Math.random() * 100);
		if (randomNumber < 11)
		{
			numberOfThingsInRoom++;
			return true;
		}//end if
		
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
		String roomString = "";
		if (northDoor)
			roomString += topOrBottomWithDoor();
		else
			roomString += topOrBottomWithWall();
		
		roomString += "\n";
		
		if (eastDoor)
			roomString += sideDoor();
		else
			roomString += sideWall();
		
		roomString += roomIcon();
		
		if (westDoor)
			roomString += sideDoor();
		else
			roomString += sideWall();
		
		if (southDoor)
			roomString += topOrBottomWithDoor();
		else
			roomString += topOrBottomWithWall();
	
		return roomString;
	}//end toString
	
	public String topOrBottomWithDoor()
	{
		return "*-*";
	}//end topWithDoor()
	
	public String topOrBottomWithWall()
	{
		return "***";
	}//end topWithWall()
	
	public String sideDoor()
	{
		return "|";
	}//end sideDoor()
	
	public String sideWall()
	{
		return "*";
	}//end sideWall()
	
	public String roomIcon()
	{
		if (numberOfThingsInRoom > 1)
			return "M";
		
		if (healingPotion != null)
			return "H";
		
		if (visionPotion != null)
			return "V";
		
		if (enemy != null)
			return "X";
		
		if (pillarOfOO)
			return "Y";
		
		if (hasPit)
			return "P";
		
		if (hasEntrance)
			return "I";
		
		if (hasExit)
			return "O";
		
		return "E";
	}//end roomIcon()
	
	public void setHero(Hero hero)
	{
		this.hero = hero;
	}//end setHero;
	
}//end Room class
