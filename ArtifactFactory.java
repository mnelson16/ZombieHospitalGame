import java.util.LinkedHashMap;

/**Class: ArtifactFactory
 * @author Janna Timmer
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Oct 27, 2016
 *
 *
 * This class creates and collects Artifact objects.
 *
 * Purpose: To organize Artifact creation into a separate class.
 */

public class ArtifactFactory
{
	private static LinkedHashMap<String, Artifact> allArtifacts = new LinkedHashMap<String, Artifact>();

	public static LinkedHashMap<String, Artifact> createArtifacts()
	{
		Artifact tempArt;

		/*String name, String description
		 *boolean consumable, boolean isWeapon, boolean isArmor
		 *int atkIncrease, int defIncrease, int healthIncrease
		 */

		tempArt = new Artifact("Mixtape", "Doesn't do much, but it'll keep you from getting bored."
				+ "\nDefense +5", false, false, true, 0, 5, 0);
		allArtifacts.put(tempArt.getName(), tempArt); //Secretary M08

		tempArt = new Artifact("Mop Handle", "Part of a mop. Now you can kill zombies and clean up the mess afterwards!"
				+ "\nAttack +8", false, true, false, 8, 0, 0);
		allArtifacts.put(tempArt.getName(), tempArt); //Janitor M02

		tempArt = new Artifact("Syringe", "A used syringe. Maybe it'll give your enemies hepatitis?"
				+ "\nAttack +10", false, true, false, 10, 0, 0);
		allArtifacts.put(tempArt.getName(), tempArt); //Nurse M03

		tempArt = new Artifact("Stethoscope", "One should always listen to the heart."
				+ "\nDefense +10", false, false, true, 0, 10, 0);
		allArtifacts.put(tempArt.getName(), tempArt); //Doctor M04

		tempArt = new Artifact("Scalpel", "Cutting edge medical technology."
				+ "\nAttack +13", false, true, false, 13, 0, 0);
		allArtifacts.put(tempArt.getName(), tempArt); //Plastic Surgeon M05

		tempArt = new Artifact("Bone Saw", "When you looked at the saw used for sawing bones, you saw"
				+ "\nthe saw was why you saw the bones. You saw the bones had"
				+ "\nbeen bone-sawn by the bone saw you saw."
				+ "\nAttack +15", false, true, false, 15, 0, 0);
		allArtifacts.put(tempArt.getName(), tempArt); //Brain Surgeon M06

		tempArt = new Artifact("Hand Gun", "A dying man gave you this gun, and you should honor his memory"
				+ "\nby kicking zombie ass with it."
				+ "\nAttack +20",
				false, true, false, 20, 0, 0);
		allArtifacts.put(tempArt.getName(), tempArt);

		tempArt = new Artifact("Whiskey", "Drinking this will probably make you feel better."
				+ "\nHealth +5", true, false, false, 0, 0, 5);
		allArtifacts.put(tempArt.getName(), tempArt);

		tempArt = new Artifact("First-Aid Kit", "A kit designed for attending minor wounds."
				+ "\nRestores 10 Health", true, false, false, 0, 0, 10);
		allArtifacts.put(tempArt.getName(), tempArt);

		tempArt = new Artifact("Crowbar", "A stiff metal bar, strong enough to pry off some wood."
				+ "\nAttack +5", false, true, false, 5, 0, 0);
		allArtifacts.put(tempArt.getName(), tempArt);

		tempArt = new Artifact("Flashlight", "A small handheld flashlight. You feel as though it will keep you safe.", false, false, false, 0, 0, 0);
		allArtifacts.put(tempArt.getName(), tempArt);

		tempArt = new  Artifact("Obamacare Armor", "A tattered HazMat suit."
				+ "\nDefense +1", false, false, true, 0, 1, 0);
		allArtifacts.put(tempArt.getName(), tempArt);

		tempArt = new Artifact("Old Nail", "An old, rusty nail. Hopefully you didnt step on it!",
				false, false, false, 0, 0, 0);
		allArtifacts.put(tempArt.getName(), tempArt);

		tempArt = new Artifact("Fire Axe", "An axe to be used for emergencies only. "
				+ "\nAttack +3", false, true, false, 3, 0, 0);
		allArtifacts.put(tempArt.getName(), tempArt);

		tempArt = new Artifact("Note", "The note reads: \"The password is that which is so fragile, to "
				+ "simply speak its name would be to break it\"",
				false, false, false, 0, 0, 0);
		allArtifacts.put(tempArt.getName(), tempArt);

		return allArtifacts;
	}

	/**
	 * @return allArtifacts
	 */
	public LinkedHashMap<String, Artifact> getAllArtifacts()
	{
		return allArtifacts;
	}
}
