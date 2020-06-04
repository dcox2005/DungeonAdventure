package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoomTest 
{

	//Room (boolean northDoor, boolean eastDoor, boolean southDoor, 
	//			boolean westDoor, boolean entrance, boolean exit, boolean pillarOfOO)
	
	@Test
	void testIfToStringPrintsTheRoomProperly_EmptyRoomNoDoor() 
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testIfToStringPrintsTheRoomProperly_EmptyRoomNoDoor-----");
		
		Room testRoom = new Room(false, false, false, false, false, false, false);
		testRoom.setHealingPotion(null);
		testRoom.setVisionPotion(null);
		testRoom.setEnemy(null);
		testRoom.setHasPit(false);
		System.out.println(testRoom.toString());
		String resultsShouldBe = "***\n*E*\n***";
		assertTrue((testRoom.toString()).equalsIgnoreCase(resultsShouldBe));
	}//end testIfToStringPrintsTheRoomProperly_EmptyRoomNoDoor	
	
	@Test
	void testRoomWithOnlyNorthDoor_EmptyRoom() 
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testRoomWithOnlyNorthDoor_EmptyRoom-----");
		Room testRoom = new Room(true, false, false, false, false, false, false);
		System.out.println(testRoom.toString());
		testRoom.setHealingPotion(null);
		testRoom.setVisionPotion(null);
		testRoom.setEnemy(null);
		testRoom.setHasPit(false);
		String resultsShouldBe = "*-*\n*E*\n***";
		assertTrue((testRoom.toString()).equalsIgnoreCase(resultsShouldBe));
	}//end testRoomWithOnlyNorthDoor_EmptyRoom
	
	@Test
	void testRoomWithOnlySouthDoor_EmptyRoom()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testRoomWithOnlySouthDoor_EmptyRoom-----");
		Room testRoom = new Room(false, false, true, false, false, false, false);
		testRoom.setHealingPotion(null);
		testRoom.setVisionPotion(null);
		testRoom.setEnemy(null);
		testRoom.setHasPit(false);
		System.out.println(testRoom.toString());
		String resultsShouldBe = "***\n*E*\n*-*";
		assertTrue((testRoom.toString()).equalsIgnoreCase(resultsShouldBe));	
	}//end testRoomWithOnlySouthDoor_EmptyRoom

	@Test
	void testRoomWithOnlyEastDoor_EmptyRoom()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testRoomWithOnlyEastDoor_EmptyRoom-----");
		Room testRoom = new Room(false, true, false, false, false, false, false);
		testRoom.setHealingPotion(null);
		testRoom.setVisionPotion(null);
		testRoom.setEnemy(null);
		testRoom.setHasPit(false);
		System.out.println(testRoom.toString());
		String resultsShouldBe = "***\n*E|\n***";
		assertTrue((testRoom.toString()).equalsIgnoreCase(resultsShouldBe));	
	}//end testRoomWithOnlyEastDoor_EmptyRoom
	
	@Test
	void testRoomWithOnlyWestDoor_EmptyRoom()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testRoomWithOnlyWestDoor_EmptyRoom-----");
		Room testRoom = new Room(false, false, false, true, false, false, false);
		testRoom.setHealingPotion(null);
		testRoom.setVisionPotion(null);
		testRoom.setEnemy(null);
		testRoom.setHasPit(false);
		System.out.println(testRoom.toString());
		String resultsShouldBe = "***\n|E*\n***";
		assertTrue((testRoom.toString()).equalsIgnoreCase(resultsShouldBe));		
	}//end testRoomWithOnlyWestDoor_EmptyRoom
	
	@Test
	void testRoomWithAllDoors_EmptyRoom()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testRoomWithAllDoors_EmptyRoom-----");
		Room testRoom = new Room(true, true, true, true, false, false, false);
		testRoom.setHealingPotion(null);
		testRoom.setVisionPotion(null);
		testRoom.setEnemy(null);
		testRoom.setHasPit(false);
		System.out.println(testRoom.toString());
		String resultsShouldBe = "*-*\n|E|\n*-*";
		assertTrue((testRoom.toString()).equalsIgnoreCase(resultsShouldBe));		
	}//end testRoomWithAllDoors_EmptyRoom
	
	@Test
	void testRoomWithAllDoors_EntranceOnly()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testRoomWithAllDoors_EntranceOnly-----");
		Room testRoom = new Room(true, true, true, true, true, false, false);
		testRoom.setHealingPotion(null);
		testRoom.setVisionPotion(null);
		testRoom.setEnemy(null);
		testRoom.setHasPit(false);
		System.out.println(testRoom.toString());
		assertTrue(testRoom.hasEntrance());	
	}//end testRoomWithAllDoors_EntranceOnly
	
	@Test
	void testRoomWithAllDoors_ExitOnly()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testRoomWithAllDoors_ExitOnly-----");
		Room testRoom = new Room(true, true, true, true, false, true, false);
		testRoom.setHealingPotion(null);
		testRoom.setVisionPotion(null);
		testRoom.setEnemy(null);
		testRoom.setHasPit(false);
		System.out.println(testRoom.toString());
		assertTrue(testRoom.hasExit());	
	}//end testRoomWithAllDoors_ExitOnly

	@Test
	void testRoomWithAllDoors_PillarOnly()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testRoomWithAllDoors_PillarOnly-----");
		Room testRoom = new Room(true, true, true, true, false, false, true);
		testRoom.setHealingPotion(null);
		testRoom.setVisionPotion(null);
		testRoom.setEnemy(null);
		testRoom.setHasPit(false);
		System.out.println(testRoom.toString());
		assertTrue(testRoom.hasPillarOfOO());	
	}//end testRoomWithAllDoors_PillarOnly

	@Test
	void testRoomWithAllDoor_HealingPotionOnly()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testRoomWithAllDoors_HealingPotionOnly-----");
		Room testRoom = new Room(true, true, true, true, false, false, false);
		testRoom.setHealingPotion(new HealingPotion());
		testRoom.setVisionPotion(null);
		testRoom.setEnemy(null);
		testRoom.setHasPit(false);
		System.out.println(testRoom.toString());
		assertTrue(testRoom.getHealingPotion() != null);	
	}//end testRoomWithAllDoors_HealingPotionOnly
	
	@Test
	void testPitDamage_ShouldBeBetweenOneAndTwenty()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testPitDamage_ShouldBeBetweenOneAndTwenty-----");
		Room testRoom = new Room(true, true, true, true, false, false, false);
		testRoom.setHasPit(true);
		testRoom.setHero(new Thief("TestCharacter"));
		int pitDamage = testRoom.pitDamage();
		assertTrue(pitDamage >= 1 && pitDamage <= 20);
	}//end testPitDamage_ShouldBeBetweenOneAndTwenty
	
	@Test
	void testPitDamage_ShouldBeZeroIfThereIsNoPit()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testPitDamage_ShouldBeZeroIfThereIsNoPit-----");
		Room testRoom = new Room(true, true, true, true, false, false, false);
		testRoom.setHasPit(false);
		int pitDamage = testRoom.pitDamage();
		assertTrue(pitDamage == 0);
	}//end testPitDamage_ShouldBeZeroIfThereIsNoPit

	
}//end RoomTest
