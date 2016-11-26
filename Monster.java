import java.io.Serializable;
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
 * This class provides structure for all characters in the game, including the player and the zombies.
 *
 * Purpose: provide character blueprint.
 */

public abstract class Monster implements Serializable
{
	private String monsterID;
	private int maxHealth, health, attack, defense;
	private boolean isPlayer;


	/**
	 * @param monsterID
	 * @param maxHealth
	 * @param health
	 * @param attack
	 * @param defense
	 * @param inventory
	 */
	public Monster(String monsterID, int maxHealth, int attack, int defense, boolean isPlayer)
	{
		this.monsterID = monsterID;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.attack = attack;
		this.defense = defense;
	}


	/**
	 * @param mon
	 */
	public abstract void attack(Monster mon);

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
	 * @return the isPlayer
	 */
	public boolean isPlayer()
	{
		return isPlayer;
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
	
	/**
	 * @param isPlayer the isPlayer to set
	 */
	public void setPlayer(boolean isPlayer)
	{
		this.isPlayer = isPlayer;
	}
}
