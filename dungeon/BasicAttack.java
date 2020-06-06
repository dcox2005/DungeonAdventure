package dungeon;

public class BasicAttack implements Attack {

	@Override
	public void preform(DungeonCharacter attacker, DungeonCharacter opponent) {
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= attacker.getChanceToHit();

		if (canAttack){
			System.out.println(attacker.getName() + attacker.getWeapon().toString() +
					opponent.getName() + ":");
			damage = (int)(Math.random() * (attacker.getDamageMax() - attacker.getDamageMin() + 1))
						+ attacker.getDamageMin() ;
			opponent.getAttacked(damage);
			System.out.println();
		}//end if can attack
		else{
			System.out.println(getName() + "'s attack on " + opponent.getName() +
								" failed!");
			System.out.println();
		}//end else

	}

	@Override
	public String getName() {
		
		return "Regular Attack";
	}


}
