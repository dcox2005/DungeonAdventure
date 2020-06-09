package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BasicAttackTest {

	@Test
	void testPreform_ShouldThrowExcepionForNullAttacker() {
		BasicAttack testBasicAttack = new BasicAttack();
		DungeonCharacter testHero = null;
		DungeonCharacter testMonster = new Ogre();
		
		try {
			testBasicAttack.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testPreform_ShouldThrowExcepionForNullOpponent() {
		BasicAttack testBasicAttack = new BasicAttack();
		DungeonCharacter testHero = new Sorceress("Bill");
		DungeonCharacter testMonster = null;
		
		try {
			testBasicAttack.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testPreform_ShouldThrowExcepionForBothCharatersNull() {
		BasicAttack testBasicAttack = new BasicAttack();
		DungeonCharacter testHero = null;
		DungeonCharacter testMonster = null;
		
		try {
			testBasicAttack.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
}
