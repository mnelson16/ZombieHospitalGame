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
	private static HashMap<String, Artifact> playerInventory; 
	
	public HashMap<String, Artifact> getArtifacts()
	{
		
		playerInventory = new LinkedHashMap<String, Artifact>();
		Artifact tempArt;
		
		tempArt = new Artifact("Cheesecloth", "You would have preferred pants, but what are ya gonna do?"
				+ "\nDEF +2", false, true, false, 0, 2, 0);
		playerInventory.put(tempArt.getName(), tempArt);
		
		tempArt = new  Artifact("Club", "A wooden club. Caveman, ungh!"
				+ "\nATK +3", false, true, false, 3, 0, 0);
		playerInventory.put(tempArt.getName(), tempArt);
		
		tempArt = new Artifact("Saucepan", "Makes the deadliest tomato sauce."
				+ "\nATK +1", false, true, false, 1, 0, 0);
		playerInventory.put(tempArt.getName(), tempArt);
		
		tempArt = new Artifact("Whiskey", "You're 106% sure drinking this will make you feel better."
				+ "\nHP +5", true, false, false, 0, 0, 5);
		playerInventory.put(tempArt.getName(), tempArt);
		
		return playerInventory;

	}
	/**
	 * @return the playerInventory
	 */
	public static HashMap<String, Artifact> getPlayerInventory()
	{
		return playerInventory;
	}
	/**
	 * @return the playerInvList
	 */
	public static String inventoryToString()
	{
		String invStr = "";
		for(String key : playerInventory.keySet())
		{
			//invStr += key + "\n";
			invStr += playerInventory.get(key).getName() + "\n";
		}
		
		return invStr.substring(0, invStr.length() - 1);
	}

}
