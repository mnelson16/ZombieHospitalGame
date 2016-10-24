/**Class: Artifact
 * @author Janna Timmer
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

	public Artifact(String artifactID, String name, String description, boolean consumable, 
			boolean equippable, boolean currentlyEquipped, int atkIncrease, int defIncrease,
			int healthIncrease)
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
		
	}
}
