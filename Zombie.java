import java.util.HashMap;

/**Class: Zombie
 * @authors Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Oct 10, 2016
 * 
 *
 * This class extends the Monster class to include enemy (zombie) activity and traits.
 *
 * Purpose: To specify enemy traits/activity as opposed to player traits/activity.
 */

public class Zombie extends Monster
{
	private HashMap<String, Artifact> inventory;

	/**
	 * @param ID
	 * @param maxHealth
	 * @param atk
	 * @param def
	 */
	public Zombie(String monsterID, int health, int attack, int defense, HashMap<String, Artifact> inventory)
	{
		super(monsterID, health, attack, defense);
		this.inventory = inventory;
	}

	/** (non-Javadoc)
	 * @see Monster#attack()
	 */
	@Override
	protected void attack(Monster player)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * @return the inventory
	 */
	public HashMap<String, Artifact> getInventory()
	{
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(HashMap<String, Artifact> inventory)
	{
		this.inventory = inventory;
	}
}