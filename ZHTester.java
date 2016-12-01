import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


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
	private static HashMap<String, Artifact> artifacts;
	public static File stockSave = new File("stockSave.dat"), save1 = new File("save1.dat"), 
			save2 = new File("save2.dat"), save3 = new File("save3.dat");


	/**Main method
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		ZombieFactory.createZombies();
		ArtifactFactory.createArtifacts();
		PuzzleFactory.createPuzzles();
		ArtifactFactory af = new ArtifactFactory();
		GameSubsystem gs = new GameSubsystem();
		CharacterSubsystem cs = new CharacterSubsystem();
		RoomSubsystem rs = new RoomSubsystem();
		player = gs.game.getNewPlayer();
		rooms = gs.game.getRooms();
		artifacts = af.getAllArtifacts();
		gs.game.makeNewGame();

		//player.setCurrentRoomID("L2006");
		/*String help = "Available Commands: \n"
				+ "--Help Commands-- Help (Displays available commands and current room exits.)\n"
				+ "--Game Commands-- New, Save, Load \n"
				+ "--Other Commands-- Go <Direction>, Inventory, Observe <Item>, Stats, Take <Item>, Use <Item>";*/
		String help = "Available Commands: "
				+ "\n--Help Commands-- "
				+ "\nHelp (Displays available commands and current room exits.)"
				+ "\n--Game Commands-- "
				+ "\nNew || Save || Load"
				+ "\n--Other Commands-- "
				+ "\nGo <Direction> || Inventory || Observe <Item> || Stats || Take <Item> || Use <Item>";
		System.out.println(help + "\n");

		System.out.println(rooms.get(player.getCurrentRoomID()).getDescription());
		rooms.get(player.getCurrentRoomID()).setDescription("This is where you woke up. "
				+ "There's nothing interesting to find here.");

		while (true)
		{
			try
			{
				System.out.print("> ");
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

				if(player.getHealth() <= 0)
					 {
					 	System.out.println("You died.. \nStarting new game!");
					 	gs.game.newGame();
					 }
				else if (command.equals("help"))
				{
					System.out.println(help);
					if (rs.getActiveRoom() != null)
					{
						System.out.println("\n" + rs.getActiveRoom().getExits());
					}
				}
				else if (command.equals("use") || command.equals("observe") || command.equals("stats")
						|| command.equals("inventory") || command.equals("take"))
				{
					cs.CSRun(player, rooms, command, object);
				}
				else if(command.equals("go"))
				{
					rs.RSRun(player, rooms, command, object, artifacts);
				}
				else if(command.equals("new") || command.equals("save") || command.equals("load"))
				{
					gs.GSRun(player, rooms, command, object);
				}
			}
			catch (Exception e)
			{
				System.out.println("What is it you want to do?");
			}
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