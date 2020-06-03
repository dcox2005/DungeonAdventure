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
		this.healingPotion = generateHealingPotion();
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
		
	@Override
	public String toString()
	{
		return printRoomTopRow() + "\n" + printRoomCenterRow() + "\n" + printRoomBottomRow();
	}//end toString

	public String printRoomTopRow()
	{
		if (northDoor)
			return "*-*";
		
		return "***";
	}//end printRoomTop()
	
	public String printRoomCenterRow()
	{
		String results = "";
		if (westDoor)
			results += "|";
		else 
			results += "*";
		
		results += roomIcon();
		
		if (eastDoor)
			results += "|";
		else 
			results += "*";
		
		return results;
	}//end printRoomCenterRow()
	
	public String printRoomBottomRow()
	{
		if (southDoor)
			return "*-*";
		
		return "***";
	}//end pritnRoomBottomRow()
	
/*
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
*/
	
	private String roomIcon()
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
	
	
/*
 * ---------------------GETTERS-------------------------------	
 */
	
	public HealingPotion getHealingPotion() 
	{
		return this.healingPotion;
	}//end getHealingPotion()

	public VisionPotion getVisionPotion() 
	{
		return this.visionPotion;
	}//end getVisionPotion()

	public Monster getEnemy() 
	{
		return this.enemy;
	}//end getEnemy()

	public Hero getHero() 
	{
		return this.hero;
	}//end getHero

	public boolean hasPillarOfOO() 
	{
		return this.pillarOfOO;
	}//end hasPillarOfOO()

	public boolean hasPit() 
	{
		return this.hasPit;
	}//end hasPit

	public boolean hasEntrance() 
	{
		return this.hasEntrance;
	}//end hasEntrance()

	public boolean hasExit() 
	{
		return this.hasExit;
	}//end hasExit()

	public boolean hasNorthDoor() 
	{
		return northDoor;
	}//end hasNorthDoor()

	public boolean hasEastDoor() 
	{
		return this.eastDoor;
	}//end hasEastDoor()

	public boolean hasSouthDoor() 
	{
		return this.southDoor;
	}//end hasSouthDoor()

	public boolean hasWestDoor() 
	{
		return this.westDoor;
	}//end hasWestDoor()

	public int getNumberOfThingsInRoom() 
	{
		return this.numberOfThingsInRoom;
	}//end getNumberOfThingsInRoom()

/*
 * ---------------------SETTERS-------------------------------	
*/	
	
	public void setHealingPotion(HealingPotion healingPotion) 
	{
		if (this.healingPotion != null && healingPotion == null)
			this.numberOfThingsInRoom--;
		
		if (this.healingPotion == null && healingPotion != null)
			this.numberOfThingsInRoom--;
		
		this.healingPotion = healingPotion;
	}//end setHealingPotion()

	public void setVisionPotion(VisionPotion visionPotion) 
	{
		if (this.visionPotion != null && visionPotion == null)
			this.numberOfThingsInRoom--;
		
		if (this.visionPotion == null && visionPotion != null)
			this.numberOfThingsInRoom--;
		
		this.visionPotion = visionPotion;
	}//end setVisionPotion()

	public void setEnemy(Monster enemy) 
	{
		if (this.enemy != null && enemy == null)
			this.numberOfThingsInRoom--;
		
		if (this.enemy == null && enemy != null)
			this.numberOfThingsInRoom--;
		
		this.enemy = enemy;
	}//end setEnemy()
	
	public void setHero(Hero hero)
	{
		this.hero = hero;
	}//end setHero;

	public void setPillarOfOO(boolean pillarOfOO) 
	{
		if (this.pillarOfOO == true && pillarOfOO == false)
			this.numberOfThingsInRoom--;
		
		this.pillarOfOO = pillarOfOO;
	}//end setPillarOfOO

	public void setHasPit(boolean hasPit) 
	{
		if (this.hasPit == true && hasPit == false)
			this.numberOfThingsInRoom--;
		
		this.hasPit = hasPit;
	}//end setHasPit()

	public void setNumberOfThingsInRoom(int numberOfThingsInRoom) 
	{
		this.numberOfThingsInRoom = numberOfThingsInRoom;
	}//end setNumberOfThingsInRoom()
	
}//end Room class
