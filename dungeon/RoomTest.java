package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoomTest 
{	
	@Test
	void testIfToStringPrintsTheRoomProperly_EmptyRoomNoDoor_TrueIfPrintOutShowsEmptyAndNoDoors() 
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testIfToStringPrintsTheRoomProperly_EmptyRoomNoDoor_TrueIfPrintOutShowsEmptyAndNoDoors-----");
		Room testRoom = new Room();
		System.out.println(testRoom.toString());
		String resultsShouldBe = "***\n*E*\n***";
		assertTrue((testRoom.toString()).equalsIgnoreCase(resultsShouldBe));
	}//end testIfToStringPrintsTheRoomProperly_EmptyRoomNoDoor_TrueIfPrintOutShowsEmptyAndNoDoors	
	
	@Test
	void testRoomWithOnlyNorthDoor_EmptyRoom_ShouldBeTrueIfPrintOutReflectsNorthDoorAndEmpty() 
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testRoomWithOnlyNorthDoor_EmptyRoom_ShouldBeTrueIfPrintOutReflectsNorthDoorAndEmpty-----");
		Room testRoom = new Room();
		testRoom.setNorthDoor(true);
		System.out.println(testRoom.toString());
		String resultsShouldBe = "*-*\n*E*\n***";
		assertTrue((testRoom.toString()).equalsIgnoreCase(resultsShouldBe));
	}//end testRoomWithOnlyNorthDoor_EmptyRoom_ShouldBeTrueIfPrintOutReflectsNorthDoorAndEmpty
	
	@Test
	void testRoomWithOnlySouthDoor_EmptyRoom_ShouldBeTrueIfPrintOutReflectsSouthDoorAndEmpty()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testRoomWithOnlySouthDoor_EmptyRoom_ShouldBeTrueIfPrintOutReflectsSouthDoorAndEmpty-----");
		Room testRoom = new Room();
		testRoom.setSouthDoor(true);
		System.out.println(testRoom.toString());
		String resultsShouldBe = "***\n*E*\n*-*";
		assertTrue((testRoom.toString()).equalsIgnoreCase(resultsShouldBe));	
	}//end testRoomWithOnlySouthDoor_EmptyRoom_ShouldBeTrueIfPrintOutReflectsSouthDoorAndEmpty

	@Test
	void testRoomWithOnlyEastDoor_EmptyRoom_ShouldBeTrueIfPrintOutReflectsEastDoorAndEmpty()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testRoomWithOnlyEastDoor_EmptyRoom_ShouldBeTrueIfPrintOutReflectsEastDoorAndEmpty-----");
		Room testRoom = new Room();
		testRoom.setEastDoor(true);
		System.out.println(testRoom.toString());
		String resultsShouldBe = "***\n*E|\n***";
		assertTrue((testRoom.toString()).equalsIgnoreCase(resultsShouldBe));	
	}//end testRoomWithOnlyEastDoor_EmptyRoom_ShouldBeTrueIfPrintOutReflectsEastDoorAndEmpty
	
	@Test
	void testRoomWithOnlyWestDoor_EmptyRoom_ShouldBeTrueIfPrintOutReflectsWestDoorAndEmpty()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testRoomWithOnlyWestDoor_EmptyRoom_ShouldBeTrueIfPrintOutReflectsWestDoorAndEmpty-----");
		Room testRoom = new Room();
		testRoom.setWestDoor(true);
		System.out.println(testRoom.toString());
		String resultsShouldBe = "***\n|E*\n***";
		assertTrue((testRoom.toString()).equalsIgnoreCase(resultsShouldBe));		
	}//end testRoomWithOnlyWestDoor_EmptyRoom_ShouldBeTrueIfPrintOutReflectsWestDoorAndEmpty
	
	@Test
	void testRoomWithAllDoors_EmptyRoom_ShouldBeTrueIfPrintOutReflectsAllDoorsAndEmpty()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testRoomWithAllDoors_EmptyRoom_ShouldBeTrueIfPrintOutReflectsAllDoorsAndEmpty-----");
		Room testRoom = new Room();
		testRoom.setNorthDoor(true);
		testRoom.setEastDoor(true);
		testRoom.setSouthDoor(true);
		testRoom.setWestDoor(true);
		System.out.println(testRoom.toString());
		String resultsShouldBe = "*-*\n|E|\n*-*";
		assertTrue((testRoom.toString()).equalsIgnoreCase(resultsShouldBe));		
	}//end testRoomWithAllDoors_EmptyRoom_ShouldBeTrueIfPrintOutReflectsAllDoorsAndEmpty
	
	@Test
	void testSetExit_RoomWithAllDoorAndEntranceOnlyInside_ShouldTestTrueEntranceIsNotFalseAndPrintOutShowsOnlyEntrance()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testSetExit_RoomWithAllDoorAndEntranceOnlyInside_ShouldTestTrueEntranceIsNotFalseAndPrintOutShowsOnlyEntrance-----");
		Room testRoom = new Room();
		testRoom.setNorthDoor(true);
		testRoom.setEastDoor(true);
		testRoom.setSouthDoor(true);
		testRoom.setWestDoor(true);
		testRoom.setEntrance(true);
		System.out.println(testRoom.toString());
		String resultsShouldBe = "*-*\n|I|\n*-*";
		assertTrue(testRoom.hasEntrance() && 
				testRoom.toString().equalsIgnoreCase(resultsShouldBe));
	}//end testSetExit_RoomWithAllDoorAndEntranceOnlyInside_ShouldTestTrueEntranceIsNotFalseAndPrintOutShowsOnlyEntrance
	
	@Test
	void testSetExit_RoomWithAllDoorAndExitOnlyInside_ShouldTestTrueExitIsNotFalseAndPrintOutShowsOnlyExit()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testSetExit_RoomWithAllDoorAndExitOnlyInside_ShouldTestTrueExitIsNotFalseAndPrintOutShowsOnlyExit-----");
		Room testRoom = new Room();
		testRoom.setNorthDoor(true);
		testRoom.setEastDoor(true);
		testRoom.setSouthDoor(true);
		testRoom.setWestDoor(true);
		testRoom.setExit(true);
		System.out.println(testRoom.toString());
		String resultsShouldBe = "*-*\n|O|\n*-*";
		assertTrue(testRoom.hasExit() && 
				testRoom.toString().equalsIgnoreCase(resultsShouldBe));	
		}//end testSetExit_RoomWithAllDoorAndExitOnlyInside_ShouldTestTrueExitIsNotFalseAndPrintOutShowsOnlyExit

	@Test
	void testSetPillarOfOO_RoomWithAllDoorAndPillarOfOOOnlyInside_ShouldTestTruePillarOfOOIsNotFalseAndPrintOutShowsOnlyPillarOfOO()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testSetPillarOfOO_RoomWithAllDoorAndPillarOfOOOnlyInside_ShouldTestTruePillarOfOOIsNotFalseAndPrintOutShowsOnlyPillarOfOO-----");
		Room testRoom = new Room();
		testRoom.setNorthDoor(true);
		testRoom.setEastDoor(true);
		testRoom.setSouthDoor(true);
		testRoom.setWestDoor(true);
		testRoom.setPillarOfOO(true);
		System.out.println(testRoom.toString());
		String resultsShouldBe = "*-*\n|Y|\n*-*";
		assertTrue(testRoom.hasPillarOfOO() && 
				testRoom.toString().equalsIgnoreCase(resultsShouldBe));
	}//end testSetPillarOfOO_RoomWithAllDoorAndPillarOfOOOnlyInside_ShouldTestTruePillarOfOOIsNotFalseAndPrintOutShowsOnlyPillarOfOO
	
	@Test
	void testSetHasPit_RoomWithAllDoorAndPitOnlyInside_ShouldTestTruePitIsNotFalseAndPrintOutShowsOnlyPit()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testSetHasPit_RoomWithAllDoorAndPitOnlyInside_ShouldTestTruePitIsNotFalseAndPrintOutShowsOnlyPit-----");
		Room testRoom = new Room();
		testRoom.setNorthDoor(true);
		testRoom.setEastDoor(true);
		testRoom.setSouthDoor(true);
		testRoom.setWestDoor(true);
		testRoom.setHasPit(true);
		System.out.println(testRoom.toString());
		String resultsShouldBe = "*-*\n|P|\n*-*";
		assertTrue(testRoom.hasPit() && 
				testRoom.toString().equalsIgnoreCase(resultsShouldBe));
	}//end testSetHasPit_RoomWithAllDoorAndPitOnlyInside_ShouldTestTruePitIsNotFalseAndPrintOutShowsOnlyPit

	@Test
	void testSetHealingPotion_RoomWithAllDoorAndHealingPotionOnlyInside_ShouldTestTrueHealingPotionIsNotNullAndPrintOutShowsOnlyHealingPotion()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testSetHealingPotion_RoomWithAllDoorAndHealingPotionOnlyInside_ShouldTestTrueHealingPotionIsNotNullAndPrintOutShowsOnlyHealingPotion-----");
		Room testRoom = new Room();
		testRoom.setNorthDoor(true);
		testRoom.setEastDoor(true);
		testRoom.setSouthDoor(true);
		testRoom.setWestDoor(true);
		testRoom.setHealingPotion(new HealingPotion());
		System.out.println(testRoom.toString());
		String resultsShouldBe = "*-*\n|H|\n*-*";
		assertTrue(testRoom.getHealingPotion() != null && 
				testRoom.toString().equalsIgnoreCase(resultsShouldBe));
	}//end testSetHealingPotion_RoomWithAllDoorAndHealingPotionOnlyInside_ShouldTestTrueHealingPotionIsNotNullAndPrintOutShowsOnlyHealingPotion
	
	@Test
	void testSetVisionPotion_RoomWithAllDoorAndVisionPotionOnlyInside_ShouldTestTrueVisionPotionIsNotNullAndPrintOutShowsOnlyVisionPotion()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testSetVisionPotion_RoomWithAllDoorAndVisionPotionOnlyInside_ShouldTestTrueVisionPotionIsNotNullAndPrintOutShowsOnlyVisionPotion-----");
		Room testRoom = new Room();
		testRoom.setNorthDoor(true);
		testRoom.setEastDoor(true);
		testRoom.setSouthDoor(true);
		testRoom.setWestDoor(true);
		testRoom.setVisionPotion(new VisionPotion());
		System.out.println(testRoom.toString());
		String resultsShouldBe = "*-*\n|V|\n*-*";
		assertTrue(testRoom.getVisionPotion() != null && 
				testRoom.toString().equalsIgnoreCase(resultsShouldBe));
	}//end testSetVisionPotion_RoomWithAllDoorAndVisionPotionOnlyInside_ShouldTestTrueVisionPotionIsNotNullAndPrintOutShowsOnlyVisionPotion
	
	@Test
	void testSetEnemy_RoomWithAllDoorAndMonsterOnlyInside_ShouldTestTrueIfMonsterIsNotNullAndPrintOutShowsOnlyMonster()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testSetEnemy_RoomWithAllDoorAndMonsterOnlyInside_ShouldTestTrueIfMonsterIsNotNullAndPrintOutShowsOnlyMonster-----");
		Room testRoom = new Room();
		testRoom.setNorthDoor(true);
		testRoom.setEastDoor(true);
		testRoom.setSouthDoor(true);
		testRoom.setWestDoor(true);
		testRoom.setEnemy(MonsterFactory.createMonster());
		System.out.println(testRoom.toString());
		String resultsShouldBe = "*-*\n|X|\n*-*";
		assertTrue(testRoom.getEnemy() != null && 
				testRoom.toString().equalsIgnoreCase(resultsShouldBe));
	}//end testSetEnemy_RoomWithAllDoorAndMonsterOnlyInside_ShouldTestTrueIfMonsterIsNotNullAndPrintOutShowsOnlyMonster
	
	@Test
	void testPitDamage_ShouldBeBetweenOneAndTwenty()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testPitDamage_ShouldBeBetweenOneAndTwenty-----");
		Room testRoom = new Room();
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
		Room testRoom = new Room();
		int pitDamage = testRoom.pitDamage();
		assertTrue(pitDamage == 0);
	}//end testPitDamage_ShouldBeZeroIfThereIsNoPit

	@Test
	void testSetNumberOfThingsInRoom_ShouldBeEqualToAmountSet()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testSetNumberOfThingsInRoom_ShouldBeEqualToAmountSet-----");
		Room testRoom = new Room();
		testRoom.setNorthDoor(true);
		testRoom.setEastDoor(true);
		testRoom.setSouthDoor(true);
		testRoom.setWestDoor(true);
		testRoom.setEntrance(false);
		testRoom.setExit(false);
		testRoom.setPillarOfOO(false);
		testRoom.setHasPit(false);
		int numberOfThingsWantedInRoom = 5;
		testRoom.setNumberOfThingsInRoom(numberOfThingsWantedInRoom);
		assertTrue(testRoom.getNumberOfThingsInRoom() == 5);
	}//end testSetNumberOfThingsInRoom_ShouldBeEqualToAmountSet
	
	@Test
	void testSetNumberOfThingsInRoom_ShouldThrowExceptionIfLessThan0()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("-----testSetNumberOfThingsInRoom_ShouldThrowExceptionIfLessThan0-----");
		Room testRoom = new Room();
		testRoom.setNorthDoor(true);
		testRoom.setEastDoor(true);
		testRoom.setSouthDoor(true);
		testRoom.setWestDoor(true);
		testRoom.setEntrance(false);
		testRoom.setExit(false);
		testRoom.setPillarOfOO(false);
		testRoom.setHasPit(false);
		int numberOfThingsWantedInRoom = -1;
		try
		{
			testRoom.setNumberOfThingsInRoom(numberOfThingsWantedInRoom);
			assertTrue(false);
		}//end try
		
		catch (IllegalArgumentException e)
		{
			assertTrue(true);
		}//end catch
		
	}//end testSetNumberOfThingsInRoom_ShouldThrowExceptionIfLessThan0
	
}//end RoomTest
