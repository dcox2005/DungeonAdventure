package dungeon;

public class VisionPotion 
{
	static void useItem(Dungeon dungeon) 
	{
		int[] local = dungeon.getHeroLocation();
		Room[][] room = dungeon.getDungeon();
		
		String results = "";
		
		for (int row = local[0] - 1; row < local[0] + 2 && row < dungeon.getDUNGEON_ROWS() - 1; row ++)
		{	if(row < 1) row = 1;
			for (int column = local [1]-1; column < local[0]+2 && column < dungeon.getDUNGEON_COLUMNS() - 1; column++)
			{	if(column < 1) column =1;
				results += room[row][column].printRoomTopRow();
			}//end top column for loop
			
			results += "\n";
			for (int column = local [1]-1; column < local[0]+2 && column  < dungeon.getDUNGEON_COLUMNS() - 1; column++)
			{	if(column < 1) column =1;
				results += room[row][column].printRoomCenterRow();
			}//end center column for loop
		
			results += "\n";
			for (int column = local [1]-1; column < local[0]+2 && column < dungeon.getDUNGEON_COLUMNS() - 1; column++)
			{	if(column < 1) column =1;
				results += room[row][column].printRoomBottomRow();
			}//end bottom column for loop
			
			results += "\n";
		}//end row for loop
		
		System.out.print(results);
	}
	

}//end VisionPotion Class
