import java.util.ArrayList;

/**Class: Player
 * @author Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Oct 10, 2016
 * 
 *
 * This class - now describe what the class does
 *
 * Purpose: - Describe the purpose of this class
 */

public class Player extends Monster
{
	private boolean inCombat;
	private String previousRoomID;

	/**
	 * @param monsterID
	 * @param health
	 * @param attack
	 * @param defense
	 * @param inventory
	 * @param inCombat
	 * @param previousRoomID
	 */
	public Player(String monsterID, int health, int attack, int defense, ArrayList<Artifact> inventory,
			boolean inCombat, String previousRoomID)
	{
		super(monsterID, health, attack, defense, inventory);
		this.inCombat = inCombat;
		this.previousRoomID = previousRoomID;
	}

	@Override
	protected void attack(Monster mon)
	{
		
	}

}
