package dungeon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HealingPotionTest {

		@Test
		void testPreform_ShouldThrowExcepionForNull() {
			Hero testHero = null;
			
			try {
				HealingPotion.useItem(testHero);
				assertTrue(false);
			}
			
			catch(IllegalArgumentException e) {
				assertTrue(true);
			}

	}

}