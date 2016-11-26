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
	private String name, specialName, specialDescription;
	private int specialAttackChance, tempSAC, specialAttackHitChance, turnsSinceSpecial;
	private boolean dead, specialActivated, playerAttackPrevented;

	/**
	 * Constructor
	 */	
	public Zombie(String monsterID, int maxHealth, int attack, LinkedHashMap<String, Artifact> inventory,
			String name, String specialName, String specialDescription, int specialAttackChance, 
			int specialAttackHitChance)
	{
		super(monsterID, maxHealth, attack, 0, false);
		
		this.inventory = inventory;
		this.name = name;
		this.specialName = specialName;
		this.specialDescription = specialDescription;
		this.specialAttackChance = specialAttackChance;
		tempSAC = specialAttackChance;
		this.specialAttackHitChance = specialAttackHitChance;
		this.turnsSinceSpecial = 0;
		dead = false;
		specialActivated = false;
		playerAttackPrevented = false;
	}

	/**
	 * @return the specialDescription
	 */
	public String getSpecialDescription()
	{
		return specialDescription;
	}

	/**
	 * @param specialDescription the specialDescription to set
	 */
	public void setSpecialDescription(String specialDescription)
	{
		this.specialDescription = specialDescription;
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

		if (playerAttackPrevented)
		{
			specialAttackChance = 0;
		}
		else
		{
			specialAttackChance = tempSAC;
		}
		
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
				specialActivated = true;
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
				damage = 4 - defCalc;
			}
			if (getHealth() < getHealth() * .2) //If monster health is below 20%
			{
				damage *= 2;
			}
			break;

		case "M04":
			//player can attack once every 2 turns 
			if (specialActivated && (turnsSinceSpecial + 2) % 2 == 0)
			{
				playerAttackPrevented = true;
			}
			else
			{
				playerAttackPrevented = false;
			}
			
			if (hit)
			{
				//Special attack can't be used again
				setSpecialAttackChance(0);
			}
			break;

		case "M05":
			if (executed)
			{
				damage = 0;
				turnsSinceSpecial = 0;
				//Cuts player damage on zombie in half (rounded down)
				this.setDefense(player.getAttack() * 5 / 2);
			}
			//if buffed, 0% chance for special; special lasts for next 2 turns
			break;

		case "M06":
			if (hit)
			{
				turnsSinceSpecial = 0;
				//player incapacitated for 3 turns
				playerAttackPrevented = true;
				//0% chance for special if player incapacitated
			}
			break;

		case "M07":
			if (hit)
			{
				//Player will die
				damage = player.getHealth();
				setSpecialName("Insurance Not Accepted Attack");
				
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
				if (!executed)
				{
					//If Insurance Not Accepted does not execute, 
					//Change "special attack" name and force new one to execute
					setSpecialName("Second-Hand Smoke Attack");
					executed = true;
					hit = true;
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
		
		if (!executed) //If special wasn't executed, perform regular attack
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
		else //If special was executed
		{
			System.out.println(getName() + " performs " + getSpecialName() + "...");
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			if (hit)
			{
				System.out.println("...and hits! " + specialDescription);
			}
			else
			{
				System.out.println("...and misses!");
				damage = 0;
			}
		}
		
		if (damage > 0) //If zombie doesn't miss
		{
			System.out.println("...and hits for " + damage + " damage!");
			player.setHealth(player.getHealth() - damage);
		}
		
		if (specialActivated)
		{
			turnsSinceSpecial += 1;
		}
		
		if (playerAttackPrevented)
		{
			this.attack(player);
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
	 * @return the tempSAC
	 */
	public int getTempSAC()
	{
		return tempSAC;
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
	 * @return the dead
	 */
	public boolean isDead()
	{
		return dead;
	}

	/**
	 * @return the specialActivated
	 */
	public boolean isSpecialActivated()
	{
		return specialActivated;
	}

	/**
	 * @return the playerAttackPrevented
	 */
	public boolean isPlayerAttackPrevented()
	{
		return playerAttackPrevented;
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
	 * @param tempSAC the tempSAC to set
	 */
	public void setTempSAC(int tempSAC)
	{
		this.tempSAC = tempSAC;
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

	/**
	 * @param dead the dead to set
	 */
	public void setDead(boolean dead)
	{
		this.dead = dead;
	}

	/**
	 * @param specialActivated the specialActivated to set
	 */
	public void setSpecialActivated(boolean specialActivated)
	{
		this.specialActivated = specialActivated;
	}

	/**
	 * @param playerAttackPrevented the playerAttackPrevented to set
	 */
	public void setPlayerAttackPrevented(boolean playerAttackPrevented)
	{
		this.playerAttackPrevented = playerAttackPrevented;
	}

	
}