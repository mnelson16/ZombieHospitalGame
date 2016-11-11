import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RoomFactory
	{
		private static HashMap<String, Room> rooms ;
		public HashMap<String, Room> getRooms()
		{
			rooms = new LinkedHashMap<String, Room>();
			Room tempRoom;
			/* Constructor 
			 * String roomID, String description, Map<String, Room> exitIDs, boolean saveableRoom
			 */
			tempRoom = new Room("L1001","The Player wakes up on the floor of a hospital room."
					+ " It’s quite for a hospital. The nurse call button seems to be broken, "
					+ "but all of the machines in the room have no power.", rooms, true);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1002","Out in the hallway the hospital looks abandoned. "
					+ "The Player thinks “Have the nurses gone on strike?” "
					+ "The Player wanders around and finds the reception desk which contains a healing item.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1003","Down the hallway the Player goes."
					+ " The Player can hear moans coming from some rooms,"
					+ " but cannot see anything through the windows in the doors."
					+ " A cold draft sets over the Player.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1004","Moving forward the player goes to the Cafeteria."
					+ " The Player goes to the McDonald’s and looks around for food."
					+ " But everything needs to be microwaved and the microwave has no power. "
					+ "The Player tries to open the freezer because, there is banging around in there."
					+ " But the door won’t budge.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1005","This is the waiting area."
					+ " People would normally wait here for a check-up."
					+ " All the chairs have been wrecked. "
					+ "Blood was splattered everywhere and the stench is overwhelming. "
					+ "The Player thinks “Can’t believe I miss that old hospital smell”.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1006","The entrance to this hospital is on the Player’s right, but it is blocked off."
					+ " There is a trail of blood that goes to the door north of the Player."
					+ " And a sign that says E.R. above the door west of the player is flashing.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1007","This room is where doctors like to give patients bad news."
					+ " It’s painted a sky blue and has inspirational posters."
					+ " It’s more of an office."
					+ " The player hears some eating noises from behind the doctor’s desk. "
					+ "When the player venters to see who is eating what, the player finds a zombie eating the doctor’s brains."
					+ " Then the zombie stops. There is a silence as time slows down and the patient zombie looks dead at the Player.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1008","This room is dark."
					+ " But the player can see an old nail on the floor."
					+ " After the puzzle is completed the player sees that it was a doctor break room.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1009","This is the waiting area for the E.R. which is just as destroyed as the last waiting room.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1010","There are headphones on the ground next to the Player’s feet."
					+ " And that humming was coming from the possibly tone deaf Janitor Zombie!"
					+ " The floors are being mopped with blood and body parts by the Janitor Zombie."
					+ " The Player thinks “I’ve heard of working over-time but not working after-death”..", rooms, true);
			
			rooms.put(tempRoom.getRoomID(), tempRoom);
			
			tempRoom = new Room("L2001","Fresh air assaults your nostrils."
					+ " You feel comfort for the first time since this ordeal began."
					+ " You look around the Hospital courtyard. Wheelchairs lay abandoned."
					+ " The sense of calm that had begun to settle over you is broken.", rooms, true);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2002","You come across a large tree."
					+ " In any other setting you would think this tree in the middle of a grassy field odd."
					+ " However now you are just glad to find a place to rest."
					+ " You begin to climb the tree when out falls a woman in a nurse’s uniform. She attacks.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2003","You run as far as you can."
					+ " Your body still cold from the encounter."
					+ " You take a moment to rest before pressing on.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2004","Puzzle Text will display itself.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2005","The grass here is wet with dew."
					+ " “Odd” you think to yourself as it is the middle of the day."
					+ " It is only after looking down you notice that it is not dew but blood littering the ground."
					+ " Something horrible waits ahead."
					+ " You attempt to continue your southward progress."
					+ " However, you know you can’t leave without looking for further survivors.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2006","You come across a cement wall."
					+ " The words “There is no hope” are written in blood on its otherwise unblemished surface."
					+ " “Damn kids” you think to yourself.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2007","Puzzle text will display itself", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2008","You are starting to get annoyed with how this hospital is laid out."
					+ " What would happen if there had been an emergency?"
					+ " Did they really expect someone to solve puzzles to get from building to building?", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2009","The smell of rotting flesh once again overwhelms you."
					+ " The ground is muddy with blood."
					+ " Entrails hang from the edges of the building."
					+ " Limbs lay in odd configurations in front of you."
					+ " You know that once nothing good awaits ahead."
					+ " You start to ponder why you hadn't taken your mother's advice and moved to Canada."
					+ " These kinds of things never happen in Canada.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			
			tempRoom = new Room("L2010","You move toward the end of the courtyard."
					+ " You see someone, a doctor, bent over a dead body."
					+ " You allow yourself to think that you had found an ally."
					+ " The doctor turns and lunges.", rooms, true);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3001","After trekking up the stairs you finally reach the third floor of the hospital."
					+ " Inside the room there is a broken window, a waiting area with strewn chairs and glass,"
					+ " a reception desk with blood splattered on the counter, and bloody hand/footprints leading to the North door. "
					+ "On the broken window sill the player can find a healing item.", rooms, true);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3002","Upon entering the player is attacked by a Plastic Surgeon Zombie, "
					+ "this Zombie will drop a scalpel that the player can pick up. "
					+ "The room is covered in blood, the ceiling is crumbling and"
					+ " there is one mobile metal patient bed that has been torn apart.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3003","Upon entering the room a puzzle dialog will pop up,"
					+ " the player will have to solve it to continue. "
					+ "This room was the operating room for the plastic surgeon, there is an operating table in the middle of the room covered in blood, human skin, and body fluids, "
					+ "and there is a small desk with patient files and pictures, scalpels, several jars of lips, "
					+ "A Joan Rivers shrine, and other instruments for surgery.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3004","The lights are flickering on and off irregularly, there is a human brain in the middle of the room and all around the brain are blood, bent scalpels, a broken drill, and bloody hand prints. "
					+ "The room looks like remnants of a waiting room, the chairs are stacked to the ceiling, and the small check-in desk is broken in half. "
					+ "In between the broken desk fragments the player can find a healing item.", rooms, false);
		
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3005","Upon entering the player is attacked by a Brain Surgeon Zombie. "
					+ "The brain surgeon zombie will drop a bone saw and a bloody note. This area is the surgeon's operating room, there is a broken operating table leaning against the wall. "
					+ "The floor is sticky and covered in. The smell is unbearable."
					+ " The door to the east has a strange bloody insignia on it reminiscent of a skull.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3006","This room is mostly dark with a dimly lit small lamp in the far right of the room. "
					+ "The floor is still sticky. Once your eyes adjust you can make out the shapes of old filing cabinets, extra medical supplies, bandages, strewn pills, more jars with unidentifiable human parts, "
					+ "and more blood than you have seen anywhere else in the hospital. "
					+ "There is a health item the player can pick up when looking at the pills.", rooms, false);
			
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3007","Upon entering the room a puzzle dialog will pop up, "
					+ "the player will have to solve it to continue. The room is very dark,"
					+ " you step in some liquid feel around with your foot and notice a narrow trail leading to the west.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3008","When entering the overwhelming smell of flesh and blood makes you wretch, this room looks like the burn unit. "
					+ "There are bloody rags and bandages covering the floors and corpses lie still on stretchers. "
					+ "The amount of light in this room in contrast with the previous rooms makes your eyes constrict painfully.", rooms, false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3009","Upon entering the room a puzzle dialog will pop up; "
					+ "the player will have to solve it to continue. "
					+ "The note from the Brain Surgeon Zombie is the solution to this puzzle, this room has a few chairs against the north wall and a large counter that stretches across the south wall,"
					+ " and it looks like a room for blood work and other medical samples. On the counter are glass and plastic vials, stands, cotton swabs, bandages, forms, chemical tester strips, and a health item.", rooms, true);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3010","Upon entering the room you are attacked by a Surgeon General Zombie. "
					+ "There is a spotlight on the west wall with a broken window, there is a message written in blood on the walls, "
					+ "you make out: Death will consume you, light goes dark. The only way out is through.", rooms, true);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			
			
		return rooms;
		}
	}