package dungeon;

public class HealingPotion implements BackPackItem
{
	private static int MAX_HEALING_VALUE = 15;
	private static int MIN_HEALING_VALUE = 5;
	
	static void useItem(Hero hero) 
	{
		int healthPoints;
		healthPoints = (int)(Math.random() * (MAX_HEALING_VALUE - MIN_HEALING_VALUE + 1)) + MIN_HEALING_VALUE;
		hero.addHitPoints(healthPoints);
		System.out.println(hero.getName() + " added [" + healthPoints + "] points.\n" + "Total hit points remaining are: " + hero.getHitPoints());
		System.out.println();		
	}//end useItem()

}//end HealingPotion Class
