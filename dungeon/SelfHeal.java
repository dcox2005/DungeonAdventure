package dungeon;

public class SelfHeal implements SpecialAbility {

	private int MAX_SELFHEAL_VALUE;
	private int MIN_SELFHEAL_VALUE;

	public SelfHeal(int MIN_ADD, int MAX_ADD) {
		this.MIN_SELFHEAL_VALUE = MIN_ADD;
		this.MAX_SELFHEAL_VALUE = MAX_ADD;
	}

	@Override
	public String getName() {
		return "Self Heal";
	}

	@Override
	public void preform(Hero hero, DungeonCharacter opponent) {
		int hPoints;
		hPoints = (int)(Math.random() * (MAX_SELFHEAL_VALUE - MIN_SELFHEAL_VALUE + 1)) + MIN_SELFHEAL_VALUE;
		hero.addHitPoints(hPoints);
/*		System.out.println(name + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ hitPoints);
*/		System.out.println(hero.getName() + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: " + hero.getHitPoints());
		System.out.println();
	}

}
