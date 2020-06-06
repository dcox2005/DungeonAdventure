package dungeon;

public class SelfHeal implements Attack {

	private int MAX_SELFHEAL_VALUE = 25;
	private int MIN_SELFHEAL_VALUE = 20;

	@Override
	public String getName() {
		return "Self Heal";
	}

	@Override
	public void preform(DungeonCharacter attacker, DungeonCharacter opponent) {
		int hPoints;
		hPoints = (int)(Math.random() * (MAX_SELFHEAL_VALUE - MIN_SELFHEAL_VALUE + 1)) + MIN_SELFHEAL_VALUE;
		attacker.addHitPoints(hPoints);
		System.out.println(attacker.getName() + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: " + attacker.getHitPoints());
		System.out.println();
	}

}
