package dungeon;

public class SelfHeal implements Attack {

	private int MAX_SELFHEAL_VALUE = 25;
	private int MIN_SELFHEAL_VALUE = 20;

	@Override
	public String getName() {
		return "Self Heal";
	}

	@Override
	public void preform(DungeonCharacter attacking, DungeonCharacter opponent) {
		
		if(attacking == null || opponent == null) {
			throw new IllegalArgumentException("Either attacker or opponent were passed in as null");
		}
		
		int hPoints;
		hPoints = (int)(Math.random() * (MAX_SELFHEAL_VALUE - MIN_SELFHEAL_VALUE + 1)) + MIN_SELFHEAL_VALUE;
		attacking.addHitPoints(hPoints);
		System.out.println(attacking.getName() + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: " + attacking.getHitPoints());
		System.out.println();
	}

}
