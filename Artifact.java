import java.io.Serializable;
import java.util.LinkedHashMap;

/**Class: Artifact
 * @author Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Oct 10, 2016
 * 
 *
 * This class includes Artifact type, name, description, and stat effects.
 *
 * Purpose: To provide the structure of Artifact 
 */

public class Artifact implements Serializable
{
	private String name, description, currentRoom;
	private boolean consumable, isWeapon, isArmor, currentlyEquipped;
	private int atkIncrease, defIncrease, healthIncrease;
	
	/**
	 * @param artifactID
	 * @param name
	 * @param description
	 * @param consumable
	 * @param equippable
	 * @param currentlyEquipped
	 * @param atkIncrease
	 * @param defIncrease
	 * @param healthIncrease
	 */
	public Artifact(String name, String description, 
			boolean consumable, boolean isWeapon, boolean isArmor, 
			int atkIncrease, int defIncrease, int healthIncrease)
	{
		this.name = name;
		this.description = description;
		this.consumable = consumable;
		this.isWeapon = isWeapon;
		this.isArmor = isArmor;
		this.currentlyEquipped = false;
		this.atkIncrease = atkIncrease;
		this.defIncrease = defIncrease;
		this.healthIncrease = healthIncrease;
	}

	public String observeArtifact()
	{
		return name + "\n" + description;
	}
	
	/**Method: useArtifact
	 * Increases health, defense, and attack according to Artifact stats.
	 * Consumable - disappears from player inventory
	 * isWeapon/isArmor - becomes equipped or unequipped (affects available inventory slots)
	 * None - should not be usable 
	 * If equipment of same type (weapon or armor) is already equipped, unequips it first.
	 * 
	 * @param mon The monster the artifact is being used on
	 */
	public void useArtifact(Player player)
	{
		String effectType;
		int effectAmt;
		
		if (!isWeapon && !isArmor && !consumable)
		{
			System.out.println("The item does nothing.");
		}
		
		if (atkIncrease > 0)
		{
			effectType = "attack";
			effectAmt = atkIncrease;
		}
		else if (defIncrease > 0)
		{
			effectType = "defense";
			effectAmt = defIncrease;
		}
		else //healthIncrease > 0
		{
			effectType = "health";
			effectAmt = healthIncrease;
		}
		
		if (isWeapon || isArmor)
		{
			//if already equipped: unequip, reduce stats, and exit method
			if (currentlyEquipped)
			{
				if (isWeapon)
				{
					player.setWeaponEq(null);
					player.setWeaponHeld(this);
				}
				else if (isArmor)
				{
					player.setArmorEq(null);
					player.setArmorHeld(this);
				}
				
				currentlyEquipped = false;
				player.setHealth(player.getHealth() - healthIncrease);
				player.setDefense(player.getDefense() - defIncrease);
				player.setAttack(player.getAttack() - atkIncrease);
				
				System.out.println("You unequipped " + this.name + ". Your " + effectType 
						+ " decreased by " + effectAmt + ".");
				return;
			}
			else //not currently equipped
			{
				if (isWeapon)
				{
					//If player has a weapon equipped
					if (player.getWeaponEq() != null)
					{
						player.getWeaponEq().setCurrentlyEquipped(false);
						System.out.println("You unequipped " + player.getWeaponEq().getName() + ". Your attack" 
						 + " decreased by " + player.getWeaponEq().getAtkIncrease() + ".");
						
						//Reduce player attack from the previously equipped weapon
						player.setAttack(player.getAttack() - player.getWeaponEq().getAtkIncrease());
					}
					
					player.setWeaponEq(this);
					player.setWeaponHeld(null);
				}
				else if (isArmor)
				{
					
					//If player has armor equipped
					if (player.getArmorEq() != null)
					{
						player.getArmorEq().setCurrentlyEquipped(false);
						System.out.println("You unequipped " + player.getArmorEq().getName() + ". Your defense" 
								 + " decreased by " + player.getArmorEq().getDefIncrease() + ".");
						
						//Reduce player defense from the previously equipped armor
						player.setDefense(player.getDefense() - player.getArmorEq().getDefIncrease());
					}
					
					player.setArmorEq(this);
					player.setArmorHeld(null);
				}
				
				currentlyEquipped = true;
				System.out.println("You equipped " + this.name + ". Your " + effectType 
						+ " increased by " + effectAmt + ".");
			}	
		}
		
		if (consumable)
		{
			//Remove artifact from inventory
			LinkedHashMap<String, Artifact> updatedInventory = player.getPlayerInventory();
			updatedInventory.remove(this.name);
			player.setPlayerInventory(updatedInventory);
			
			System.out.println("You used " + this.name + ". Your " + effectType 
					+ " increased by " + effectAmt + ".");
		}
		
		//if artifact's healthIncrease won't cause health to exceed max
		if (player.getMaxHealth() > player.getHealth() + healthIncrease)
		{
			player.setHealth(player.getHealth() + healthIncrease);
		}
		else //else, set health to max
		{
			player.setHealth(player.getMaxHealth());
		}
		player.setDefense(player.getDefense() + defIncrease);
		player.setAttack(player.getAttack() + atkIncrease);
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @return the consumable
	 */
	public boolean isConsumable()
	{
		return consumable;
	}

	/**
	 * @return if item is a weapon
	 */
	public boolean isWeapon()
	{
		return isWeapon;
	}
	
	/**
	 * @return if item is armor
	 */
	public boolean isArmor()
	{
		return isArmor;
	}

	/**
	 * @return the currentlyEquipped
	 */
	public boolean isCurrentlyEquipped()
	{
		return currentlyEquipped;
	}

	/**
	 * @return the atkIncrease
	 */
	public int getAtkIncrease()
	{
		return atkIncrease;
	}

	/**
	 * @return the defIncrease
	 */
	public int getDefIncrease()
	{
		return defIncrease;
	}

	/**
	 * @return the healthIncrease
	 */
	public int getHealthIncrease()
	{
		return healthIncrease;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @param consumable the consumable to set
	 */
	public void setConsumable(boolean consumable)
	{
		this.consumable = consumable;
	}

	/**
	 * @param isWeapon the isWeapon to set
	 */
	public void setIsWeapon(boolean isWeapon)
	{
		this.isWeapon = isWeapon;
	}

	/**
	 * @param isArmor the isArmor to set
	 */
	public void setIsArmor(boolean isArmor)
	{
		this.isArmor = isArmor;
	}
	
	/**
	 * @param currentlyEquipped the currentlyEquipped to set
	 */
	public void setCurrentlyEquipped(boolean currentlyEquipped)
	{
		this.currentlyEquipped = currentlyEquipped;
	}

	/**
	 * @param atkIncrease the atkIncrease to set
	 */
	public void setAtkIncrease(int atkIncrease)
	{
		this.atkIncrease = atkIncrease;
	}

	/**
	 * @param defIncrease the defIncrease to set
	 */
	public void setDefIncrease(int defIncrease)
	{
		this.defIncrease = defIncrease;
	}

	/**
	 * @param healthIncrease the healthIncrease to set
	 */
	public void setHealthIncrease(int healthIncrease)
	{
		this.healthIncrease = healthIncrease;
	}
}