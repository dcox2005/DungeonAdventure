package dungeon;

public class BasicAttack implements Attack {

	@Override
	public void preform(DungeonCharacter attacking, DungeonCharacter opponent) {
		
		if(attacking == null || opponent == null) {
			throw new IllegalArgumentException("Either attacker or opponent were passed in as null");
		}
		
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= attacking.getChanceToHit();

		if (canAttack){
			System.out.println(attacking.getName() + attacking.getWeapon().toString() +
					opponent.getName() + ":");
			damage = (int)(Math.random() * (attacking.getDamageMax() - attacking.getDamageMin() + 1))
						+ attacking.getDamageMin() ;
			opponent.getAttacked(damage);
			System.out.println();
		}//end if can attack
		else{
			System.out.println(attacking.getName() + "'s attack on " + opponent.getName() +
								" failed!");
			System.out.println();
		}//end else

	}

	@Override
	public String getName() {
		
		return "Basic Attack";
	}


}
