import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
	private static HashMap<String, Artifact> playerInventory;

	/**
	 * @param monsterID
	 * @param health
	 * @param attack
	 * @param defense
	 * @param inventory
	 * @param inCombat
	 * @param previousRoomID
	 */
	public Player(String monsterID, int health, int attack, int defense,
			boolean inCombat, String previousRoomID)
	{
		super(monsterID, health, attack, defense);
		this.inCombat = inCombat;
		this.previousRoomID = previousRoomID;
		
		playerInventory = ArtifactFactory.getallItems();
	}

	@Override
	public void attack(Monster mon)
	{
		//Damage = player attack (minus 1 for every 5 defense the monster has)
		int damage = this.getAttack() - mon.getDefense() / 5; 
		mon.setHealth(mon.getHealth() - damage);
	}
	
	public HashMap<String, Artifact> getArtifacts()
	{
		
		playerInventory = new LinkedHashMap<String, Artifact>();
		Artifact tempArt;
		
		//String name, String description
		//boolean consumable, boolean equippable
		//int atkIncrease, int defIncrease, int healthIncrease
		tempArt = new Artifact("First-Aid Kit", "A kit designed for attending minor wounds."
				+ "\nRestores 20 Health", true, false, 0, 0, 20);
		playerInventory.put(tempArt.getName(), tempArt);
		
		tempArt = new  Artifact("Obamacare Armor", "Issue #23-B."
				+ "\nAttack +3", false, true, 0, 1, 0);
		playerInventory.put(tempArt.getName(), tempArt);
		
		tempArt = new Artifact("Scalpel", "Cutting edge medical technology."
				+ "\nAttack +2", false, true, 2, 0, 0);
		playerInventory.put(tempArt.getName(), tempArt);
		
		tempArt = new Artifact("Whiskey", "You're 106% sure drinking this will make you feel better."
				+ "\nHealth +5", true, false, 0, 0, 5);
		playerInventory.put(tempArt.getName(), tempArt);
		
		return playerInventory;

	}
	/**
	 * @return the playerInventory
	 */
	public static HashMap<String, Artifact> getPlayerInventory()
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
			//invStr += key + "\n";
			invStr += playerInventory.get(key).getName() + "\n";
		}
		
		if (invStr.length() > 0)
		{
			return invStr.substring(0, invStr.length() - 1);
		}
		return null;
	}


}
