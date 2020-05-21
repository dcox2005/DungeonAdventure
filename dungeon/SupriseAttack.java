package dungeon;

public class SupriseAttack implements SpecialAbility {

	@Override
	public String getName() {
		return "Suprise Attack";
	}

	@Override
	public void preform(Hero hero, DungeonCharacter opponent) {
		double surprise = Math.random();
		if (surprise <= .4)
		{
/*			System.out.println("Surprise attack was successful!\n" +
								name + " gets an additional turn.");
			numTurns++;
*/
			System.out.println("Surprise attack was successful!\n" + this.getName() + " gets an additional turn.");
			hero.setNumTurns(hero.getNumTurns() + 1);
			hero.attack(opponent);

		}//end surprise
		
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}//end else if
		
		else
		   hero.attack(opponent);
	

	}

}
