package dungeon;


public class Kitten extends Monster {
	
	 Kitten()
		{
			super("Tiger.... the Kitten");
			this.setHitPoints(30);
			this.setAttackSpeed(9);
			this.setChanceToHit(0.5);
			this.setChanceToHeal(0.8);
			this.setDamageMin(1);
			this.setDamageMax(5);
			this.setMinHeal(5);
			this.setMaxHeal(30);
			this.setWeapon(new Affection());
	    }//end constructor

}
