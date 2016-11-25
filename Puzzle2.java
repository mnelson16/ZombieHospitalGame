import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

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

public class Puzzle implements Serializable
{
	private String puzzleID, roomID, description;
	private char chosenOption, backOption, equipOption, itemOption, 
		possibleOption, inputOption, injureOption;
	private Character[] correctOption, damageOption;
	private ArrayList<String> options;
	private LinkedHashMap<Character, String> responses = 
			new LinkedHashMap<Character, String>();
	private boolean solved, goBack;
	private transient Scanner input;

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
	
	public void solvePuzzle(Player mon, String userInput)
	{
		input = new Scanner(System.in);
		char userAnswer = userInput.charAt(0);
		setChosenOption(userAnswer);
		goBack = false;
		
		if(responses.containsKey(userAnswer))
		{
			System.out.println(responses.get(userAnswer));
			if(Arrays.asList(correctOption).contains(userAnswer))
			{
				if(userAnswer == equipOption)
				{
					LinkedHashMap<String, Artifact> updatedInv = mon.getPlayerInventory();
					updatedInv.put("Obamacare Armor", new  Artifact("Obamacare Armor", "Issue #23-B."
							+ "\nAttack +3", false, false, true, 0, 1, 0));
					mon.setPlayerInventory(updatedInv);
					mon.getPlayerInventory().get("Obamacare Armor").useArtifact(mon);
				}
				else if(userAnswer == itemOption)
				{
					LinkedHashMap<String, Artifact> updatedInv = mon.getPlayerInventory();
					if(puzzleID.equalsIgnoreCase("PUZ002"))
					{
						updatedInv.put("Flashlight", new  Artifact("Flashlight", "There's just enough battery to last!", 
								false, false, false, 0, 0, 0));
					}
					else if(puzzleID.equalsIgnoreCase("PUZ004"))
					{
						updatedInv.put("Obamacare Armor", new  Artifact("Obamacare Armor", "Issue #23-B."
							+ "\nAttack +3", false, false, true, 0, 1, 0));
					}
					else if(puzzleID.equalsIgnoreCase("PUZ006"))
					{
						updatedInv.put("Hand Gun", new  Artifact("Hand Gun", "A weapon given to you by a brief friend."
								+ "\nAttack +2", false, true, false, 2, 0, 0));
					}
					mon.setPlayerInventory(updatedInv);					
				}
				else if(userAnswer == possibleOption)
				{
					boolean finished = false;
					while(!finished)
					{
						System.out.println("Would you like to take the " + "fire axe? \n(Y/N)");
						String userYN = input.nextLine();
						if(userYN.equalsIgnoreCase("y"))
						{
							LinkedHashMap<String, Artifact> updatedInv = mon.getPlayerInventory();
							updatedInv.put("Fire Axe", new  Artifact("Fire Axe", "The sharp truth."
									+ "\nAttack +3", false, true, false, 3, 0, 0));
							mon.setPlayerInventory(updatedInv);
							finished = true;
						}
						else if(userYN.equalsIgnoreCase("n"))
						{
							finished = true;
						}
						else
						{
							System.out.println("You can't decide if you want to pick up the"
									+ ".. Let's rethink this..\n");
						}
					}
				}
				else if(userAnswer == inputOption)
				{
					//Ask the player for their input and take a single line
					//of input to check against the correct puzzle.
					boolean finished = false;
					while(!finished)
					{
						System.out.print("> ");
						String userCheck = input.nextLine();
						if(userCheck.equalsIgnoreCase("silence"))
						{
							System.out.println("That seemed to do it!");
							finished = true;
						}
						else if(userCheck.equalsIgnoreCase("back"))
						{
							System.out.println("You decide you're not quite ready to type in the password.");
							finished = true;
							userAnswer = 'b';
						}
						else
						{
							System.out.println("That didn't seem to work.. Maybe try a different word?");
						}
					}
				}
				else if(userAnswer == injureOption)
				{
					mon.setMaxHealth(mon.getMaxHealth() - 5);
					System.out.println("-5 to max health!");
				}
				solved = true;
				if(!Arrays.asList(correctOption).contains(userAnswer))
				{
					solved = false;
				}
			}
			if(userAnswer == backOption)
			{
				goBack = true;
			}
			if(Arrays.asList(damageOption).contains(userAnswer))
			{
				mon.setHealth(mon.getHealth() - 5);
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
	
	public boolean getGoBack()
	{
		return goBack;
	}

	public void setChosenOption(char chosenOption)
	{
		this.chosenOption = chosenOption;
	}
	
	public void setSolved(boolean solved)
	{
		this.solved = solved;
	}
	
	public void setGoBack(boolean goBack)
	{
		this.goBack = goBack;
	}
}