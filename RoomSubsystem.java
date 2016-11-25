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
		
		//Room startRoom = player.getCurrentRoom()
		//Room activeRoom = startRoom;
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
						break;
					}
				}
				System.out.println(activeRoom.getDescription());
			}
			/*else if(!(activeRoom.getMonsters() == null))
			{
				//Encounter monster here
			}*/
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
