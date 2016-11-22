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
	
	public static LinkedHashMap<String, Zombie> createZombies()
	{
		//Zombie(String monsterID, int maxHealth, int attack, LinkedHashMap<String, Artifact> inventory,
		//int specialAttackChance, int SpecialAttackHitChance)
		Zombie tempZom;
		
		tempZom = new Zombie("M01", 50, 1, null, 0, 0);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Patient"
		tempZom = new Zombie("M02", 60, 1, null, 75, 50);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Janitor"
		tempZom = new Zombie("M03", 70, 1, null, 75, 50);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Nurse"
		tempZom = new Zombie("M04", 80, 1, null, 60, 20);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Doctor"
		tempZom = new Zombie("M05", 90, 1, null, 50, 0);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Plastic Surgeon"
		tempZom = new Zombie("M06", 95, 1, null, 10, 100);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Brain Surgeon"
		tempZom = new Zombie("M07", 100, 1, null, 5, 100);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Surgeon General"
		tempZom = new Zombie("M08", 40, 1, null, 100, 40);
		allZombies.put(tempZom.getMonsterID(), tempZom); //"Secretary"
		
		return allZombies;
	}

}
