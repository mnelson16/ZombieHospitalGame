import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**Class: ZHTester
 * @authors Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Oct 3, 2016
 * 
 *
 * This class handles user input and organizes/combines subsystem components.
 *
 * Purpose: Handle user input and run major subsystem functionality.
 */

public class ZHTester
{
	private static String command, object, userInput;
	private static Player player = new Player("00", 20, 5, 5, null);
	
	/**Main method
	 * @param args
	 */
	public static void main(String[] args)
	{
		Game game = new Game();
		Scanner input = new Scanner(System.in);
		CharacterSubsystem cs = new CharacterSubsystem();
		RoomSubsystem rs = new RoomSubsystem();
		//Temporary - inventory should be added to in... room?
		player.setPlayerInventory(ArtifactFactory.createArtifacts());
		
		/*
		 * "take" command go to room?
		 */
		
		//Temp
		String help = "Available commands: \n"
				+ "Go <Direction>, Help, Inventory, Observe <Item>, Stats, Use <Item>";
		System.out.println(help);
		System.out.println(rs.activeRoom.getDescription());

		while (true)
		{
			System.out.print("> ");
			userInput = input.nextLine().toLowerCase();
			userInput = userInput.replaceAll(" ", "_");
			
			if (userInput.contains("_")) //If userInput is multi-word
			{
				command = userInput.substring(0, userInput.indexOf("_"));
				//Set object to word(s) after command with underscores replacing spaces
				object = userInput.substring(userInput.indexOf("_") + 1);
			}
			else //If userInput is one word
			{
				command = userInput;
				object = "";
			}

			//Temp, move help functionality to Game class
			if (command.equals("help"))
			{
				System.out.println(help);
			}
			else if (command.equals("use") || command.equals("observe") || command.equals("stats")
					|| command.equals("inventory"))
			{
				cs.CSRun(player, command, object);	
			}
			else if(command.equals("go"))
			{
				rs.RSRun();
			}
			else 
			{
				System.out.println("What is it you want to do?");
			}

			//System.out.println();
		}
	}
}
