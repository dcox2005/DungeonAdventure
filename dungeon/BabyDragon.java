package dungeon;


public class BabyDragon extends Monster {
	
	BabyDragon()
	{
		super("Skithryx the Baby Dragon");
		this.setHitPoints(250);
		this.setAttackSpeed(3);
		this.setChanceToHit(0.7);
		this.setChanceToHeal(0.1);
		this.setDamageMin(35);
		this.setDamageMax(55);
		this.setMinHeal(20);
		this.setMaxHeal(40);
		this.setWeapon(new Fireball());
    }//end constructor

}
