package dungeon;

public class CrushingBlow implements Attack {

	@Override
	public String getName() {
		return "Crushing Blow";
	}

	@Override
	public void preform(DungeonCharacter attacking, DungeonCharacter opponent) {
		if(attacking == null || opponent == null) {
			throw new IllegalArgumentException("Either attacker or opponent were passed in as null");
		}
		
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(attacking.getName() + " lands a CRUSHING BLOW for " + blowPoints + " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		
		else
		{
			System.out.println(attacking.getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed

	}

}
