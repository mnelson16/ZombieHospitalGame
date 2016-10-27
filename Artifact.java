import java.util.ArrayList;

/**Class: Artifact
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

public class Artifact
{
	private String artifactID, name, description;
	private boolean consumable, equippable, currentlyEquipped;
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
	public Artifact(String artifactID, String name, String description, boolean consumable, boolean equippable,
			boolean currentlyEquipped, int atkIncrease, int defIncrease, int healthIncrease)
	{
		this.artifactID = artifactID;
		this.name = name;
		this.description = description;
		this.consumable = consumable;
		this.equippable = equippable;
		this.currentlyEquipped = currentlyEquipped;
		this.atkIncrease = atkIncrease;
		this.defIncrease = defIncrease;
		this.healthIncrease = healthIncrease;
	}

	public void observeArtifact()
	{
		System.out.println(name + ": " + description);
	}
	
	/**Method: useArtifact
	 * Increases health, defense, and attack according to Artifact stats.
	 * Consumable - disappears from player inventory
	 * Equippable - becomes equipped or unequipped (affects inventory slots)
	 * Neither - should not be usable 
	 * 
	 * @param mon The monster being attacked
	 */
	public void useArtifact(Monster mon)
	{
		if (equippable)
		{
			if (currentlyEquipped)
			{
				currentlyEquipped = false;
				mon.setHealth(mon.getHealth() - healthIncrease);
				mon.setDefense(mon.getDefense() - defIncrease);
				mon.setAttack(mon.getAttack() - atkIncrease);
				return;
			}
			else
			{
				currentlyEquipped = true;
			}
		}
		
		if (consumable)
		{
			//index of this Artifact in inventory ArrayList
			int artIndex = mon.getInventory().indexOf(this);
			
			//new inventory without this Artifact
			ArrayList<Artifact> updatedInventory = mon.getInventory(); 
			updatedInventory.remove(artIndex); 
			
			mon.setInventory(updatedInventory);
		}
		
		mon.setHealth(mon.getHealth() + healthIncrease);
		mon.setDefense(mon.getDefense() + defIncrease);
		mon.setAttack(mon.getAttack() + atkIncrease);
	}

	/**
	 * @return the artifactID
	 */
	public String getArtifactID()
	{
		return artifactID;
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
	 * @return the equippable
	 */
	public boolean isEquippable()
	{
		return equippable;
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
	 * @param artifactID the artifactID to set
	 */
	public void setArtifactID(String artifactID)
	{
		this.artifactID = artifactID;
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
	 * @param equippable the equippable to set
	 */
	public void setEquippable(boolean equippable)
	{
		this.equippable = equippable;
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
