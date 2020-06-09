package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CrushingBlowTest {

	@Test
	void testPreform_ShouldThrowExcepionForNullAttacker() {
		CrushingBlow testCrushingBlow = new CrushingBlow();
		DungeonCharacter testHero = null;
		DungeonCharacter testMonster = new Ogre();
		
		try {
			testCrushingBlow.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testPreform_ShouldThrowExcepionForNullOpponent() {
		CrushingBlow testCrushingBlow = new CrushingBlow();
		DungeonCharacter testHero = new Sorceress("Bill");
		DungeonCharacter testMonster = null;
		
		try {
			testCrushingBlow.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testPreform_ShouldThrowExcepionForBothCharatersNull() {
		CrushingBlow testCrushingBlow = new CrushingBlow();
		DungeonCharacter testHero = null;
		DungeonCharacter testMonster = null;
		
		try {
			testCrushingBlow.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}


}
