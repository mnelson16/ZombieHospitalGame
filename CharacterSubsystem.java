import java.util.LinkedHashMap;

import javax.swing.plaf.synth.SynthSeparatorUI;

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
	public static String itemInput, userInput, command;
	public static int separatorIndex; //index of dash or underscore
	public static Artifact activeItem;

	/**
	 * @param args
	 */
	public void CSRun()
	{
		command = ZHTester.command;
		userInput = ZHTester.userInput;
		Player player = new Player("00", 20, 5, 5, null);
		
		
		if (command.equals("stats"))
		{
			System.out.println(player.viewStats());
		}
		else
		{
			//If there's 1 or more words left
			if (userInput.length() > 1)
			{
				//Set itemInput to item name with underscores replacing spaces
				itemInput = userInput.substring(userInput.indexOf("_") + 1);
	
				//First letter of first word capital, rest of word lower-case
				itemInput = itemInput.substring(0, 1).toUpperCase() 
						+ itemInput.substring(1, itemInput.length()).toLowerCase();
	
				if (itemInput.contains("_"))
				{
					separatorIndex = itemInput.indexOf("_");
					//First letter of second word capital
					itemInput = itemInput.substring(0, separatorIndex) + " " +  
							itemInput.substring(separatorIndex + 1, separatorIndex + 2).toUpperCase() +
							itemInput.substring(separatorIndex + 2);
					itemInput = itemInput.replaceAll("_", " ");
				}
				
				if (itemInput.contains("-"))
				{
					separatorIndex = itemInput.indexOf("-");
					//First letter after dash capital
					itemInput = itemInput.substring(0, separatorIndex) + "-" +  
							itemInput.substring(separatorIndex + 1, separatorIndex + 2).toUpperCase() +
							itemInput.substring(separatorIndex + 2);
				}
				
				activeItem = Player.getPlayerInventory().get(itemInput);
	
				//If the item is in the player inventory
				if (Player.getPlayerInventory().containsKey(itemInput))
				{
					if (ZHTester.command.equals("use"))
					{
						CharacterSubsystem.activeItem.useArtifact(player);
					}
					else if (ZHTester.command.equals("observe"))
					{
						String printDesc = CharacterSubsystem.activeItem.observeArtifact();
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
	
	public String parseItem()
	{
		
		return "";
	}
}
