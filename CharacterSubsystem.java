import java.util.LinkedHashMap;

/**Class: CharacterSubsystem
 * @author Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Nov 7, 2016
 * 
 *
 * This class - now describe what the class does
 *
 * Purpose: - Describe the purpose of this class
 */


public class CharacterSubsystem
{
	public static String artifactInput, userInput, command;
	public static int separatorIndex; //index of dash or underscore
	public static Artifact activeArtifact;
	public static Player player;
	//Player player = new Player("00", 20, 5, 5, null);
	/**
	 * @param args
	 */
	public void CSRun(Player p)
	{
		player = p;
		command = ZHTester.command;
		userInput = ZHTester.userInput;
		
		if (command.equals("stats"))
		{
			System.out.println(player.viewStats());
		}
		else
		{
			//If there's 1 or more words left
			if (userInput.length() > 1)
			{
				parseArtifactName();
	
				//If the item is in the player inventory
				if (player.getPlayerInventory().containsKey(artifactInput))
				{
					if (ZHTester.command.equals("use"))
					{
						CharacterSubsystem.activeArtifact.useArtifact(player);
					}
					else if (ZHTester.command.equals("observe"))
					{
						String printDesc = CharacterSubsystem.activeArtifact.observeArtifact();
						System.out.println(printDesc);
					}
				}
	
				else
				{
					System.out.println("I don't know where you can get one of those, but you definitely don't have one.");
				}
			}
		}
	}
	
	/**
	 * Determines item name from remaining words
	 * @return
	 */
	public void parseArtifactName()
	{
		//Set itemInput to item name with underscores replacing spaces
		artifactInput = userInput.substring(userInput.indexOf("_") + 1);

		//First letter of first word capital, rest of word lower-case
		artifactInput = artifactInput.substring(0, 1).toUpperCase() 
				+ artifactInput.substring(1, artifactInput.length()).toLowerCase();

		if (artifactInput.contains("_"))
		{
			separatorIndex = artifactInput.indexOf("_");
			//First letter of second word capital
			artifactInput = artifactInput.substring(0, separatorIndex) + " " +  
					artifactInput.substring(separatorIndex + 1, separatorIndex + 2).toUpperCase() +
					artifactInput.substring(separatorIndex + 2);
			artifactInput = artifactInput.replaceAll("_", " ");
		}
		
		if (artifactInput.contains("-"))
		{
			separatorIndex = artifactInput.indexOf("-");
			//First letter after dash capital
			artifactInput = artifactInput.substring(0, separatorIndex) + "-" +  
					artifactInput.substring(separatorIndex + 1, separatorIndex + 2).toUpperCase() +
					artifactInput.substring(separatorIndex + 2);
		}
		
		activeArtifact = player.getPlayerInventory().get(artifactInput);
	}
}
