package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.regex.*;

class DungeonTest {

	@Test
	void testDungeonForOnlyOneEntrance() 
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testDungeonForOnlyOneEntrance-----");
		Dungeon testDungeon = new Dungeon();
		Room [][] dungeonResults = testDungeon.getDungeon();
		System.out.println(testDungeon.printFullDungeon());
		int results = 0;
		for (int row = 1; row < dungeonResults.length - 1; row++)
		{
			for (int column = 1; column < dungeonResults[row].length - 1; column++)
			{
				if (dungeonResults[row][column].hasEntrance())
					results += 1;
			}//end for column
			
		}//end for row
		
		assertTrue(results == 1);	
	}//end testDungeonForOnlyOneEntrance
	
	@Test
	void testDungeonForOnlyOneExit() 
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testDungeonForOnlyOneExit-----");
		Dungeon testDungeon = new Dungeon();
		Room [][] dungeonResults = testDungeon.getDungeon();
		System.out.println(testDungeon.printFullDungeon());
		int results = 0;
		for (int row = 1; row < dungeonResults.length - 1; row++)
		{
			for (int column = 1; column < dungeonResults[row].length - 1; column++)
			{
				if (dungeonResults[row][column].hasExit())
					results += 1;
			}//end for column
			
		}//end for row
		
		assertTrue(results == 1);	
	}//end testDungeonForOnlyOneExit
	
	@Test
	void testDungeonForFourPillars() 
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testDungeonForFourPillars-----");
		Dungeon testDungeon = new Dungeon();
		Room [][] dungeonResults = testDungeon.getDungeon();
		System.out.println(testDungeon.printFullDungeon());
		int results = 0;
		for (int row = 1; row < dungeonResults.length - 1; row++)
		{
			for (int column = 1; column < dungeonResults[row].length - 1; column++)
			{
				if (dungeonResults[row][column].hasPillarOfOO())
					results += 1;
			}//end for column
			
		}//end for row
		
		assertTrue(results == 4);	
	}//end testDungeonForFourPillars

	@Test
	void testingIfPrintFullDungeonPrintsOutProperly() 
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testingIfPrintFullDungeonPrintsOutProperly-----");
		Dungeon testDungeon = new Dungeon();
		String dungeonString = testDungeon.printFullDungeon();
		System.out.println(testDungeon.printFullDungeon());
		int falseCount = 0;
		
		if (!dungeonString.startsWith("***************\n"))
			falseCount++;
		
		Pattern pattern = Pattern.compile("^*[MHVXYPIOE]||[MHVXYPIOE]||[MHVXYPIOE]||[MHVXYPIOE]||[MHVXYPIOE]*$");
		if (!((pattern.matcher(dungeonString.substring(16, 31))).find()) &&
				!((pattern.matcher(dungeonString.substring(64, 79))).find()) &&
				!((pattern.matcher(dungeonString.substring(112, 127))).find()) &&
				!((pattern.matcher(dungeonString.substring(160, 175))).find()) &&
				!((pattern.matcher(dungeonString.substring(208, 223))).find()))
			falseCount++;
		
		if (!((dungeonString.substring(32, 47)).equalsIgnoreCase("*-**-**-**-**-*")) &&
				!((dungeonString.substring(48, 63)).equalsIgnoreCase("*-**-**-**-**-*")) &&
				!((dungeonString.substring(80, 95)).equalsIgnoreCase("*-**-**-**-**-*")) &&
				!((dungeonString.substring(96, 111)).equalsIgnoreCase("*-**-**-**-**-*")) &&
				!((dungeonString.substring(128, 143)).equalsIgnoreCase("*-**-**-**-**-*")) &&
				!((dungeonString.substring(144, 159)).equalsIgnoreCase("*-**-**-**-**-*")) &&
				!((dungeonString.substring(176, 191)).equalsIgnoreCase("*-**-**-**-**-*")) &&
				!((dungeonString.substring(192, 207)).equalsIgnoreCase("*-**-**-**-**-*")))
			falseCount++;
		
		if (!((dungeonString.substring(224, 239)).equalsIgnoreCase("***************")))
			falseCount++;

		assertTrue(falseCount == 0);
	}//testing the full print out of dungeon

	@Test
	void testGetEntranceLocation()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testGetEntranceLocation-----");
		Dungeon testDungeon = new Dungeon();
		Room [][] dungeonResults = testDungeon.getDungeon();
		System.out.println(testDungeon.printFullDungeon());
		int[] testLocation = testDungeon.getEntranceLocation();
		int dungeonRow = 0, dungeonColumn = 0;
		for (int row = 1; row < dungeonResults.length - 1; row++)
		{
			for (int column = 1; column < dungeonResults[row].length - 1; column++)
			{
				if (dungeonResults[row][column].hasEntrance())
				{
					dungeonRow = row;
					dungeonColumn = column;
				}//end if
					
			}//end for column
			
		}//end for row
		
		System.out.println("[" + testLocation[0] + "," + testLocation[1] + "]");
		assertTrue(testLocation[0] == dungeonRow && testLocation[1] == dungeonColumn);
		
	}//end testGetEntranceLocation()
	
}//end DungeonTest
