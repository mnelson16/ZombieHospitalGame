import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**Class: ArtifactFactory.java
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
	 private static LinkedHashMap<String, Artifact> allItems = new LinkedHashMap<String, Artifact>();
	
	public static LinkedHashMap<String, Artifact> createItems()
	{
		Artifact tempArt;
		
		//String name, String description
		//boolean consumable, boolean equippable
		//int atkIncrease, int defIncrease, int healthIncrease
		tempArt = new Artifact("First-Aid Kit", "A kit designed for attending minor wounds."
				+ "\nRestores 20 Health", true, false, false, 0, 0, 20);
		allItems.put(tempArt.getName(), tempArt);
		
		tempArt = new  Artifact("Obamacare Armor", "A tattered HazMat suit."
				+ "\nAttack +3", false, false, true, 0, 1, 0);
		allItems.put(tempArt.getName(), tempArt);
		
		tempArt = new Artifact("Scalpel", "Cutting edge medical technology."
				+ "\nAttack +2", false, true, false, 2, 0, 0);
		allItems.put(tempArt.getName(), tempArt);
		
		tempArt = new Artifact("Whiskey", "You're 106% sure drinking this will make you feel better."
				+ "\nHealth +5", true, false, false, 0, 0, 5);
		allItems.put(tempArt.getName(), tempArt);
		
		return allItems;
	}
	
	/**
	 * @return allItems
	 */
	public static LinkedHashMap<String, Artifact> getAllItems()
	{
		allItems = createItems();
		return allItems;
	}
}
