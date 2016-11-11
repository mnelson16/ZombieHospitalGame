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
	public static String command, itemInput, userInput;
	public static Artifact activeItem;
	
	/**
	 * @param args
	 */


	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		CharacterSubsystem cs = new CharacterSubsystem();
		Player player = new Player("00", 20, 5, 5, false, null);
		
		/* Search for multiple words
		 * If one word, send to appropriate subsystem
		 * If multiple words, send to artifact (character) subsystem (except "take" command maybe goes to room?)
		 */
		
		//Temp
		System.out.println("Available commands: \n"
				+ "Help, Inventory, Observe <Item>, Use <Item>");

		while (true)
		{
			System.out.print("> ");
			userInput = input.nextLine().toLowerCase();
			userInput = userInput.replaceAll(" ", "_");
			if (userInput.contains("_"))
			{
				command = userInput.substring(0, userInput.indexOf("_"));
			}
			else
			{
				command = userInput;
			}

			//Temp, move help functionality to Game class
			//One word commands
			if (command.equals("help"))
			{
				System.out.println("Available commands: \n"
						+ "Help, Inventory, Observe <Item>, Use <Item>");
			}
			else if (command.equals("inventory"))
			{
				System.out.println(Player.inventoryToString());
			}
			//Two or more word commands
			else if (command.equals("use") || command.equals("observe"))
			{
				cs.CSRun();	
			}
			else 
			{
				System.out.println("What is it you want to do?");
			}

			System.out.println();
		}

	}

}
