import java.util.LinkedHashMap;

/**Class: ZombieFactory.java
 * @author Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Nov 21, 2016
 * 
 *
 * This class creates and collects Zombie objects.
 *
 * Purpose: To organize Zombie creation into a separate class.
 */

public class ZombieFactory
{
	
	private static LinkedHashMap<String, Zombie> allZombies = new LinkedHashMap<String, Zombie>();
	
	/**createZombies
	 * Creates all the zombies for the game.
	 * @return allZombies
	 */
	public static LinkedHashMap<String, Zombie> createZombies()
	{
		//Zombie(String monsterID, int maxHealth, int attack, LinkedHashMap<String, Artifact> inventory,
		//int specialAttackChance, int SpecialAttackHitChance)
		Zombie tempZom;
		
		tempZom = new Zombie("M01", 50, 1, null, "Patient Zombie", "Standard attack", null, 0, 0);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Patient"
		tempZom = new Zombie("M02", 60, 1, null, "Janitor Zombie", "Mop-Handle Attack", null, 75, 50);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Janitor"
		tempZom = new Zombie("M03", 70, 1, null, "Nurse Zombie", "Syringe Attack", null, 75, 50);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Nurse"
		tempZom = new Zombie("M04", 80, 1, null, "Doctor Zombie", "Cold-Stethoscope Attack",
				"You can now only attack every two turns!", 60, 20);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Doctor"
		tempZom = new Zombie("M05", 90, 1, null, "Plastic Surgeon Zombie", "Skin Graft Buff", 
				"Damage done to Plastic Surgeon Zombie is now reduced by 50% for two turns", 50, 0);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Plastic Surgeon"
		tempZom = new Zombie("M06", 95, 1, null, "Brain Surgeon Zombie", "Brain-Removal Attack", 
				"You're incapacitated for three turns!", 10, 100);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Brain Surgeon"
		tempZom = new Zombie("M07", 100, 1, null, "Surgeon General Zombie", "Insurance Not Accepted Attack", 
				null, 5, 100);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Surgeon General"
		tempZom = new Zombie("M08", 40, 1, null, "Secretary Zombie", "Standard attack", 
				null, 100, 40);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Secretary"
		
		return allZombies;
	}
	
	public static LinkedHashMap<String, Zombie> getAllZombies()
	{
		allZombies = createZombies();
		return allZombies;
	}

	/**
	 * @param allZombies the allZombies to set
	 */
	public static void setAllZombies(LinkedHashMap<String, Zombie> allZombies)
	{
		ZombieFactory.allZombies = allZombies;
	}

}
