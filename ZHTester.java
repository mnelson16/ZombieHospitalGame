import java.io.File;
import java.io.FileNotFoundException;
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
	private static Player player;// = new Player("00", 10, 10, 0, null);
	private static HashMap<String, Room> rooms;
	public static File stockSave = new File("stockSave.dat"), save1 = new File("save1.dat"), 
			save2 = new File("save2.dat"), save3 = new File("save3.dat");


	/**Main method
	 * @param args
	 */
	public static void main(String[] args)
	{
		ZombieFactory.createZombies();
		Scanner input = new Scanner(System.in);
		GameSubsystem gs = new GameSubsystem();
		CharacterSubsystem cs = new CharacterSubsystem();
		RoomSubsystem rs = new RoomSubsystem();
		player = gs.game.getNewPlayer();
		rooms = gs.game.getRooms();

		String help = "Available Commands: \n"
				+ "--Help Commands-- Help (Displays available commands and current room exits.)\n"
				+ "--Game Commands-- New, Save, Load \n"
				+ "--Other Commands-- Go <North, South, East, or West>, Inventory, Observe <Item>, Stats, Use <Item>";
		System.out.println(help + "\n");
		gs.game.makeNewGame();

		System.out.println(rooms.get(player.getCurrentRoomID()).getDescription());
		rooms.get(player.getCurrentRoomID()).setDescription("This is where you woke up. "
				+ "There's nothing interesting to find here.");

		while (true)
		{
			System.out.print("\n> ");
			userInput = input.nextLine().toLowerCase();
			userInput = userInput.replaceAll(" ", "_");
			System.out.print("\n");

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
			
			if (command.equals("help"))
			{
				if (rs.getActiveRoom() != null)
				{
					help += "\n" + rs.getActiveRoom().getExits();
				}
				System.out.println(help);
			}
			else if (command.equals("use") || command.equals("observe") || command.equals("stats")
					|| command.equals("inventory") || command.equals("take"))
			{
				cs.CSRun(player, rooms, command, object);
			}
			else if(command.equals("go"))
			{
				rs.RSRun(player, rooms, command, object);
			}
			else if(command.equals("new") || command.equals("save") || command.equals("load"))
			{
				gs.GSRun(player, rooms, command, object);
			}
			else 
			{
				System.out.println("What is it you want to do?");
			}

			//System.out.println();
		}
	}

	public Player getPlayer()
	{
		return player;
	}

	public HashMap<String, Room> getRooms()
	{
		return rooms;
	}

	public static void setPlayer(Player player)
	{
		ZHTester.player = player;
	}

	public static void setRooms(HashMap<String, Room> updatedRooms)
	{
		ZHTester.rooms = updatedRooms;
	}
}