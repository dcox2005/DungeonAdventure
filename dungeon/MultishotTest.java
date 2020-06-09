package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultishotTest {

	@Test
	void testPreform_ShouldThrowExcepionForNullAttacker() {
		Multishot testMultishotAttack = new Multishot();
		DungeonCharacter testHero = null;
		DungeonCharacter testMonster = new Ogre();
		
		try {
			testMultishotAttack.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testPreform_ShouldThrowExcepionForNullOpponent() {
		Multishot testMultishotAttack = new Multishot();
		DungeonCharacter testHero = new Sorceress("Bill");
		DungeonCharacter testMonster = null;
		
		try {
			testMultishotAttack.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testPreform_ShouldThrowExcepionForBothCharatersNull() {
		Multishot testMultishotAttack = new Multishot();
		DungeonCharacter testHero = null;
		DungeonCharacter testMonster = null;
		
		try {
			testMultishotAttack.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}

}
