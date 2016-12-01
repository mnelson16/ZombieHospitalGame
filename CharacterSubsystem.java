import java.util.HashMap;
import java.util.LinkedHashMap;

/**Class: CharacterSubsystem
 * @author Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Nov 7, 2016
 * 
 *
 * This class provides structure for the Character subsystem (Character and Artifact classes)
 *
 * Purpose: to organize the Character subsystem
 */


public class CharacterSubsystem
{
	public static Player player;
	public Room activeRoom;
	//Player player = new Player("00", 20, 5, 5, null);

	/**Method: CSRun
	 * Handles major functionality for the Character subsystem -- Artifact and Monster
	 * @param p main Player
	 * @param command -- first word user typed in (game action to be taken)
	 * @param activeArtifact -- artifact user typed in (null if user typed in one word command)
	 */
	public void CSRun(Player p, HashMap<String, Room> rooms, String command, String artifactInput)
	{
		Artifact activeArtifact;

		player = p;
		activeRoom = rooms.get(player.getCurrentRoomID());

		if (command.equals("stats"))
		{
			System.out.println(player.viewStats());
		}
		else if (command.equals("inventory"))
		{
			System.out.println(player.inventoryToString());
		}
		else if(command.equals("take"))
		{
			activeArtifact = parseArtifactName(artifactInput);
			//If the item is in the room
			if(activeRoom.getArtifact() != null)
			{
				LinkedHashMap<String, Artifact> newInv = player.getPlayerInventory();
				newInv.put(activeArtifact.getName(), activeArtifact);
				player.setPlayerInventory(newInv);
				System.out.println("You got the " + activeArtifact.getName() + "! \n" + 
						activeArtifact.getName() + " has been added to your inventory.");
			}
			else
			{
				System.out.println("There's nothing here to pick up...");
			}
		}
		else if (command.equals("use") || command.equals("observe"))
		{
			activeArtifact = parseArtifactName(artifactInput);

			//If the item is in the player inventory
			if (player.getPlayerInventory().containsValue(activeArtifact))
			{
				if (command.equals("use"))
				{
					activeArtifact.useArtifact(player);
				}
				else if (command.equals("observe"))
				{
					String printDesc = activeArtifact.observeArtifact();
					System.out.println(printDesc);
				}
			}
			else
			{
				System.out.println("I don't know where you can get one of those, but you definitely don't have one.");
			}
		}	
	}

	/**Method: parseArtifactName
	 * Determines item name from remaining words
	 * Sets letters after dash, space, or underscore as capital letters
	 * @return parsedArtifact
	 */
	public Artifact parseArtifactName(String artifactInput)
	{
		int separatorIndex;
		Artifact parsedArtifact;

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

		parsedArtifact = player.getPlayerInventory().get(artifactInput);
		if(!(activeRoom.getArtifact() == null) && artifactInput.equals(activeRoom.getArtifact().getName()))
		{
			parsedArtifact = activeRoom.getArtifact();
		}
		return parsedArtifact;
	}

	/**
	 * @return the player
	 */
	public static Player getPlayer()
	{
		return player;
	}

	/**
	 * @return the activeRoom
	 */
	public Room getActiveRoom()
	{
		return activeRoom;
	}

	/**
	 * @param player the player to set
	 */
	public static void setPlayer(Player player)
	{
		CharacterSubsystem.player = player;
	}

	/**
	 * @param activeRoom the activeRoom to set
	 */
	public void setActiveRoom(Room activeRoom)
	{
		this.activeRoom = activeRoom;
	}
}