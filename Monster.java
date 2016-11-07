import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**Class: Monster
 * @author Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Oct 10, 2016
 * 
 *
 * This class - now describe what the class does
 *
 * Purpose: - Describe the purpose of this class
 */

public abstract class Monster
{
	private String monsterID;
	private int health, attack, defense;
	private HashMap<String, Artifact> inventory = new HashMap<String, Artifact>();

	
	/**
	 * @param monsterID
	 * @param health
	 * @param attack
	 * @param defense
	 * @param inventory
	 */
	public Monster(String monsterID, int health, int attack, int defense, HashMap<String, Artifact> inventory)
	{
		this.monsterID = monsterID;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.inventory = inventory;
	}



	protected abstract void attack(Monster mon);



	/**
	 * @return the monsterID
	 */
	public String getMonsterID()
	{
		return monsterID;
	}



	/**
	 * @return the health
	 */
	public int getHealth()
	{
		return health;
	}



	/**
	 * @return the attack
	 */
	public int getAttack()
	{
		return attack;
	}



	/**
	 * @return the defense
	 */
	public int getDefense()
	{
		return defense;
	}



	/**
	 * @return the inventory
	 */
	public HashMap<String, Artifact> getInventory()
	{
		return inventory;
	}



	/**
	 * @param monsterID the monsterID to set
	 */
	public void setMonsterID(String monsterID)
	{
		this.monsterID = monsterID;
	}



	/**
	 * @param health the health to set
	 */
	public void setHealth(int health)
	{
		this.health = health;
	}



	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack)
	{
		this.attack = attack;
	}



	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense)
	{
		this.defense = defense;
	}



	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(HashMap<String, Artifact> inventory)
	{
		this.inventory = inventory;
	}

}
