package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SelfHealTest {

	@Test
	void testPreform_ShouldThrowExcepionForNullAttacker() {
		SelfHeal testSelfHeal = new SelfHeal();
		DungeonCharacter testHero = null;
		DungeonCharacter testMonster = new Ogre();
		
		try {
			testSelfHeal.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testPreform_ShouldThrowExcepionForNullOpponent() {
		SelfHeal testSelfHeal = new SelfHeal();
		DungeonCharacter testHero = new Sorceress("Bill");
		DungeonCharacter testMonster = null;
		
		try {
			testSelfHeal.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testPreform_ShouldThrowExcepionForBothCharatersNull() {
		SelfHeal testSelfHeal = new SelfHeal();
		DungeonCharacter testHero = null;
		DungeonCharacter testMonster = null;
		
		try {
			testSelfHeal.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}

}
