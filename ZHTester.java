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
 * This class - now describe what the class does
 *
 * Purpose: - Describe the purpose of this class
 */

public class ZHTester
{
	public static String command, artifactInput, userInput;
	public static Artifact activeArtifact;
	private static Player player = new Player("00", 20, 5, 5, null);
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Game game = new Game();
		Scanner input = new Scanner(System.in);
		CharacterSubsystem cs = new CharacterSubsystem();
		RoomSubsystem rs = new RoomSubsystem();
		
		/* Search for multiple words
		 * If one word, send to appropriate subsystem
		 * If multiple words, send to artifact (character) subsystem (except "take" command maybe goes to room?)
		 */
		
		//Temp
		String help = "Available commands: \n"
				+ "Help, Inventory, Observe <Item>, Stats, Use <Item>, "
				+ rs.activeRoom.getDescription();
		System.out.println(help);

		while (true)
		{
			System.out.print("> ");
			userInput = input.nextLine().toLowerCase();
			userInput = userInput.replaceAll(" ", "_");
			if (userInput.contains("_")) //If userInput is multi-word command
			{
				command = userInput.substring(0, userInput.indexOf("_"));
			}
			else //If userInput is one-word command
			{
				command = userInput;
			}

			//Temp, move help functionality to Game class
			//One word commands
			if (command.equals("help"))
			{
				System.out.println(help);
			}
			else if (command.equals("inventory"))
			{
				System.out.println(player.inventoryToString());
			}
			//Two or more word commands
			else if (command.equals("use") || command.equals("observe") || command.equals("stats"))
			{
				cs.CSRun(player);	
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
