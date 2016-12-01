import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**Class: Puzzle
 * @authors Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Oct 24, 2016
 *
 *
 * This class organizes Puzzle structure. Allows puzzle to damage player or equip items.
 *
 * Purpose: create a system for the player to solve puzzles.
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

	public void solvePuzzle(Player mon, String userInput, HashMap<String, Artifact> artifacts)
	{
		input = new Scanner(System.in);
		char userAnswer = userInput.charAt(0);
		setChosenOption(userAnswer);
		goBack = false;

		if(responses.containsKey(userAnswer))
		{
			if(Arrays.asList(correctOption).contains(userAnswer))
			{
				if(puzzleID.equalsIgnoreCase("PUZ001"))
				{
					if(!mon.getPlayerInventory().containsKey("Crowbar"))
					{
						userAnswer = 'd';
						System.out.println("You can't pry with your hands.. You return to the previoius room to search for\n"
								+ "something to pry the boards.");
					}
				}
				if(userAnswer == equipOption) //choice to equip armor
				{
					LinkedHashMap<String, Artifact> updatedInv = mon.getPlayerInventory();
					updatedInv.put("Obamacare Armor", artifacts.get("Obamacare Armor"));
					mon.setPlayerInventory(updatedInv);
					mon.getPlayerInventory().get("Obamacare Armor").useArtifact(mon);
				}
				else if(userAnswer == itemOption)
				{
					LinkedHashMap<String, Artifact> updatedInv = ((Player) mon).getPlayerInventory();
					if(puzzleID.equalsIgnoreCase("PUZ002"))
					{
						updatedInv.put("Flashlight", artifacts.get("Flashlight"));
					}
					else if(puzzleID.equalsIgnoreCase("PUZ004"))
					{
						updatedInv.put("Obamacare Armor", artifacts.get("Obamacare Armor"));
					}
					else if(puzzleID.equalsIgnoreCase("PUZ006"))
					{
						updatedInv.put("Hand Gun", artifacts.get("Hand Gun"));
					}
					((Player) mon).setPlayerInventory(updatedInv);
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
							updatedInv.put("Fire Axe", artifacts.get("Fire Axe"));
							mon.setPlayerInventory(updatedInv);
							finished = true;
							System.out.println("You pick up the fire axe and move on.");
						}
						else if(userYN.equalsIgnoreCase("n"))
						{
							finished = true;
						}
						else
						{
							System.out.println("You can't decide if you want to pick up the Fire Axe"
									+ "... Let's rethink this...\n");
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
						userCheck = userCheck.toLowerCase();
						if(userCheck.contains("silence"))
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
							System.out.println("That didn't seem to work... Maybe try a different word?");
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
				System.out.println(responses.get(userAnswer));
			}
			if(userAnswer == backOption)
			{
				System.out.println(responses.get(userAnswer));
				goBack = true;
			}
			if(Arrays.asList(damageOption).contains(userAnswer))
			{
				if(puzzleID.equalsIgnoreCase("PUZ002"))
				{
					if(userAnswer == 'b')
					{
						LinkedHashMap<String, Artifact> updatedInv = mon.getPlayerInventory();
						updatedInv.put("Old Nail", artifacts.get("Old Nail"));
						mon.setPlayerInventory(updatedInv);
					}
				}
				mon.setHealth(mon.getHealth() - 5);
				System.out.println(responses.get(userAnswer));
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

	/**
	 * @return the roomID
	 */
	public String getRoomID()
	{
		return roomID;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @return the backOption
	 */
	public char getBackOption()
	{
		return backOption;
	}

	/**
	 * @return the equipOption
	 */
	public char getEquipOption()
	{
		return equipOption;
	}

	/**
	 * @return the itemOption
	 */
	public char getItemOption()
	{
		return itemOption;
	}

	/**
	 * @return the possibleOption
	 */
	public char getPossibleOption()
	{
		return possibleOption;
	}

	/**
	 * @return the inputOption
	 */
	public char getInputOption()
	{
		return inputOption;
	}

	/**
	 * @return the injureOption
	 */
	public char getInjureOption()
	{
		return injureOption;
	}

	/**
	 * @return the damageOption
	 */
	public Character[] getDamageOption()
	{
		return damageOption;
	}

	/**
	 * @return the options
	 */
	public ArrayList<String> getOptions()
	{
		return options;
	}

	/**
	 * @return the responses
	 */
	public LinkedHashMap<Character, String> getResponses()
	{
		return responses;
	}

	/**
	 * @return the input
	 */
	public Scanner getInput()
	{
		return input;
	}

	/**
	 * @param puzzleID the puzzleID to set
	 */
	public void setPuzzleID(String puzzleID)
	{
		this.puzzleID = puzzleID;
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
	 * @param backOption the backOption to set
	 */
	public void setBackOption(char backOption)
	{
		this.backOption = backOption;
	}

	/**
	 * @param equipOption the equipOption to set
	 */
	public void setEquipOption(char equipOption)
	{
		this.equipOption = equipOption;
	}

	/**
	 * @param itemOption the itemOption to set
	 */
	public void setItemOption(char itemOption)
	{
		this.itemOption = itemOption;
	}

	/**
	 * @param possibleOption the possibleOption to set
	 */
	public void setPossibleOption(char possibleOption)
	{
		this.possibleOption = possibleOption;
	}

	/**
	 * @param inputOption the inputOption to set
	 */
	public void setInputOption(char inputOption)
	{
		this.inputOption = inputOption;
	}

	/**
	 * @param injureOption the injureOption to set
	 */
	public void setInjureOption(char injureOption)
	{
		this.injureOption = injureOption;
	}

	/**
	 * @param correctOption the correctOption to set
	 */
	public void setCorrectOption(Character[] correctOption)
	{
		this.correctOption = correctOption;
	}

	/**
	 * @param damageOption the damageOption to set
	 */
	public void setDamageOption(Character[] damageOption)
	{
		this.damageOption = damageOption;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(ArrayList<String> options)
	{
		this.options = options;
	}

	/**
	 * @param responses the responses to set
	 */
	public void setResponses(LinkedHashMap<Character, String> responses)
	{
		this.responses = responses;
	}

	/**
	 * @param input the input to set
	 */
	public void setInput(Scanner input)
	{
		this.input = input;
	}
}
