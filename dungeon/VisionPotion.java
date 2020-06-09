package dungeon;

public class VisionPotion 
{
	public VisionPotion()
	{
		
	}//end Constructor
	
	static void useItem(Dungeon dungeon) 
	{
		printUpper(dungeon);
		printCurrent(dungeon);
		printLower(dungeon);
	}
	
	
	private static void printUpper(Dungeon dungeon) {
		int[] local = dungeon.getHeroLocation();
		Room[][] room = dungeon.getDungeon();
		
		if(room[local[0]-1][local[1]-1] == null)
			System.out.print(printNull());
		else
			System.out.print(room[local[0]-1][local[1]-1].toString());
		
		if(room[local[0]-1][local[1]] == null)
			System.out.print(printNull());
		else
			System.out.print(room[local[0]-1][local[1]].toString());
		
		if(room[local[0]-1][local[1]+1] == null)
				System.out.print(printNull());
			else
				System.out.print(room[local[0]-1][local[1] + 1].toString());
		
	}
	
	private static void printCurrent(Dungeon dungeon) {
		int[] local = dungeon.getHeroLocation();
		Room[][] room = dungeon.getDungeon();
		String res ="";
		
		if(room[local[0]][local[1]-1] == null)
			res += printNull();
		else
			res += room[local[0]][local[1]-1].toString();
		
		if(room[local[0]][local[1]] == null)
			res += printNull();
		else
			res +yroom[local[0]][local[1]].toString();
		
		if(room[local[0]][local[1]+ 1] == null)
			res += printNull();
		else
			res += room[local[0]][local[1] +1].toString();
		System.out.print(res);
		
	}
	private static void printLower(Dungeon dungeon) {
		int[] local = dungeon.getHeroLocation();
		Room[][] room = dungeon.getDungeon();
		String res ="";
		if(room[local[0]-1][local[1]-1] == null)
			res += printNull();
		else
			res += room[local[0]][local[1]-1].toString();
		
		if(room[local[0]-1][local[1]] == null)
			res += printNull();
		else
			res += room[local[0]][local[1]].toString();
		
		if(room[local[0]-1][local[1]+ 1] == null)
			res += printNull();
		else
			res += room[local[0]-1][local[1] +1].toString();
		System.out.print(res);
	}

	private static String printNull() {
		return "***\n" + "* *\n" +"***";
		
	}//end useItem()
	
	String results = "";
	for (int row = 1; row < local[0]-1 && row < dungeon.DUNGEON_ROWS - 1; row ++)
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

}//end VisionPotion Class
