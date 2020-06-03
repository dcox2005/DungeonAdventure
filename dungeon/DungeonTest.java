package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.regex.*;

class DungeonTest {

	@Test
	void testDungeon() 
	{
		Dungeon testDungeon = new Dungeon();
		Room [][] dungeonResults = testDungeon.getDungeon();
		
		
		fail("Not yet implemented");
	}

	@Test
	void testPrintFullDungeon() 
	{
		Dungeon testDungeon = new Dungeon();
		String dungeonString = testDungeon.printFullDungeon();
		System.out.println(testDungeon.printFullDungeon());
		System.out.println(dungeonString.length());
		int falseCount = 0;
		
		if (!dungeonString.startsWith("***************\n"))
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
		
//		if (!dungeonString.endsWith("***************"))
//			falseCount++;
		
//		if (!Pattern.matches("[^*[|MHVXYPIOE]{13}*$]", dungeonString.substring(16, 30)))
//			falseCount++;
		
//		[^\*[|MHVXYPIOE]{13}$\*]
		assertTrue(falseCount == 0);
	}//testing the full print out of dungeon

}//end DungeonTest
