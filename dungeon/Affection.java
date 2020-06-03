package dungeon;


public class Affection implements Weapon
	{	
		private String name;
		
		public Affection() {
			this.name = " Affection ";
		}
		
		
		@Override
		public String weaponName() 
		{
			return this.name;
		}//end weaponName
		
		@Override
		public String toString() 
		{
			return " IS SO CUTE IT HURTS, it nuzzled against ";
		}//end weaponName

	}//end affection


