import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Game
{
	private RoomFactory rf = new RoomFactory();
	private Player newPlayer = new Player("00", 20, 5, 5, "L1001");
	private HashMap<String, Room> updatedRooms = new HashMap<String, Room>(), rooms = rf.getRooms();
	private Player player;
	
	public void makeNewGame()
	{
		saveGame(ZHTester.stockSave, newPlayer, rf.getRooms());
	}
	
	public void newGame()
	{
		loadGame(ZHTester.stockSave);
	}
	
	public void saveGame(File file, Player player, HashMap<String, Room> rooms)
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
			objectOut.writeObject(player);
			objectOut.writeObject(rooms);
			objectOut.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadGame(File file)
	{
		try
		{
			FileInputStream fileIn = new FileInputStream(file);
			@SuppressWarnings("resource")
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			
			player = (Player) objectIn.readObject();
			updatedRooms = (HashMap<String, Room>) objectIn.readObject();
			ZHTester.setPlayer(player);
			ZHTester.setRooms(updatedRooms);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(rooms.get(player.getCurrentRoomID()).getDescription());
	}

	public HashMap<String, Room> getRooms()
	{
		return rooms;
	}

	public Player getNewPlayer()
	{
		return newPlayer;
	}

	public HashMap<String, Room> getUpdatedRooms()
	{
		return updatedRooms;
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setRooms(HashMap<String, Room> rooms)
	{
		this.rooms = rooms;
	}

	public void setNewPlayer(Player newPlayer)
	{
		this.newPlayer = newPlayer;
	}

	public void setUpdatedRooms(HashMap<String, Room> updatedRooms)
	{
		this.updatedRooms = updatedRooms;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}
}
