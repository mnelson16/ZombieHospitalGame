import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

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
	private char chosenOption, backOption, equipOption, itemOption, 
		possibleOption, inputOption, injureOption;
	private Character[] correctOption, damageOption;
	private ArrayList<String> options;
	private LinkedHashMap<Character, String> responses = 
			new LinkedHashMap<Character, String>();
	private boolean solved;

	/**
	 * 
	 */
	public Puzzle(String puzzleID, String roomID, String description, 
			char backOption, char equipOption, char itemOption, 
			char possibleOption, char inputOption, char injureOption,
			Character[] correctOption, Character[] damageOption, ArrayList<String> options,
			LinkedHashMap<Character, String> responses, boolean solved)
	{
		this.puzzleID = puzzleID;
		this.roomID = roomID;
		this.description = description;
		this.backOption = backOption;
		this.equipOption = equipOption;
		this.itemOption = itemOption;
		this.possibleOption = possibleOption;
		this.inputOption = inputOption;
		this.injureOption = injureOption;
		this.correctOption = Arrays.copyOf(correctOption, correctOption.length);
		this.damageOption = damageOption;
		this.options = options;
		this.responses = responses;
		this.solved = solved;
	}

	public void encounterPuzzle()
	{
		System.out.println(description + "\nOptions:");
		for(int i = 0; i < options.size(); i++)
        	{
            		String option = options.get(i);
            		System.out.println(option);
        	}
		System.out.println("What do you do?");
	}
	
	public void solvePuzzle(Monster mon, String userInput)
	{
		char userAnswer = userInput.charAt(0);
		setChosenOption(userAnswer);
		
		if(responses.containsKey(userAnswer))
		{
			System.out.println(responses.get(userAnswer));
			if(Arrays.asList(correctOption).contains(userAnswer))
			{
				if(userAnswer == equipOption)
				{
					//Equip the specified artifact to the player.
				}
				else if(userAnswer == itemOption)
				{
					//Put the specified artifact in the player's inventory
				}
				else if(userAnswer == possibleOption)
				{
					/*Ask the player if they would like to place the 
					specified artifact in their inventory. If so,
					place the artifact in their inventory; if not,
					don't.*/
					System.out.println("Would you like to take the " + "? \n(Y/N)");
				}
				else if(userAnswer == inputOption)
				{
					//Ask the player for their input and take a single line
					//of input to check against the correct puzzle.
				}
				else if(userAnswer == injureOption)
				{
					//Damage the player's maximum health.
				}
				solved = true;
			}
			if(userAnswer == backOption)
			{
				//Return the user to the previous room here.
			}
			if(Arrays.asList(damageOption).contains(userAnswer))
			{
				mon.setHealth(mon.getHealth());
				System.out.println("-5 health!");
			}
		}
	}
	
	public String getPuzzleID()
	{
		return puzzleID;
	}
	
	public char getChosenOption()
	{
		return chosenOption;
	}
	
	public Character[] getCorrectOption()
	{
        	return correctOption;
	}
	
	public boolean getSolved()
	{
		return solved;
	}

	public void setChosenOption(char chosenOption)
	{
		this.chosenOption = chosenOption;
	}
	
	public void setSolved(boolean solved)
	{
		this.solved = solved;
	}
}
