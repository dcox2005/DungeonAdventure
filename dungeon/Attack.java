package dungeon;

public interface Attack{

	String getName();

	void preform(DungeonCharacter attacker, DungeonCharacter opponent);

}
