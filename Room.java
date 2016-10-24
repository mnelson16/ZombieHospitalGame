import java.util.ArrayList;

/**Class: Room.java
 * @author Janna Timmer
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
	private ArrayList<String> exitIDs = new ArrayList<String>();
	private boolean saveableRoom;
	
	/**
	 * 
	 */
	public Room(String roomID, String description, ArrayList<Monster> monsters, Puzzle puzzle,
			ArrayList<String> exitIDs, boolean saveableRoom)
	{
		this.roomID = roomID;
		this.description = description;
		this.monsters = monsters;
		this.puzzle = puzzle;
		this.exitIDs = exitIDs;
		this.saveableRoom = saveableRoom;
	}
	
	public void goDirection()
	{
		
	}

}
