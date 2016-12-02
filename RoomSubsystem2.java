import java.util.HashMap;
import java.util.Scanner;

/**Class: RoomSubsystem
 * @author Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Nov 20, 2016
 *
 *
 * This class provides structure for the Room subsystem (Room and Puzzle classes)
 *
 * Purpose: to organize the Room subsystem
 */

public class RoomSubsystem
{
	public static int separatorIndex; //index of dash or underscore
	public Room activeRoom;

	public void RSRun(Player player, HashMap<String, Room> rooms, String command, String roomInput,
			HashMap<String, Artifact> artifacts)
	{
		activeRoom = rooms.get(player.getCurrentRoomID());
		String userInput, fightHelp;
		Game game = new Game();
		Scanner input = new Scanner(System.in);
		boolean dead = false;

		if(activeRoom.getExitIDs().containsKey(roomInput))
		{
			//Changes description for when player revisits room and there is an item
			if (activeRoom.getArtifact() != null)
			{
				activeRoom.setDescription("You've been here before. An item remains: "
						+ activeRoom.getArtifact().getName());
			}

			player.setPreviousRoomID(activeRoom.getRoomID());
			player.setCurrentRoomID(activeRoom.getExitIDs().get(roomInput).getRoomID());
			activeRoom = activeRoom.getExitIDs().get(roomInput);

			if((activeRoom.getPuzzle() != null)) //If there's a puzzle in the room
			{
				if(!activeRoom.getPuzzle().getSolved()) //If the puzzle is not yet solved
				{
					activeRoom.getPuzzle().encounterPuzzle();
				}
				while(!activeRoom.getPuzzle().getSolved()) //while puzzle is not solved
				{
					try
					{
						//ask for puzzle answer
						System.out.print("> ");
						userInput = input.nextLine();
						activeRoom.getPuzzle().solvePuzzle(player, userInput, artifacts);
						if(activeRoom.getPuzzle().getGoBack())
						{
							activeRoom.getPuzzle().setGoBack(false);
							activeRoom = rooms.get(player.getPreviousRoomID());
							player.setCurrentRoomID(activeRoom.getRoomID());
							break;
						}
						else if (player.getHealth() <= 0) //If player dies
						{
							dead = true;
							break;
						}
					}
					catch(Exception e)
					{
						System.out.println("What is it you want to do?");
					}
				}
				if(!dead)
				{
					System.out.println(activeRoom.getDescription());
				}
			}
			//If there's a zombie in the room
			else if(activeRoom.getZombie() != null)
			{
				if (activeRoom.getZombie().isDead()) //If the zombie is dead
				{
					System.out.println(activeRoom.getDescription());
				}
				else //If the zombie isn't dead
				{
					System.out.println(activeRoom.getDescription() + "\n");
					try
					{
						Thread.sleep(4000);
						System.out.println("Something's coming...\n");
						Thread.sleep(2000);
					} catch (InterruptedException e1)
					{}
					//Fight output
					fightHelp = "Fight commands: \nAttack, Flee";
					System.out.println("Fight engaged with " + activeRoom.getZombie().getName() + "!");
					System.out.println(activeRoom.getZombie().getName() + " HP: " + activeRoom.getZombie().getHealth()
							+ "/" + activeRoom.getZombie().getMaxHealth());
					System.out.println("Your HP: " + player.getHealth() + "/" + player.getMaxHealth());
					System.out.println("\n" + fightHelp);
					//while player and zombie are alive
					while (player.getHealth() > 0 && activeRoom.getZombie().getHealth() > 0)
					{
						System.out.print("> ");
						userInput = input.nextLine();
						System.out.print("\n");
						if (userInput.equals("attack"))
						{
							player.attack(activeRoom.getZombie());
							//If player and zombie are alive
							if (activeRoom.getZombie().getHealth() > 0 && player.getHealth() > 0)
							{
								try
								{
									Thread.sleep(500);
								}
								catch (InterruptedException e)
								{}

								activeRoom.getZombie().attack(player);
							}
							if (activeRoom.getZombie().getHealth() <= 0) //If zombie dies
							{
								System.out.println(activeRoom.getZombie().getName() + " is dead!");
								//If there's armor or weapon in the room, notify player what the zombie dropped
								if (activeRoom.getArtifact() != null && (activeRoom.getArtifact().isArmor() ||
										activeRoom.getArtifact().isWeapon()))
								{
									System.out.println("It dropped " + activeRoom.getArtifact().getName() + ".");
								}
								System.out.println("Your HP: " + player.getHealth() + "/" + player.getMaxHealth());

								activeRoom.getZombie().setDead(true);
							}
							if (player.getHealth() <= 0) //If player dies
							{
								System.out.println("You are dead.\n");
								game.newGame();
							}
						}
						if(userInput.equals("flee"))
						{
							if (activeRoom.getZombie().isPlayerAttackPrevented())
							{
								player.attack(activeRoom.getZombie());
							}
							else
							{
								System.out.println("You ran back to the previous room!");
								activeRoom = rooms.get(player.getPreviousRoomID());
								System.out.println(activeRoom.getExits());
								player.setCurrentRoomID(activeRoom.getRoomID());
								break;
							}
						}
					}
				}
			}
			else
			{
				System.out.println(activeRoom.getDescription());
			}
		}
		else
		{
			System.out.println("There doesn't seem to be an exit in that direction... "
					+ "Where do you want to go?");
		}

		//Change description for when player revisits room and there is no item
		activeRoom.setDescription("You've already been here. There's nothing interesting to find.");
	}

	/**
	 * @return the activeRoom
	 */
	public Room getActiveRoom()
	{
		return activeRoom;
	}

	/**
	 * @param activeRoom the activeRoom to set
	 */
	public void setActiveRoom(Room activeRoom)
	{
		this.activeRoom = activeRoom;
	}

	/**
	 * @return the separatorIndex
	 */
	public static int getSeparatorIndex()
	{
		return separatorIndex;
	}

	/**
	 * @param separatorIndex the separatorIndex to set
	 */
	public static void setSeparatorIndex(int separatorIndex)
	{
		RoomSubsystem.separatorIndex = separatorIndex;
	}
}
