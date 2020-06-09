package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SupriseAttackTest {

	@Test
	void testPreform_ShouldThrowExcepionForNullAttacker() {
		SupriseAttack testSupriseAttack = new SupriseAttack();
		DungeonCharacter testHero = null;
		DungeonCharacter testMonster = new Ogre();
		
		try {
			testSupriseAttack.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testPreform_ShouldThrowExcepionForNullOpponent() {
		SupriseAttack testSupriseAttack = new SupriseAttack();
		DungeonCharacter testHero = new Sorceress("Bill");
		DungeonCharacter testMonster = null;
		
		try {
			testSupriseAttack.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testPreform_ShouldThrowExcepionForBothCharatersNull() {
		SupriseAttack testSupriseAttack = new SupriseAttack();
		DungeonCharacter testHero = null;
		DungeonCharacter testMonster = null;
		
		try {
			testSupriseAttack.preform(testHero, testMonster);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}

}
