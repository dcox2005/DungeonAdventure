package dungeon;

public class Multishot implements Attack {

	private int maxNumOfShots = 5;
	private int minNumOfShots = 1;
	
	@Override
	public String getName() {
		
		return "Multishot";
	}

	@Override
	public void preform(DungeonCharacter attacking, DungeonCharacter opponent) {
		
		if(attacking == null || opponent == null) {
			throw new IllegalArgumentException("Either attacker or opponent were passed in as null");
		}
		
		int numOfShots = (int) Math.random() * (maxNumOfShots - minNumOfShots + 1) + minNumOfShots;
		System.out.println(attacking.getName() +"has recived " +numOfShots);
		for(int i = 0; i < numOfShots; i++) {
			attacking.attack(opponent);
		}
	}

}
