package dungeon;

public class Multishot implements Attack {

	private final int MAX_NUM_OF_SHOTS = 5;
	private final int MIN_NUM_OF_SHOTS = 1;
	
	@Override
	public String getName() {
		
		return "Multishot";
	}

	@Override
	public void preform(DungeonCharacter attacking, DungeonCharacter opponent) {
		
		if(attacking == null || opponent == null) {
			throw new IllegalArgumentException("Either attacker or opponent were passed in as null");
		}
		
		int numOfShots = (int) Math.random() * (MAX_NUM_OF_SHOTS - MIN_NUM_OF_SHOTS + 1) + MIN_NUM_OF_SHOTS;
		System.out.println(attacking.getName() +"has recived " +numOfShots);
		for(int i = 0; i < numOfShots; i++) {
			attacking.attack(opponent);
		}
	}

}
