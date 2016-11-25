import java.util.LinkedHashMap;

/**Class: ZombieFactory.java
 * @author Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Nov 21, 2016
 * 
 *
 * This class - now describe what the class does
 *
 * Purpose: - Describe the purpose of this class
 */

public class ZombieFactory
{

	/**
	 * 
	 */
private static LinkedHashMap<String, Zombie> allZombies = new LinkedHashMap<String, Zombie>();
	
	public void createZombies()
	{
		//Zombie(String monsterID, int maxHealth, int attack, LinkedHashMap<String, Artifact> inventory,
		//int specialAttackChance, int SpecialAttackHitChance)
		Zombie tempZom;
		
		tempZom = new Zombie("MO1", 50, 1, null, "Patient Zombie", "Standard attack", 0, 0);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Patient"
		tempZom = new Zombie("MO2", 60, 1, null, "Janitor Zombie", "Mop-Handle Attack", 75, 50);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Janitor"
		tempZom = new Zombie("MO3", 70, 1, null, "Nurse Zombie", "Syringe Attack", 75, 50);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Nurse"
		tempZom = new Zombie("MO4", 80, 1, null, "Doctor Zombie", "Cold-Stethoscope Attack", 60, 20);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Doctor"
		tempZom = new Zombie("MO5", 90, 1, null, "Plastic Surgeon Zombie", "Skin Graft Buff", 50, 0);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Plastic Surgeon"
		tempZom = new Zombie("MO6", 95, 1, null, "Brain Surgeon Zombie", "Brain-Removal Attack", 10, 100);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Brain Surgeon"
		tempZom = new Zombie("MO7", 100, 1, null, "Surgeon General Zombie", "Insurance Not Accepted Attack", 5, 100);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Surgeon General"
		tempZom = new Zombie("MO8", 40, 1, null, "Secretary Zombie", "Standard attack", 100, 40);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Secretary"
	}
	
	public LinkedHashMap<String, Zombie> getAllZombies()
	{
		createZombies();
		return allZombies;
	}

}