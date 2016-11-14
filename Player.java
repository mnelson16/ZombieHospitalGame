import java.util.HashMap;
import java.util.LinkedHashMap;

/**Class: Player
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

public class Player extends Monster
{
	private boolean inCombat;
	private String previousRoomID;
	private static LinkedHashMap<String, Artifact> playerInventory = ArtifactFactory.getAllItems();

	/**
	 * @param monsterID
	 * @param maxHealth
	 * @param attack
	 * @param defense
	 * @param previousRoomID
	 */
	public Player(String monsterID, int maxHealth, int attack, int defense, String previousRoomID)
	{
		super(monsterID, maxHealth, attack, defense);
		this.inCombat = false;
		this.previousRoomID = previousRoomID;
	}

	@Override
	public void attack(Monster mon)
	{
		//Damage = player attack (minus 1 health for every 5 defense the monster has)
		int damage = this.getAttack() - mon.getDefense() / 5; 
		mon.setHealth(mon.getHealth() - damage);
	}
	
	public String viewStats()
	{
		return "Health: " + getHealth() + "/" + getMaxHealth() + "\nAttack: "
				+ getAttack() + "\nDefense: " + getDefense();
	}
	
	/**
	 * @param playerInventory the playerInventory to set
	 */
	public static void setPlayerInventory(LinkedHashMap<String, Artifact> playerInv)
	{
		playerInventory = playerInv;
	}

	/**
	 * @return the playerInventory
	 */
	public static LinkedHashMap<String, Artifact> getPlayerInventory()
	{
		return playerInventory;
	}
	
	/**
	 * @return the playerInvList
	 */
	public static String inventoryToString()
	{
		String invStr = "";
		for(String key : playerInventory.keySet())
		{
			invStr += playerInventory.get(key).getName();
			if (playerInventory.get(key).isCurrentlyEquipped())
			{
				invStr += " (Equipped)";
			}
			invStr += "\n";
		}

		if (invStr.length() > 0)
		{
			return invStr.substring(0, invStr.length() - 1);
		}
		return "You have no items.";
	}
}
