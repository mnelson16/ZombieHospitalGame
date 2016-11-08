import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class PuzzleFactory
{
	private static HashMap<String, Puzzle> puzzles;
	public HashMap<String, Puzzle> getPuzzles()
	{
		puzzles = new LinkedHashMap<String, Puzzle>();
		ArrayList<String> options = new ArrayList<String>();
		LinkedHashMap<Character, String> responses = new LinkedHashMap<Character, String>();
		Puzzle tempPuzzle;
		
		options.add("a. Reach hand through glass and unlock door.");
		options.add("b. Yell down hallway.");
		options.add("c. Pry off boards.");
		options.add("d. Continue exploring elsewhere.");
		
		responses.put('a', "You attempt to reach your hand through the glass on the door, but"
				+ " you cut your hand!");
		responses.put('b', "No answer, but a low grumble erupts from deep within.");
		responses.put('c', "Puzzle solved!");
		responses.put('d', "You return to the previous room.");
		
		/*Puzzle constructor is:
		 *(puzzleID, roomID, description, 
		 *backOption, equipOption, itemOption, possibleOption, inputOption, injureOption, 
		 *correctOption, damageOption,
		 *options, responses, solved)
		 */
		tempPuzzle = new Puzzle("1", "1", "You come across a boarded up door marked "
				+ "“DEAD AHEAD, DO NOT OPEN.” Through the broken glass, you "
				+ "can see what appears to be blood on the floor beyond.", 'd', '\0',
				'\0', '\0', '\0', '\0', new Character[] {'c'}, new Character[] {'a'},
				options, responses, false);
		puzzles.put(tempPuzzle.getPuzzleID(), tempPuzzle);
		
		ArrayList<String> options2 = new ArrayList<String>();
		LinkedHashMap<Character, String> responses2 = new LinkedHashMap<Character, String>();
		
		options2.add("a. Twist the wires together to complete the circuit.");
		options2.add("b. Use an old nail on the floor to short the wires.");
		options2.add("c. Continue forward with no light.");
		options2.add("d. Turn back and hope to find another way.");
		
		responses2.put('a', "You've been shocked!");
		responses2.put('b', "You've been shocked!");
		responses2.put('c', "You trip and scrape your knee! It's impossible to navigate!");
		responses2.put('d', "As you turn around, a quick reflection catches your eye. "
				+ "You look closer and see a flashlight lying on the floor. Puzzle solved!");
		
		tempPuzzle = new Puzzle("2", "2", "The room ahead is pitch black, and impossible to "
				+ "navigate. You see what used to be a light switch, but the cover is ripped "
				+ "from the wall and the wires exposed. Faced with such a circumstance, there "
				+ "is no shame in retreating for more information. But perhaps there is "
				+ "something here to help…", 'd', '\0',
				'\0', '\0', '\0', '\0', new Character[] {'d'}, new Character[] {'a', 'b', 'c'}, 
				options2, responses2, false);
		puzzles.put(tempPuzzle.getPuzzleID(), tempPuzzle);
		
		return puzzles;
	}
}
