package dungeon;

public class SupriseAttack implements Attack {

	@Override
	public String getName() {
		return "Suprise Attack";
	}

	@Override
	public void preform(DungeonCharacter attacker, DungeonCharacter opponent) {
		
		if(attacker == null || opponent == null) {
			throw new IllegalArgumentException("Either attacker or opponent were passed in as null");
		}
		
		double surprise = Math.random();
		if (surprise <= .4)
		{ 
			System.out.println("Surprise attack was successful!\n" + this.getName() + " gets an additional turn.");
			//attacker.setNumTurns(attacker.getNumTurns() + 1);
			attacker.attack(opponent);
			attacker.attack(opponent);

		}//end surprise
		
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}//end else if
		
		else
		   attacker.attack(opponent);
	

	}

}
