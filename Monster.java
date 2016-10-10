import java.util.ArrayList;

/**Class: Monster.java
 * @author Janna Timmer
 * @version 1.0
 * Course:
 * Written: Oct 10, 2016
 * 
 *
 * This class - now describe what the class does
 *
 * Purpose: - Describe the purpose of this class
 */

public class Monster
{
	private String monsterID;
	private int health, attack, defense;
	private ArrayList<Artifact> inventory = new ArrayList<Artifact>();
	
	public Monster(String ID, int maxHealth, int atk, int def)
	{
		monsterID = ID;
		health = maxHealth;
		attack = atk;
		defense = def;
	}
	
	
}
