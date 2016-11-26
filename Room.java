import java.io.Serializable;
import java.util.HashMap;

/**Class: Room
 * @authors Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Oct 24, 2016
 * 
 *
 * This class provides the blueprint for Room.
 *
 * Purpose: Hold information relating to what the player can do in a given room.
 */

public class Room implements Serializable
{
	private String roomID, description;
	private Zombie zombie;
	private Puzzle puzzle;
	private Artifact artifact;
	private HashMap<String, Room> exitIDs = new HashMap<String, Room>();
	private boolean saveableRoom;
	
	/**
	 * @param roomID
	 * @param description
	 * @param saveableRoom
	 */
	public Room(String roomID, String description, boolean saveableRoom)
	{
		this.roomID = roomID;
		this.description = description;
		this.saveableRoom = saveableRoom;
	}
	/**
	 * 
	 * @param roomID
	 * @param description
	 * @param saveableRoom
	 * @param zombie
	 * @param artifact
	 */
	public Room(String roomID, String description, boolean saveableRoom, Zombie zombie, Artifact artifact)
	{
		this.roomID = roomID;
		this.description = description;
		this.saveableRoom = saveableRoom;
		this.zombie = zombie;
		this.artifact = artifact;
	}
	/**
	 * 
	 * @param roomID
	 * @param description
	 * @param saveableRoom
	 * @param puzzle
	 * @param artifact
	 */
	public Room(String roomID, String description, boolean saveableRoom, Puzzle puzzle, Artifact artifact)
	{
		this.roomID = roomID;
		this.description = description;
		this.saveableRoom = saveableRoom;
		this.puzzle = puzzle;
		this.artifact = artifact;
	}
	/**Constructor
	 * 
	 * @param roomID
	 * @param description
	 * @param saveableRoom
	 * @param artifact
	 */
	public Room(String roomID, String description, boolean saveableRoom, Artifact artifact)
	{
		this.roomID = roomID;
		this.description = description;
		this.saveableRoom = saveableRoom;
		this.artifact = artifact;
	}
	/**
	 * @return the roomID
	 */
	public String getRoomID()
	{
		return roomID;
	}
	/**
	 * @return the description and list of exits
	 */
	public String getDescription()
	{
		if (isSaveableRoom())
		{
			return description + "\n(You can save your game here.)\n" + getExits();
		}
		else
		{
			return description + "\n" + getExits();
		}
	}
	/**
	 * @return the zombie
	 */
	public Zombie getZombie()
	{
		return zombie;
	}
	/**
	 * @return the puzzle
	 */
	public Puzzle getPuzzle()
	{
		return puzzle;
	}
	/**
	 * @return the artifact
	 */
	public Artifact getArtifact()
	{
		return artifact;
	}
	public String getExits()
	{
		String exStr = "";
		for (String exit : exitIDs.keySet())
		{
			exStr += exit + ", ";
		}
		if (exStr.length() > 0)
		{
			exStr = exStr.substring(0, exStr.length() - 2);
			return "EXITS ARE: [" + exStr.toUpperCase() + "]";
		}
		return "NO EXITS";
	}
	/**
	 * @return the exitIDs
	 */
	public HashMap<String, Room> getExitIDs()
	{
		return exitIDs;
	}
	/**
	 * @return the saveableRoom
	 */
	public boolean isSaveableRoom()
	{
		return saveableRoom;
	}
	/**
	 * @param roomID the roomID to set
	 */
	public void setRoomID(String roomID)
	{
		this.roomID = roomID;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	/**
	 * @param zombie the zombie to set
	 */
	public void setZombie(Zombie zombie)
	{
		this.zombie = zombie;
	}
	/**
	 * @param puzzle the puzzle to set
	 */
	public void setPuzzle(Puzzle puzzle)
	{
		this.puzzle = puzzle;
	}
	/**
	 * @param artifact the artifact to set
	 */
	public void setArtifact(Artifact artifact)
	{
		this.artifact = artifact;
	}
	/**
	 * @param north
	 * @param east
	 * @param south
	 * @param west
	 */
	public void setExits(Room north, Room east, Room south, Room west) 
	{
		if (north != null)
			exitIDs.put("north", north);
		if (east != null)
			exitIDs.put("east", east);
		if (south != null)
			exitIDs.put("south", south);
		if (west != null)
			exitIDs.put("west", west);
	}
	/**
	 * @param exitIDs the exitIDs to set
	 */
	public void setExitIDs(HashMap<String, Room> exitIDs)
	{
		this.exitIDs = exitIDs;
	}
	/**
	 * @param saveableRoom the saveableRoom to set
	 */
	public void setSaveableRoom(boolean saveableRoom)
	{
		this.saveableRoom = saveableRoom;
	}
	
	
}