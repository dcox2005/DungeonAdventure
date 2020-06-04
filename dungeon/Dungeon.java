package dungeon;

public class Dungeon
{
	private boolean roomWithEntrance;
	private boolean roomWithExit;
	private boolean currentRoomEntrance;
	private boolean currentRoomExit;
	private int roomCount;
	private int pillarOOCount;
	private final int DUNGEON_COLUMNS = 7;
	private final int DUNGEON_ROWS = 7;
	private Room[][] dungeon = new Room[DUNGEON_ROWS][DUNGEON_COLUMNS];
	private int[] heroLocation = new int[2];
	
	public Dungeon()
	{
		this.dungeon = createDungeon(); 
		this.heroLocation = getEntranceLocation();
	}//end constructor
	
	private Room[][] createDungeon()
	{
		Room[][] dungeon = new Room[this.DUNGEON_ROWS][this.DUNGEON_COLUMNS];
		
		for (int row = 0; row < this.DUNGEON_ROWS; row++)
		{
			for (int column = 0; column < this.DUNGEON_COLUMNS; column++)
			{
				if (row == 0 || row == this.DUNGEON_ROWS - 1)
				{
					dungeon[row][column] = null;
				}//end if for top/bottom edge creation
				
				else if (column == 0 || column == this.DUNGEON_COLUMNS - 1)
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
	{
		this.roomCount++;
		Room newRoom = new Room();
		newRoom.setNorthDoor(hasNorthDoor());
		newRoom.setEastDoor(hasEastDoor());
		newRoom.setSouthDoor(hasSouthDoor());
		newRoom.setWestDoor(hasWestDoor());
		newRoom.setEntrance(hasEntrance());
		newRoom.setExit(hasExit());
		newRoom.setPillarOfOO(hasPillar());
		newRoom.setHealingPotion(generateHealingPotion());
		newRoom.setVisionPotion(generateVisionPotion());
		newRoom.setEnemy(generateMonster());
		newRoom.setHasPit(generatePit());
		this.currentRoomEntrance = false;
		this.currentRoomExit = false;
		return newRoom;
	}//end createRoom()
	
	private boolean hasNorthDoor()
	{
		if (this.roomCount < 6)
			return false;
		
		return true;
	}//end hasNorthDoor()
	
	private boolean hasSouthDoor()
	{
		if (this.roomCount > 20)
			return false;
		
		return true;
	}//end hasSouthDoor()
	
	private boolean hasEastDoor()
	{
		if (this.roomCount == 5 || this.roomCount == 10 || this.roomCount == 15 || 
				this.roomCount == 20 || this.roomCount == 25)
			return false;
		
		return true;
	}//end hasEastDoor()
	
	private boolean hasWestDoor()
	{
		if (this.roomCount == 1 || this.roomCount == 6 || this.roomCount == 11 || 
				this.roomCount == 16 || this.roomCount == 21)
			return false;
		
		return true;
	}//end hasWestDoor()
	
	private boolean hasEntrance()
	{
		if (this.roomWithEntrance == true)
			return false;
			
		if ((int)(Math.random() * 25) < 5)
		{
			this.currentRoomEntrance = true;
			this.roomWithEntrance = true;
			return true;
		}//end if random chance
		
		if (this.roomCount > 24)
		{
			this.currentRoomEntrance = true;
			this.roomWithEntrance = true;
			return true;
		}//end if guaranteed entrance
		
		return false;
	}//end hasEntrance()
	
	private boolean hasExit()
	{
		if (this.roomWithExit == true)
			return false;
		
		if (this.currentRoomEntrance)
			return false;
			
		if ((int)(Math.random() * 25) < 5)
		{
			this.currentRoomExit = true;
			this.roomWithExit = true;
			return true;
		}//end if random chance
		
		if (this.roomCount > 23)
		{
			this.currentRoomExit = true;
			this.roomWithExit = true;
			return true;
		}//end if guaranteed exit
		
		return false;
	}//end hasExit()
	
	private boolean hasPillar()
	{
		if (this.currentRoomEntrance || this.currentRoomExit)
			return false;
		
		if (this.pillarOOCount == 4)
			return false;
		
		if ((int)(Math.random() * 100) < 31)
		{
			this.pillarOOCount++;
			return true;
		}//end if
		
		if (this.roomCount > 20)
		{
			this.pillarOOCount++;
			return true;
		}//end if roomCount
		
		return false;
	}//end hasPillar()
	
	private HealingPotion generateHealingPotion()
	{
		if (this.currentRoomEntrance == true || this.currentRoomExit == true)
			return null;				//rooms with an entrance/exit will have nothing else
		
		int randomNumber = (int)(Math.random() * 100);
		if (randomNumber < 11)
			return new HealingPotion();

		return null;	//set potion to null if room doesn't get one.
	}//end getHealingPotion()
	
	private VisionPotion generateVisionPotion()
	{
		if (this.currentRoomEntrance == true || this.currentRoomExit == true)
			return null;				//rooms with an entrance/exit will have nothing else
		
		int randomNumber = (int)(Math.random() * 100);
		if (randomNumber < 11)
			return new VisionPotion();
		
		return null;	//set potion to null if room doesn't get one.
	}//end getHealingPotion()
	
	private Monster generateMonster()
	{
		if (this.currentRoomEntrance == true || this.currentRoomExit == true)
			return null;				//rooms with an entrance/exit will have nothing else
		
		int randomNumber = (int)(Math.random() * 100);
		if (randomNumber < 31)
			return MonsterFactory.createMonster();
			
		return null;	//set Monster to null if the room doesn't have one.
	}//end getMonster()
	
	private boolean generatePit()
	{
		if (this.currentRoomEntrance == true || this.currentRoomExit == true)
			return false;				//rooms with an entrance/exit will have nothing else
		
		int randomNumber = (int)(Math.random() * 100);
		if (randomNumber < 11)
			return true;
		
		return false;	//set pit to false if room doesn't get one.
	}//end generatePit()
	
	public String printFullDungeon()
	{
		String results = "";
		for (int row = 1; row < this.DUNGEON_ROWS - 1; row ++)
		{
			for (int column = 1; column < this.DUNGEON_COLUMNS - 1; column++)
			{
				results += this.dungeon[row][column].printRoomTopRow();
			}//end top column for loop
			
			results += "\n";
			for (int column = 1; column < this.DUNGEON_COLUMNS - 1; column++)
			{
				results += this.dungeon[row][column].printRoomCenterRow();
			}//end center column for loop
			
			results += "\n";
			for (int column = 1; column < this.DUNGEON_COLUMNS - 1; column++)
			{
				results += this.dungeon[row][column].printRoomBottomRow();
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
		for (int row = 1; row < this.DUNGEON_ROWS - 1; row ++)
		{
			for (int column = 1; column < this.DUNGEON_COLUMNS - 1; column++)
			{
				if (this.dungeon[row][column].hasEntrance())
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
		if (row < 1 || row > 5 || column < 1 || column > 5)
		{
			System.out.println("You can't move that way. There is a wall. Try again.");
			return;
		}//end if dungeon edge
		
		this.heroLocation[0] = row;
		this.heroLocation[1] = column;
		System.out.println(hero.getName() + " has entered room [" + this.heroLocation[0] + "][" + 
				this.heroLocation[1] + "]");
		Room room = this.dungeon[this.heroLocation[0]][this.heroLocation[1]];
		room.setHero(hero);
		
		if (room.getNumberOfThingsInRoom() == 0)
		{
			System.out.println("The room is empty");
		}//end if empty room
		
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
			System.out.println(hero.getName() + " found a monster in the room. ");
			System.out.println(hero.getName() + " will now have to battle " + room.getEnemy().getName());
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
	
	public int[] getHeroLocation()
	{
		return this.heroLocation;
	}//end getHeroLocation
	
}//end RoomFactory Class
