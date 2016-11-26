import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**Class: GameSubsystem.java
 * @author Janna Timmer
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Nov 17, 2016
 * 
 *
 * This class provides structure for the Game subsystem (Game class)
 *
 * Purpose: to organize the Game subsystem
 */

public class GameSubsystem
{
	public Game game = new Game();
	public void GSRun(Player player, HashMap<String, Room> rooms, String command, String gameInput)
	{
		String userInput;
		Scanner input = new Scanner(System.in);
		
		if(command.equals("new"))
		{
			game.newGame();
		}
		else if(command.equals("save"))
		{
			if(rooms.get(player.getCurrentRoomID()).isSaveableRoom())
			{	
				boolean saved = false;
				while(!saved)
				{
					System.out.print("Which file would you like to overwrite? (Respond with 1, 2 or 3;"
							+ " Respond with 'back' to stop)\n\n> ");
					userInput = input.nextLine();
					System.out.print("\n");
					if(userInput.equals("1"))
					{
						game.saveGame(ZHTester.save1, player, rooms);
						saved = true;
					}
					else if(userInput.equals("2"))
					{
						game.saveGame(ZHTester.save2, player, rooms);
						saved = true;
					}
					else if(userInput.equals("3"))
					{
						game.saveGame(ZHTester.save3, player, rooms);
						saved = true;
					}
					else if(userInput.equals("back"))
					{
						System.out.println("Your game was not saved.");
						break;
					}
					else
					{
						System.out.println("That wasn't a valid save file.. Could you try again?");
					}
					
					if(saved)
					{
						System.out.println("Save complete.");
					}
				}
			}
			else
			{
				System.out.println("You can't save here!");
			}
		}
		else if(command.equals("load"))
		{
			boolean loaded = false;
			while(!loaded)
			{
				System.out.print("Which file would you like to load? (Respond with 1, 2 or 3;"
						+ " Respond with 'back' to stop)\n\n> ");
				userInput = input.nextLine();
				System.out.print("\n");
				if(userInput.equals("1"))
				{
					game.loadGame(ZHTester.save1);
					loaded = true;
				}
				else if(userInput.equals("2"))
				{
					game.loadGame(ZHTester.save2);
					loaded = true;
				}
				else if(userInput.equals("3"))
				{
					game.loadGame(ZHTester.save3);
					loaded = true;
				}
				else if(userInput.equals("back"))
				{
					System.out.println("Your game was not loaded.");
					break;
				}
				else
				{
					System.out.println("That wasn't a valid save file.. Could you try again?");
				}
				
				if(loaded)
				{
					System.out.println("Load complete.");
				}
			}
		}
	}
	/**
	 * @return the game
	 */
	public Game getGame()
	{
		return game;
	}
	/**
	 * @param game the game to set
	 */
	public void setGame(Game game)
	{
		this.game = game;
	}
}