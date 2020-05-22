package dungeon;

public class CrushingBlow implements SpecialAbility {

	@Override
	public String getName() {
		return "Crushing Blow";
	}

	@Override
	public void preform(Hero hero, DungeonCharacter opponent) {
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(hero.getName() + " lands a CRUSHING BLOW for " + blowPoints + " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		
		else
		{
			System.out.println(hero.getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed

	}

}
