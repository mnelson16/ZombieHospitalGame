import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

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

public class Zombie extends Monster implements Serializable
{
	private LinkedHashMap<String, Artifact> inventory;
	private int specialAttackChance, specialAttackHitChance, turnsSinceSpecial;

	/**
	 * @param ID
	 * @param maxHealth
	 * @param atk
	 * @param def
	 */	
	public Zombie(String monsterID, int maxHealth, int attack, LinkedHashMap<String, Artifact> inventory,
			int specialAttackChance, int SpecialAttackHitChance)
	{
		super(monsterID, maxHealth, attack, 0, false);
		this.inventory = inventory;
		this.specialAttackChance = specialAttackChance;
		this.specialAttackHitChance = specialAttackHitChance;
		this.turnsSinceSpecial = 0;
	}

	/** (non-Javadoc)
	 * @see Monster#attack()
	 */
	@Override
	public void attack(Monster player)
	{
		Random rnd = new Random();
		int defCalc = ((Player) player).getDefCalculation();
		int damage = 0;
		boolean executed = false, hit = false;

		//Standard attack
		if (rnd.nextInt(100) < 50)
		{
			damage = 1 - defCalc;
		}

		if (rnd.nextInt(100) < specialAttackChance)
		{
			executed = true;

			if (rnd.nextInt(100) < specialAttackHitChance)
			{
				hit = true;
			}
		}

		switch(getMonsterID())
		{
		//M01 is taken care of in standard attack
		
		case "M02":
			if (hit)
			{
				damage = 2 - defCalc;
			}
			break;

		case "M03":
			if (hit)
			{
				damage = 2 - defCalc;
			}
			if (getHealth() < 20)
			{
				damage *= 2;
			}
			break;

		case "M04":
			if (hit)
			{
				//player can attack once every 2 turns
				//setSpecialAttackChance(0);
			}
			break;

		case "M05":
			if (executed)
			{
				//Cuts player damage on zombie in half (rounded down)
				this.setDefense(player.getAttack() * 5 / 2);
			}
			//if buffed, 0% chance for special; special lasts for next 2 turns
			break;

		case "M06":
			if (hit)
			{
				//player incapacitated for 3 turns
				//0% chance for special if player incapacitated
			}
			break;

		case "M07":
			if (hit)
			{
				//Player will die
				damage = player.getHealth();

				//If player is holding obamacare armor
				if (((Player) player).getPlayerInventory().containsKey("Obamacare Armor"))
				{
					//If player has equipped obamacare armor
					if (((Player) player).getPlayerInventory().get("Obamacare Armor").isCurrentlyEquipped())
					{
						damage = 0;
					}
				}
			}
			else
			{
				damage = 5 - defCalc;
			}
			break;
			
		case "M08":
			if (hit)
			{
				damage = 5 - defCalc;
			}
			break;
		}
		
		player.setHealth(player.getHealth() - damage);
	}

	/**
	 * @return the inventory
	 */
	public LinkedHashMap<String, Artifact> getInventory()
	{
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(LinkedHashMap<String, Artifact> inventory)
	{
		this.inventory = inventory;
	}
}
