/**Class: Zombie
 * @author Janna Timmer
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Oct 10, 2016
 * 
 *
 * This class extends the Monster class to include enemy (zombie) activity and traits.
 *
 * Purpose: To specify enemy traits/activity as opposed to player traits/activity.
 */

public class Zombie extends Monster
{

	/**
	 * @param ID
	 * @param maxHealth
	 * @param atk
	 * @param def
	 */
	public Zombie(String ID, int maxHealth, int atk, int def)
	{
		super(ID, maxHealth, atk, def);
	}

	/** (non-Javadoc)
	 * @see Monster#attack()
	 */
	@Override
	protected void attack()
	{
		// TODO Auto-generated method stub

	}

}
