import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

/**Class: Player
 * @author Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Oct 10, 2016
 *
 *
 * This class extends the Monster class to include player activity and traits.
 *
 * Purpose: to store information about player stats, equipment, etc.
 */

public class Player extends Monster implements Serializable
{
	private boolean inCombat;
	private String currentRoomID, previousRoomID;
	private LinkedHashMap<String, Artifact> playerInventory = new LinkedHashMap<String, Artifact>();
	private int defCalculation;
	private Artifact weaponEq, armorEq, weaponHeld, armorHeld;
	private HashMap<String, Room> rooms;

	/**
	 * @param monsterID
	 * @param maxHealth
	 * @param attack
	 * @param defense
	 * @param currentRoomID
	 */
	public Player(String monsterID, int maxHealth, int attack, int defense, String currentRoomID, HashMap<String, Room> rooms)
	{
		super(monsterID, maxHealth, attack, defense, true);
		this.inCombat = false;
		this.currentRoomID = currentRoomID;
		defCalculation = this.getDefense() / 5;
		this.rooms = rooms;
	}

	@Override
	public void attack(Monster mon)
	{
		Random rnd = new Random();
		int damage = 0;

		if (((Zombie) mon).isPlayerAttackPrevented()) //If player is incapacitated
		{
			System.out.println("You are incapacitated!\n");
		}
		else
		{
			if (rnd.nextInt(100) < 80)
			{
				//Damage = player attack (minus 1 for every 5 defense the monster has)
				damage = this.getAttack() - mon.getDefense() / 5;
				mon.setHealth(mon.getHealth() - damage);
			}

			if (damage > 0)
			{
				System.out.println("You attack for " + damage + " damage.");
			}
			else
			{
				System.out.println("You attack and miss!");
			}
		}
	}

	public String viewStats()
	{
		return "Health: " + getHealth() + "/" + getMaxHealth() + "\nAttack: "
				+ getAttack() + "\nDefense: " + getDefense();
	}

	/**
	 * @return the inCombat
	 */
	public boolean isInCombat()
	{
		return inCombat;
	}

	/**
	* @return the currentRoomID
	*/
	public String getCurrentRoomID()
	{
		return currentRoomID;
	}

	/**
	 * @return the previousRoomID
	 */
	public String getPreviousRoomID()
	{
		return previousRoomID;
	}

	/**
	 * @return the playerInventory
	 */
	public LinkedHashMap<String, Artifact> getPlayerInventory()
	{
		return playerInventory;
	}

	/**
	 * @return the defCalculation
	 */
	public int getDefCalculation()
	{
		return defCalculation;
	}

	/**
	 * @return the weaponEq
	 */
	public Artifact getWeaponEq()
	{
		return weaponEq;
	}

	/**
	 * @return the armorEq
	 */
	public Artifact getArmorEq()
	{
		return armorEq;
	}

	/**
	 * @param inCombat the inCombat to set
	 */
	public void setInCombat(boolean inCombat)
	{
		this.inCombat = inCombat;
	}

	/**
	 * @param currentRoomID the currentRoomID to set
	 */
	public void setCurrentRoomID(String currentRoomID)
	{
		this.currentRoomID = currentRoomID;
	}

	/**
	 * @param previousRoomID the previousRoomID to set
	 */
	public void setPreviousRoomID(String previousRoomID)
	{
		this.previousRoomID = previousRoomID;
	}

	/**
	 * @param playerInventory the playerInventory to set
	 */
	public void setPlayerInventory(LinkedHashMap<String, Artifact> playerInventory)
	{
		for (String key : playerInventory.keySet())
		{
			if (!this.playerInventory.containsKey(key))
			{
				if (playerInventory.get(key).isWeapon())
				{
					if (weaponHeld != null)
					{
						System.out.println("You dropped " + playerInventory.get(key) + ".");
						rooms.get(currentRoomID).setArtifact(playerInventory.get(key));
						this.playerInventory.remove(weaponHeld);
					}
				}
				else if (playerInventory.get(key).isArmor())
				{
					if (armorHeld != null)
					{
						System.out.println("You dropped " + playerInventory.get(key) + ".");
						rooms.get(currentRoomID).setArtifact(playerInventory.get(key));
						this.playerInventory.remove(armorHeld);
					}
				}
				else if (playerInventory.get(key).isConsumable())
				{
					//consumable already held
				}
			}
			else
			{
				rooms.get(currentRoomID).setArtifact(null);
			}
		}
		this.playerInventory = playerInventory;
	}

	/**
	 * @param defCalculation the defCalculation to set
	 */
	public void setDefCalculation(int defCalculation)
	{
		this.defCalculation = defCalculation;
	}

	/**
	 * @param weaponEq the weaponEq to set
	 */
	public void setWeaponEq(Artifact weaponEq)
	{
		this.weaponEq = weaponEq;
	}

	/**
	 * @param armorEq the armorEq to set
	 */
	public void setArmorEq(Artifact armorEq)
	{
		this.armorEq = armorEq;
	}

	/**
	 * @return the weaponHeld
	 */
	public Artifact getWeaponHeld()
	{
		return weaponHeld;
	}

	/**
	 * @return the armorHeld
	 */
	public Artifact getArmorHeld()
	{
		return armorHeld;
	}

	/**
	 * @param weaponHeld the weaponHeld to set
	 */
	public void setWeaponHeld(Artifact weaponHeld)
	{
		this.weaponHeld = weaponHeld;
	}

	/**
	 * @param armorHeld the armorHeld to set
	 */
	public void setArmorHeld(Artifact armorHeld)
	{
		this.armorHeld = armorHeld;
	}

	/**
	 * @return the playerInvList
	 */
	public String inventoryToString()
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
