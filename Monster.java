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
	private int maxHealth, health, attack, defense;


	/**
	 * @param monsterID
	 * @param maxHealth
	 * @param health
	 * @param attack
	 * @param defense
	 * @param inventory
	 */
	public Monster(String monsterID, int maxHealth, int attack, int defense)
	{
		this.monsterID = monsterID;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.attack = attack;
		this.defense = defense;
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
	public int getMaxHealth()
	{
		return maxHealth;
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
	 * @param monsterID the monsterID to set
	 */
	public void setMonsterID(String monsterID)
	{
		this.monsterID = monsterID;
	}



	/**
	 * @param health the health to set
	 */
	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
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
}
