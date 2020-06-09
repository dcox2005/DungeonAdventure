package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.regex.*;

class DungeonTest {

	@Test
	void testDungeonForOnlyOneEntrance_ShouldBeTrueIfResultsOnlyFindsOneEntrance() 
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testDungeonForOnlyOneEntrance_ShouldBeTrueIfResultsOnlyFindsOneEntrance-----");
		Dungeon testDungeon = new Dungeon();
		Room [][] dungeonResults = testDungeon.getDungeon();
//		System.out.println(testDungeon.printFullDungeon());
		int results = 0;
		for (int row = 1; row < dungeonResults.length - 1; row++)
		{
			for (int column = 1; column < dungeonResults[row].length - 1; column++)
			{
				if (dungeonResults[row][column].hasEntrance())
					results += 1;
			}//end for column
			
		}//end for row
		
		System.out.println("Entrance results: " + results);
		assertTrue(results == 1);	
	}//end testDungeonForOnlyOneEntrance_ShouldBeTrueIfResultsOnlyFindsOneEntrance
	
	@Test
	void testDungeonForOnlyOneExit_ShouldBeTrueIfResultsOnlyFindsOneExit() 
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testDungeonForOnlyOneExit_ShouldBeTrueIfResultsOnlyFindsOneExit-----");
		Dungeon testDungeon = new Dungeon();
		Room [][] dungeonResults = testDungeon.getDungeon();
//		System.out.println(testDungeon.printFullDungeon());
		int results = 0;
		for (int row = 1; row < dungeonResults.length - 1; row++)
		{
			for (int column = 1; column < dungeonResults[row].length - 1; column++)
			{
				if (dungeonResults[row][column].hasExit())
					results += 1;
			}//end for column
			
		}//end for row
		
		System.out.println("Exit results: " + results);
		assertTrue(results == 1);	
	}//end testDungeonForOnlyOneExit_ShouldBeTrueIfResultsOnlyFindsOneExit
	
	@Test
	void testDungeonForFourPillars_ShouldBeTrueIfResultsFindsOnlyFourPillarsNotLessNotMore() 
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testDungeonForFourPillars_ShouldBeTrueIfResultsFindsOnlyFourPillarsNotLessNotMore-----");
		Dungeon testDungeon = new Dungeon();
		Room [][] dungeonResults = testDungeon.getDungeon();
//		System.out.println(testDungeon.printFullDungeon());
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
	}//end testDungeonForFourPillars_ShouldBeTrueIfResultsFindsOnlyFourPillarsNotLessNotMore

	@Test
	void testingIfPrintFullDungeonPrintsOutProperly_ShouldBeTrueIfFalseCountCounterDoesNotTrigger() 
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testingIfPrintFullDungeonPrintsOutProperly_ShouldBeTrueIfFalseCountCounterDoesNotTrigger-----");
		Dungeon testDungeon = new Dungeon();
		String dungeonString = testDungeon.printFullDungeon();
//		System.out.println(testDungeon.printFullDungeon());
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
	}//end testingIfPrintFullDungeonPrintsOutProperly_ShouldBeTrueIfFalseCountCounterDoesNotTrigger

	@Test
	void testGetEntranceLocation_ShouldBeTrueIfGetEntranceLocationMatchesTheRowAndColumnFound()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testGetEntranceLocation_ShouldBeTrueIfGetEntranceLocationMatchesTheRowAndColumnFound-----");
		Dungeon testDungeon = new Dungeon();
		Room [][] dungeonResults = testDungeon.getDungeon();
//		System.out.println(testDungeon.printFullDungeon());
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
		
	}//end testGetEntranceLocation_ShouldBeTrueIfGetEntranceLocationMatchesTheRowAndColumnFound()
	
	@Test
	void testNewLocation_HeroLocationShouldBeUpdatedToNewCordinatesThatAreEntered()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testNewLocation_HeroLocationShouldBeUpdatedToNewCordinatesThatAreEntered-----");
		Dungeon testDungeon = new Dungeon();
		Hero testHero = new Warrior("Thrall");
//		System.out.println(testDungeon.printFullDungeon());
		int theRowOfTheDungeonTheHeroShouldBeIn = 4;
		int theColumnOfTheDungeonTheHeroShouldBeIn	= 2;
		testDungeon.newLocation(testHero, theRowOfTheDungeonTheHeroShouldBeIn, 
				theColumnOfTheDungeonTheHeroShouldBeIn);
		int[] heroLocation = testDungeon.getHeroLocation();
		assertTrue(heroLocation[0] == theRowOfTheDungeonTheHeroShouldBeIn && 
				heroLocation[1] == theColumnOfTheDungeonTheHeroShouldBeIn);
	}//end testNewLocation_HeroLocationShouldBeUpdatedToNewCordinatesThatAreEntered
	
	@Test
	void testNewLocation_HeroShouldNotBeAbleToGoToAZoneWithAZeroRowOrColumn()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testNewLocation_HeroShouldNotBeAbleToGoToAZoneWithAZeroRowOrColumn-----");
		Dungeon testDungeon = new Dungeon();
		Hero testHero = new Warrior("Thrall");
//		System.out.println(testDungeon.printFullDungeon());
		int theRowOfTheDungeonTheHeroTriesToMoveTo = 0;
		int theColumnOfTheDungeonTheHeroTriesToMoveTo	= 4;
		int[] dungeonEntrance = testDungeon.getEntranceLocation();
		testDungeon.newLocation(testHero, theRowOfTheDungeonTheHeroTriesToMoveTo, 
				theColumnOfTheDungeonTheHeroTriesToMoveTo);
		int[] heroLocation = testDungeon.getHeroLocation();
		//hero should remain at the dungeon entrance if he couldn't move to the new location.
		assertTrue(heroLocation[0] == dungeonEntrance[0] && 
				heroLocation[1] == dungeonEntrance[1]);
	}//end testNewLocation_HeroShouldNotBeAbleToGoToAZoneWithAZeroRowOrColumn
	
}//end DungeonTest
