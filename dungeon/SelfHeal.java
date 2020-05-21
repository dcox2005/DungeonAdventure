package dungeon;

public class SelfHeal implements SpecialAbility {

	private int MAX_ADD;
	private int MIN_ADD;

	public SelfHeal(int MIN_ADD, int MAX_ADD) {
		this.MIN_ADD = MIN_ADD;
		this.MAX_ADD = MAX_ADD;
	}

	@Override
	public String getName() {
		return "Self Heal";
	}

	@Override
	public void preform(Hero hero, DungeonCharacter opponent) {
		int hPoints;
		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		hero.addHitPoints(hPoints);
/*		System.out.println(name + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ hitPoints);
*/		System.out.println(hero.getName() + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: " + hero.getHitPoints());
		System.out.println();
	}

}
