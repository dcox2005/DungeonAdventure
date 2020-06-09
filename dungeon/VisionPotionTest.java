package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class VisionPotionTest {
	@Test
	void testPreform_ShouldThrowExcepionForNull() {
		Dungeon dungeon = null;
		
		try {
			VisionPotion.useItem(dungeon);
			assertTrue(false);
		}
		
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}

}
}
