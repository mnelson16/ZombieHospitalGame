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
	private String name, specialName;
	private int specialAttackChance, specialAttackHitChance, turnsSinceSpecial;

	/**
	 * @param ID
	 * @param maxHealth
	 * @param atk
	 * @param def
	 */	
	public Zombie(String monsterID, int maxHealth, int attack, LinkedHashMap<String, Artifact> inventory,
			String name, String specialName, int specialAttackChance, int SpecialAttackHitChance)
	{
		super(monsterID, maxHealth, attack, 0, false);
		
		this.inventory = inventory;
		this.name = name;
		this.specialName = specialName;
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

		//Standard attack hit attempt
		if (rnd.nextInt(100) < 50)
		{
			damage = 1 - defCalc;
		}

		if (rnd.nextInt(100) < specialAttackChance) //Chance to attempt special attack
		{
			executed = true;

			if (rnd.nextInt(100) < specialAttackHitChance) //Chance for special attack to succeed
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
				damage = 0;
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
					setSpecialName("Insurance Not Accepted Attack");
					//If player has equipped obamacare armor
					if (((Player) player).getPlayerInventory().get("Obamacare Armor").isCurrentlyEquipped())
					{
						damage = 0;
					}
				}
			}
			else
			{
				if (!executed)
				{
					setSpecialName("Second-Hand Smoke Attack");
					executed = true;
					damage = 5 - defCalc;
				}
			}
			break;
			
		case "M08":
			damage = 0; //Does not perform regular standard attack
			if (hit)
			{
				damage = 5 - defCalc;
			}
			break;
		}
		
		if (!executed)
		{
			System.out.println(getName() + " attacks...");
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			if (damage == 0)
			{
				System.out.println("...and misses!");
			}
			
		}
		else
		{
			System.out.println(getName() + " performs " + getSpecialName() + ".");
			if (hit)
			{
				if (damage > 0)
				{
					 // + special description
				}
			}
			else
			{
				System.out.println(getName() + " misses!");
				damage = 0;
			}
		}
		
		if (damage > 0)
		{
			System.out.println("...and hits for " + damage + " damage!");
			player.setHealth(player.getHealth() - damage);
		}
		
	}

	/**
	 * @return the inventory
	 */
	public LinkedHashMap<String, Artifact> getInventory()
	{
		return inventory;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the specialName
	 */
	public String getSpecialName()
	{
		return specialName;
	}

	/**
	 * @return the specialAttackChance
	 */
	public int getSpecialAttackChance()
	{
		return specialAttackChance;
	}

	/**
	 * @return the specialAttackHitChance
	 */
	public int getSpecialAttackHitChance()
	{
		return specialAttackHitChance;
	}

	/**
	 * @return the turnsSinceSpecial
	 */
	public int getTurnsSinceSpecial()
	{
		return turnsSinceSpecial;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(LinkedHashMap<String, Artifact> inventory)
	{
		this.inventory = inventory;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @param specialName the specialName to set
	 */
	public void setSpecialName(String specialName)
	{
		this.specialName = specialName;
	}

	/**
	 * @param specialAttackChance the specialAttackChance to set
	 */
	public void setSpecialAttackChance(int specialAttackChance)
	{
		this.specialAttackChance = specialAttackChance;
	}

	/**
	 * @param specialAttackHitChance the specialAttackHitChance to set
	 */
	public void setSpecialAttackHitChance(int specialAttackHitChance)
	{
		this.specialAttackHitChance = specialAttackHitChance;
	}

	/**
	 * @param turnsSinceSpecial the turnsSinceSpecial to set
	 */
	public void setTurnsSinceSpecial(int turnsSinceSpecial)
	{
		this.turnsSinceSpecial = turnsSinceSpecial;
	}
}
