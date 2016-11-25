import java.util.LinkedHashMap;
import java.util.Scanner;

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
	public static Player player;
	//Player player = new Player("00", 20, 5, 5, null);

	/**Method: CSRun
	 * Handles major functionality for the Character subsystem -- Artifact and Monster
	 * @param p main Player
	 * @param command -- first word user typed in (game action to be taken)
	 * @param activeArtifact -- artifact user typed in (null if user typed in one word command)
	 */
	public void CSRun(Player p, String command, String artifactInput, Zombie z)
	{
		Artifact activeArtifact;
		player = p;

		if (command.equals("stats"))
		{
			System.out.println(player.viewStats());
		}
		else if (command.equals("inventory"))
		{
			System.out.println(player.inventoryToString());
		}
		else if (command.equals("fight"))
		{
			fight(z);
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

	/**Method: fight
	 * 
	 */
	public void fight(Zombie tempZom)
	{
		Scanner input = new Scanner(System.in);
		String help = "Available fight commands: \nAttack, Flee";
		
		System.out.println("Fight engaged with " + tempZom.getName() + "!");
		System.out.println(((Zombie) tempZom).getName() + " HP: " + tempZom.getHealth()		
		+ "/" + tempZom.getMaxHealth());
		System.out.println("Your HP: " + player.getHealth() + "/" + player.getMaxHealth());
		System.out.println("\n" + help);
		while (player.getHealth() > 0 && tempZom.getHealth() > 0)
		{
			System.out.print("> ");
			if (input.nextLine().equals("attack"))
			{
				player.attack(tempZom);
				if (tempZom.getHealth() > 0 && player.getHealth() > 0)
				{
					try
					{
						Thread.sleep(800);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tempZom.attack(player);

				}
				else if (tempZom.getHealth() <= 0)
				{
					System.out.println(tempZom.getName() + " is dead!");
					System.out.println("Your HP: " + player.getHealth() + "/" + player.getMaxHealth());
				}
				else if (player.getHealth() <= 0)
				{
					System.out.println("You are dead.");
				}
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
		return parsedArtifact;
	}
}
