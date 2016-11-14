import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class PuzzleFactory
{
	private static HashMap<String, Puzzle> puzzles;
	public HashMap<String, Puzzle> getPuzzles()
	{
		/*Puzzle constructor is:
		 *(puzzleID, roomID, description, 
		 *backOption, equipOption, itemOption, possibleOption, inputOption, injureOption, 
		 *correctOption, damageOption,
		 *options, responses, solved)
		 */
		puzzles = new LinkedHashMap<String, Puzzle>();
		ArrayList<String> options = new ArrayList<String>();
		LinkedHashMap<Character, String> responses = new LinkedHashMap<Character, String>();
		Puzzle tempPuzzle;
		
		//Puzzle 1
		options.add("a. Reach hand through glass and unlock door.");
		options.add("b. Yell down hallway.");
		options.add("c. Pry off boards.");
		options.add("d. Continue exploring elsewhere.");
		
		responses.put('a', "You attempt to reach your hand through the glass on the door, but"
				+ " you cut your hand!");
		responses.put('b', "No answer, but a low grumble erupts from deep within.");
		responses.put('c', "Puzzle solved!");
		responses.put('d', "You return to the previous room.");
		
		tempPuzzle = new Puzzle("PUZ001", "1", "You come across a boarded up door marked "
				+ "“DEAD AHEAD, DO NOT OPEN.” Through the broken glass, you "
				+ "can see what appears to be blood on the floor beyond.", 'd', '\0',
				'\0', '\0', '\0', '\0', new Character[] {'c'}, new Character[] {'a'},
				options, responses, false);
		puzzles.put(tempPuzzle.getPuzzleID(), tempPuzzle);
		//End Puzzle 1
		
		ArrayList<String> options2 = new ArrayList<String>();
		LinkedHashMap<Character, String> responses2 = new LinkedHashMap<Character, String>();
		
		//Puzzle 2
		options2.add("a. Twist the wires together to complete the circuit.");
		options2.add("b. Use an old nail on the floor to short the wires.");
		options2.add("c. Continue forward with no light.");
		options2.add("d. Turn back and hope to find another way.");
		
		responses2.put('a', "You've been shocked!");
		responses2.put('b', "You've been shocked!");
		responses2.put('c', "You trip and scrape your knee! It's impossible to navigate!");
		responses2.put('d', "As you turn around, a quick reflection catches your eye. "
				+ "You look closer and see a flashlight lying on the floor. Puzzle solved!");
		
		tempPuzzle = new Puzzle("PUZ002", "2", "The room ahead is pitch black, and impossible to "
				+ "navigate. You see what used to be a light switch, but the cover is ripped "
				+ "from the wall and the wires exposed. Faced with such a circumstance, there "
				+ "is no shame in retreating for more information. But perhaps there is "
				+ "something here to help…", 'd', '\0',
				'\0', '\0', '\0', '\0', new Character[] {'d'}, new Character[] {'a', 'b', 'c'}, 
				options2, responses2, false);
		puzzles.put(tempPuzzle.getPuzzleID(), tempPuzzle);
		//End Puzzle 2
		
		ArrayList<String> options3 = new ArrayList<String>();
		LinkedHashMap<Character, String> responses3 = new LinkedHashMap<Character, String>();
		
		//Puzzle 3
		options3.add("a. Charge the zombie!");
		options3.add("b. Try and sneak into a nearby room.");
		options3.add("c. Stand perfectly still and hope the zombie doesn’t see you.");
		options3.add("d. Quietly walk back to the last room.");
		
		responses3.put('a', "Fighting dead people is harder than it sounds, and the zombie "
				+ "manages to inflict a pretty nasty wound. Puzzle solved!");
		responses3.put('b', "The door is locked, and the zombie hears you're struggling with the "
				+ "handle! He attacks! Fortunately, he isn’t too strong and you manage to put "
				+ "him back to rest with only minor scratches. Puzzle solved!");
		responses3.put('c', "You stand still and hold your breath, heart pounding as the zombie "
				+ "shuffles past you. Right as he passes, you knock him over the head. Puzzle solved!");
		responses3.put('d', "You return to the previous room.");
		
		tempPuzzle = new Puzzle("PUZ003", "3", "As you approach the next room, you hear a "
				+ "grumble and a shuffle from around the corner. You retreat back, and a "
				+ "zombie comes around, shuffling dead-eyed down the hall towards you. You "
				+ "know that there are two things that zombies are sensitive towards – "
				+ "noise, and blunt objects to the skull.", 'd', '\0',
				'\0', '\0', '\0', 'a', new Character[] {'a', 'b', 'c'}, new Character[] {'b'}, 
				options3, responses3, false);
		puzzles.put(tempPuzzle.getPuzzleID(), tempPuzzle);		
		//End Puzzle 3
		
		ArrayList<String> options4 = new ArrayList<String>();
		LinkedHashMap<Character, String> responses4 = new LinkedHashMap<Character, String>();
		
		//Puzzle 4
		options4.add("a. Slip the suit on, perhaps it could come in handy later?");
		options4.add("b. Drop any other armor you are carrying and pick the suit up.");
		options4.add("c. Leave the suit behind, it looks useless.");
		options4.add("d. This room doesn’t look like anything you want a part of. Turn back.");
		
		responses4.put('a', "Equipped Obamacare, +1 to armor. Any armor currently wearing is dropped. Puzzle solved.");
		responses4.put('b', "Obamacare in inventory, lose any other armor currently holding. Puzzle solved.");
		responses4.put('c', "Puzzle solved.");
		responses4.put('d', "d. Return to previous room.");
		
		tempPuzzle = new Puzzle("PUZ004", "4", "You come across a room marked “Public Health Care Center.” Opening the"
				+ " door, it is all but barren; save for a dirty, hole-ridden HazMat suit. Upon closer investigation, "
				+ "the suit contains a barely legible label reading “Obamacare Issue #23-B.” The suit looks like it would"
				+ " only provide minimal protection, and it will surely fall to pieces if you were to ever try and remove it", 
				'\0', '\0', '\0', '\0', '\0', '\0', new Character[] {'\0'}, new Character[] {'\0'}, options4, responses4, false );
		puzzles.put(tempPuzzle.getPuzzleID(), tempPuzzle);
		//End Puzzle 4
		
		ArrayList<String> options7 = new ArrayList<String>();
		LinkedHashMap<Character, String> responses7 = new LinkedHashMap<Character, String>();
		
		//Puzzle 7
		options7.add("a. Attempt to type in the password.");
		options7.add("b. Search for another way.");
		
		responses7.put('a', "'PASSWORD:_' shows on the computer screen. (Type 'back' to go back)");
		responses7.put('b', "You returned to the previous room.");
		
		tempPuzzle = new Puzzle("PUZ007", "7", "You come across a locked door. Next to the "
				+ "frame lies a dusty password keyboard. What do you do?", 'b', '\0', '\0', '\0',
				'a', '\0', new Character[] {'a'}, new Character[] {'\0'}, options7, responses7, false);
		puzzles.put(tempPuzzle.getPuzzleID(), tempPuzzle);
		//End Puzzle 7
		
		return puzzles;
	}
	
	
}
