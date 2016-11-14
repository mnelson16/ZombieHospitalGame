import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

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
	private ArrayList<Monster> monsters = new ArrayList<Monster>();
	private Puzzle puzzle;
	private Map<String,Room> exitIDs;
	private boolean saveableRoom;
	private String artifacts;
	
	/**
	 * @param roomID 
	 * @param description 
	 * @param exitIDs 
	 * @param saveableRoom 
	 * @param monsters 
	 * @param puzzle 
	 * 
	 */
	public Room(String roomID, String description, Map<String, Room> exitIDs, boolean saveableRoom)
	{
		this.roomID = roomID;
		this.description = description;
		this.exitIDs = exitIDs;
		this.saveableRoom = saveableRoom;
		exitIDs = new LinkedHashMap<String, Room>();
	}
	public Room(String roomID, String description, Map<String, Room> exitIDs, boolean saveableRoom,ArrayList<Monster>monsters)
	{
		this.roomID = roomID;
		this.description = description;
		this.exitIDs = exitIDs;
		this.saveableRoom = saveableRoom;
		this.monsters= monsters;
	}
	public Room(String roomID, String description, Map<String, Room> exitIDs, boolean saveableRoom, Puzzle puzzle)
	{
		this.roomID = roomID;
		this.description = description;
		this.exitIDs = exitIDs;
		this.saveableRoom = saveableRoom;
		this.puzzle = puzzle;
	}
	public Room(String roomID, String description, Map<String, Room> exitIDs, boolean saveableRoom, String artifacts)
	{
		this.roomID = roomID;
		this.description = description;
		this.exitIDs = exitIDs;
		this.saveableRoom = saveableRoom;
		this.artifacts = artifacts;
	}
	

	public void setExitIDs(Room north, Room east, Room south, Room west) {
		if (north != null)
			exitIDs.put("north", north);
		if (east != null)
			exitIDs.put("east", east);
		if (south != null)
			exitIDs.put("south", south);
		if (west != null)
			exitIDs.put("west", west);
	}

	
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setMonsters(ArrayList<Monster> monsters) {
		this.monsters = monsters;
	}
	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}
	public void setExitIDs(Map<String, Room> exitIDs) {
		this.exitIDs = exitIDs;
	}
	public void setSaveableRoom(boolean saveableRoom) {
		this.saveableRoom = saveableRoom;
	}
	public String getDescription() {
		return description;
	}
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}
	public Puzzle getPuzzle() {
		return puzzle;
	}
	public Map<String, Room> getExitIDs() {
		return exitIDs;
	}
	public boolean isSaveableRoom() {
		return saveableRoom;
	}
	public String getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(String artifacts) {
		this.artifacts = artifacts;
	}

	}
