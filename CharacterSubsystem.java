import java.util.HashMap;

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
	public static String itemInput, userInput;
	public static int separatorIndex; //index of dash or underscore
	public static Artifact activeItem;
	
	/**
	 * @param args
	 */
	public void CSRun()
	{
		Player player = new Player("00", 20, 5, 5, false, null);
		HashMap<String, Artifact> inventory = player.getArtifacts();
		
		//Set itemInput to item name with underscores replacing spaces
		itemInput = userInput.substring(userInput.indexOf("_") + 1);//userInput;
		activeItem = Player.getPlayerInventory().get(itemInput);
		
		//If there's 1 or more words left
		if (userInput.length() > 1)
		{
			//Set userInput to remaining word(s)
			userInput = userInput.substring(userInput.indexOf("_") + 1);
		
		//First letter of first word capital, rest of word lower-case
		separatorIndex = itemInput.indexOf("_");
		itemInput = itemInput.substring(0, 1).toUpperCase() 
				+ itemInput.substring(1, itemInput.length()).toLowerCase();
		
		if (itemInput.indexOf("_") != -1)
		{
			//First letter of second word capital
			itemInput = itemInput.substring(0, separatorIndex) + " " +  
					itemInput.substring(separatorIndex + 1, separatorIndex + 2).toUpperCase() +
					itemInput.substring(separatorIndex + 2);
			itemInput = itemInput.replaceAll("_", " ");
		}
		
		//First letter after dash capital
		if (itemInput.contains("-"))
		{
			separatorIndex = itemInput.indexOf("-");
			itemInput = itemInput.substring(0, separatorIndex) + " " +  
					itemInput.substring(separatorIndex + 1, separatorIndex + 2).toUpperCase() +
					itemInput.substring(separatorIndex + 2);
		}
			//System.out.println(itemInput);
		
		if (ZHTester.command.equals("use"))
		{
			CharacterSubsystem.activeItem.useArtifact(player);
		}
		else if (ZHTester.command.equals("observe"))
		{
			//If the item is in the player inventory
			if (Player.getPlayerInventory().containsKey(CharacterSubsystem.itemInput)) {
				String printDesc = CharacterSubsystem.activeItem.observeArtifact();
				System.out.println(printDesc);
			}
			
			else
			{
				System.out.println("I don't know where you can get one of those, but you definitely don't have one.");
			}
		}
	}
	}

}
