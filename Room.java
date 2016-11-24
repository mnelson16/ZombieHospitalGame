import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;

/**Class: Room
 * @authors Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Oct 24, 2016
 * 
 *
 * This class - now describe what the class does
 *
 * Purpose: - Describe the purpose of this class
 */

public class Room
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
	 * @param exitIDs 
	 * @param saveableRoom 
	 * @param monsters 
	 * @param puzzle 
	 * 
	 */
	public Room(String roomID, String description, boolean saveableRoom)
	{
		this.roomID = roomID;
		this.description = description;
		this.saveableRoom = saveableRoom;
	}
	public Room(String roomID, String description, boolean saveableRoom, Zombie zombie, Artifact artifact)
	{
		this.roomID = roomID;
		this.description = description;
		this.saveableRoom = saveableRoom;
		this.zombie = zombie;
	}
	public Room(String roomID, String description, boolean saveableRoom, Puzzle puzzle , Artifact artifact)
	{
		this.roomID = roomID;
		this.description = description;
		this.saveableRoom = saveableRoom;
		this.puzzle = puzzle;
	}
	public Room(String roomID, String description, boolean saveableRoom, Artifact artifact)
	{
		this.roomID = roomID;
		this.description = description;
		this.saveableRoom = saveableRoom;
		this.artifact = artifact;
	}
	
	public String getRoomID() 
	{
		return roomID;
	}
	public String getDescription() 
	{
		return description + "\n" + getExits();
	}
	public Zombie getZombie() 
	{
		return zombie;
	}
	public Puzzle getPuzzle() 
	{
		return puzzle;
	}
	public HashMap<String, Room> getExitIDs() 
	{
		return exitIDs;
	}
	public String getExits()
	{
		String str = StringUtils.join(exitIDs.keySet().toArray(), ", ");
		str = "EXITS ARE: [" + str.toUpperCase() + "]";
		return str;
	}
	public void setRoomID(String roomID) 
	{
		this.roomID = roomID;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public void setMonsters(Zombie zombie) 
	{
		this.zombie = zombie;
	}
	public void setPuzzle(Puzzle puzzle) 
	{
		this.puzzle = puzzle;
	}
	public void setExitIDs(HashMap<String, Room> exitIDs) 
	{
		this.exitIDs = exitIDs;
	}
	public Artifact getArtifact() {
		return artifact;
	}
	public void setArtifact(Artifact artifact) {
		this.artifact = artifact;
	}
	public void setZombie(Zombie zombie) {
		this.zombie = zombie;
	}
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
	public void setSaveableRoom(boolean saveableRoom) 
	{
		this.saveableRoom = saveableRoom;
	}
	public boolean isSaveableRoom() 
	{
		return saveableRoom;
	}
}