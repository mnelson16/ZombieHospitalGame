import java.util.HashMap;
import java.util.Scanner;

public class RoomSubsystem
{
	public static int separatorIndex; //index of dash or underscore
	public Room activeRoom;
	
	public void RSRun(Player player, HashMap<String, Room> rooms, String command, String roomInput)
	{
		activeRoom = rooms.get(player.getCurrentRoomID());
		String userInput;
		Scanner input = new Scanner(System.in);
		
		if(activeRoom.getExitIDs().containsKey(roomInput))
		{
			player.setPreviousRoomID(activeRoom.getRoomID());
			player.setCurrentRoomID(activeRoom.getExitIDs().get(roomInput).getRoomID());
			activeRoom = activeRoom.getExitIDs().get(roomInput);
			if(!(activeRoom.getPuzzle() == null))
			{
				if(!activeRoom.getPuzzle().getSolved())
				{
					activeRoom.getPuzzle().encounterPuzzle();
				}
				while(!activeRoom.getPuzzle().getSolved())
				{
					System.out.print("> ");
					userInput = input.nextLine();
					activeRoom.getPuzzle().solvePuzzle(player, userInput);
					if(activeRoom.getPuzzle().getGoBack())
					{
						activeRoom.getPuzzle().setGoBack(false);
						activeRoom = rooms.get(player.getPreviousRoomID());
						player.setCurrentRoomID(activeRoom.getRoomID());
						break;
					}
				}
				System.out.println(activeRoom.getDescription());
			}
			else if(!(activeRoom.getZombie() == null))
			{
				if(!activeRoom.getZombie().isDead())
				{
					String help = "Available fight commands: \nAttack, Flee";
					System.out.println("Something's coming..");
					System.out.println("Fight engaged with " + activeRoom.getZombie().getName() + "!");
					System.out.println(activeRoom.getZombie().getName() + " HP: " + activeRoom.getZombie().getHealth()		
					+ "/" + activeRoom.getZombie().getMaxHealth());
					System.out.println("Your HP: " + player.getHealth() + "/" + player.getMaxHealth());
					System.out.println("\n" + help);
					while (player.getHealth() > 0 && activeRoom.getZombie().getHealth() > 0)
					{
						System.out.print("> ");
						userInput = input.nextLine();
						if (userInput.equals("attack"))
						{
							player.attack(activeRoom.getZombie());
							if (activeRoom.getZombie().getHealth() > 0 && player.getHealth() > 0)
							{
								try
								{
									Thread.sleep(800);
								} 
								catch (InterruptedException e)
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								activeRoom.getZombie().attack(player);
	
							}
							else if (activeRoom.getZombie().getHealth() <= 0)
							{
								System.out.println(activeRoom.getZombie().getName() + " is dead!");
								System.out.println("Your HP: " + player.getHealth() + "/" + player.getMaxHealth());
								activeRoom.getZombie().setDead(false);
							}
							else if (player.getHealth() <= 0)
							{
								System.out.println("You are dead.");
							}
						}
						if(userInput.equals("flee"))
						{
							System.out.println("You ran back to the previous room!");
							activeRoom = rooms.get(player.getPreviousRoomID());
							player.setCurrentRoomID(activeRoom.getRoomID());
							break;
						}
					}
					System.out.println(activeRoom.getDescription());
				}
			}
			else
			{
				System.out.println(activeRoom.getDescription());
			}
		}
		else
		{
			System.out.println("There doesn't seem to be an exit in that direction.. "
					+ "Where do you want to go?");
		}
	}
}