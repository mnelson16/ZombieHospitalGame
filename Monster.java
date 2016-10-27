import java.util.ArrayList;

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
	private ArrayList<Artifact> inventory = new ArrayList<Artifact>();

	
	/**
	 * @param monsterID
	 * @param health
	 * @param attack
	 * @param defense
	 * @param inventory
	 */
	public Monster(String monsterID, int health, int attack, int defense, ArrayList<Artifact> inventory)
	{
		this.monsterID = monsterID;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.inventory = inventory;
	}



	protected abstract void attack(Monster mon);



	public String getMonsterID()
	{
		return monsterID;
	}



	public int getHealth()
	{
		return health;
	}



	public int getAttack()
	{
		return attack;
	}



	public int getDefense()
	{
		return defense;
	}



	public ArrayList<Artifact> getInventory()
	{
		return inventory;
	}



	public void setMonsterID(String monsterID)
	{
		this.monsterID = monsterID;
	}



	public void setHealth(int health)
	{
		this.health = health;
	}



	public void setAttack(int attack)
	{
		this.attack = attack;
	}



	public void setDefense(int defense)
	{
		this.defense = defense;
	}



	public void setInventory(ArrayList<Artifact> inventory)
	{
		this.inventory = inventory;
	}


}
