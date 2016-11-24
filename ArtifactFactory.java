import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**Class: ArtifactFactory
 * @author Janna Timmer
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Oct 27, 2016
 * 
 *
 * This class - now describe what the class does
 *
 * Purpose: - Describe the purpose of this class
 */

public class ArtifactFactory
{
	private static LinkedHashMap<String, Artifact> allArtifacts = new LinkedHashMap<String, Artifact>();
	
	public static LinkedHashMap<String, Artifact> createArtifacts()
	{
		Artifact tempArt;
		
		//String name, String description
		//boolean consumable, boolean isWeapon, boolean isArmor
		//int atkIncrease, int defIncrease, int healthIncrease
		
		tempArt = new Artifact("Bone Saw", "When you looked at the saw used for sawing bones, you saw"
				+ "\nthe saw was why you saw the bones. You saw the bones had"
				+ "\nbeen bone-sawn by the bone saw you saw."
				+ "\nAttack +10", false, true, false, 10, 0, 0);
		allArtifacts.put(tempArt.getName(), tempArt);
		
		tempArt = new Artifact("First-Aid Kit", "A kit designed for attending minor wounds."
				+ "\nRestores 20 Health", true, false, false, 0, 0, 20);
		allArtifacts.put(tempArt.getName(), tempArt);
		
		tempArt = new Artifact("Mixtape", "Guards against teenaged angst."
				+ "\nDefense +5", false, false, true, 0, 5, 0);
		allArtifacts.put(tempArt.getName(), tempArt);
		
		tempArt = new  Artifact("Obamacare Armor", "A tattered HazMat suit."
				+ "\nDefense +1", false, false, true, 0, 1, 0);
		allArtifacts.put(tempArt.getName(), tempArt);
		
		tempArt = new Artifact("Scalpel", "Cutting edge medical technology."
				+ "\nAttack +8", false, true, false, 8, 0, 0);
		allArtifacts.put(tempArt.getName(), tempArt);
		
		tempArt = new Artifact("Stethoscope", "One should always listen to the heart."
				+ "\nDefense +10", false, false, true, 0, 10, 0);
		allArtifacts.put(tempArt.getName(), tempArt);
		
		tempArt = new Artifact("Syringe", "Pointless. Wait, actually..."
				+ "\nAttack +5", false, true, false, 5, 0, 0);
		allArtifacts.put(tempArt.getName(), tempArt);
		
		tempArt = new Artifact("Whiskey", "You're pretty sure drinking this will make you feel better."
				+ "\nHealth +5", true, false, false, 0, 0, 5);
		allArtifacts.put(tempArt.getName(), tempArt);
		
		return allArtifacts;
	}
	
	/**
	 * @return allArtifacts
	 */
	public static LinkedHashMap<String, Artifact> getAllArtifacts()
	{
		allArtifacts = createArtifacts();
		return allArtifacts;
	}
}
