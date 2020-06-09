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
	
	Room ()
	{	
		this.healingPotion = null;
		this.visionPotion = null;
		this.hero = null;
		this.enemy = null;
		this.pillarOfOO = false;
		this.hasPit = false;
		this.hasEntrance = false;
		this.hasExit = false;
		this.northDoor = false;
		this.eastDoor = false;
		this.southDoor = false;
		this.westDoor = false;
		this.numberOfThingsInRoom = 0;	
	}//end constructor
	
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
	
	public int pitDamage()
	{
		if (!this.hasPit)
			return 0;
		
		int damageTaken = (int)((Math.random() * 20) + 1.0);
		System.out.println(hero.getName() + " fell into a pit");
		return damageTaken;
	}//end pitDamage()
	
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
			this.numberOfThingsInRoom++;
		
		this.healingPotion = healingPotion;
	}//end setHealingPotion()

	public void setVisionPotion(VisionPotion visionPotion) 
	{
		if (this.visionPotion != null && visionPotion == null)
			this.numberOfThingsInRoom--;
		
		if (this.visionPotion == null && visionPotion != null)
			this.numberOfThingsInRoom++;
		
		this.visionPotion = visionPotion;
	}//end setVisionPotion()

	public void setEnemy(Monster enemy) 
	{
		if (this.enemy != null && enemy == null)
			this.numberOfThingsInRoom--;
		
		if (this.enemy == null && enemy != null)
			this.numberOfThingsInRoom++;
		
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
		
		if (this.pillarOfOO == false && pillarOfOO == true)
			this.numberOfThingsInRoom++;
		
		this.pillarOfOO = pillarOfOO;
	}//end setPillarOfOO

	public void setHasPit(boolean hasPit) 
	{
		if (this.hasPit == true && hasPit == false)
			this.numberOfThingsInRoom--;
		
		if (this.hasPit == false && hasPit == true)
			this.numberOfThingsInRoom++;
		
		this.hasPit = hasPit;
	}//end setHasPit()

	public void setNumberOfThingsInRoom(int numberOfThingsInRoom) 
	{
		this.numberOfThingsInRoom = numberOfThingsInRoom;
	}//end setNumberOfThingsInRoom()

	public void setEntrance(boolean hasEntrance) 
	{
		this.hasEntrance = hasEntrance;
	}//end setEntrance

	public void setExit(boolean hasExit) 
	{
		this.hasExit = hasExit;
	}//end setExit

	public void setNorthDoor(boolean northDoor) 
	{
		this.northDoor = northDoor;
	}//end setNorthDoor

	public void setEastDoor(boolean eastDoor) 
	{
		this.eastDoor = eastDoor;
	}//end setEastDoor

	public void setSouthDoor(boolean southDoor) 
	{
		this.southDoor = southDoor;
	}//end setSouthDoor

	public void setWestDoor(boolean westDoor) 
	{
		this.westDoor = westDoor;
	}//end setWestDoor
		
	
}//end Room class
