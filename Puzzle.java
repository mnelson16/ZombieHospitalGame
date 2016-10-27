import java.util.ArrayList;

/**Class: Puzzle
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

public class Puzzle
{
	private String puzzleID, roomID, description;
	private ArrayList<String> options;
	private boolean solved;
	/**
	 * 
	 */
	public Puzzle(String puzzleID, String roomID, String description, ArrayList<String> options, boolean solved)
	{
		this.puzzleID = puzzleID;
		this.roomID = roomID;
		this.description = description;
		this.options = options;
		this.solved = solved;
	}

}
