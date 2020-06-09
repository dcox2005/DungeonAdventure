package dungeon;

import java.util.HashMap;
import java.util.Map;

public class AttackFactory {
	private static Map<String, Attack> attackTypes = new HashMap<String, Attack>();
	
	private static void createNewMap() {
		attackTypes.put("Basic Attack", new BasicAttack());
		attackTypes.put("Crushing Blow", new CrushingBlow());
		attackTypes.put("Multishot", new Multishot());
		attackTypes.put("Self Heal", new SelfHeal());
		attackTypes.put("Suprise Attack", new SupriseAttack());
	}
	
	public static Attack getBasicAttack() {
		if(attackTypes.size() == 0) {
			createNewMap();
		}
		return attackTypes.get("Basic Attack");
	}
	
	public static Attack getCrushingBlowAttack() {
		if(attackTypes.size() == 0) {
			createNewMap();
		}
		return attackTypes.get("Crushing Blow");
	}
	
	public static Attack getMultishotAttack() {
		if(attackTypes.size() == 0) {
			createNewMap();
		}
		return attackTypes.get("Multishot");
	}
	
	public static Attack getSelfHealAttack() {
		if(attackTypes.size() == 0) {
			createNewMap();
		}
		return attackTypes.get("Self Heal");
	}
	
	public static Attack getSupriseAttack() {
		if(attackTypes.size() == 0) {
			createNewMap();
		}
		return attackTypes.get("Suprise Attack");
	}
}
