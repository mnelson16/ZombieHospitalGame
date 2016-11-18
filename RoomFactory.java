import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RoomFactory
	{
		private static HashMap<String, Room> rooms ;
		
		public static HashMap<String, Room> getRooms()
		{
			PuzzleFactory pf = new PuzzleFactory();
			rooms = new LinkedHashMap<String, Room>();
			Room tempRoom;
			/* Constructor 
			 * String roomID, String description, Map<String, Room> exitIDs, boolean saveableRoom
			 */
			tempRoom = new Room("L1001","You wake up on the floor of a hospital room. It’s quiet for"
					+ " a hospital. The nurse call button seems to be broken, but all of the machines"
					+ " in the room have no power.", true);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1002","Out in the hallway the hospital looks abandoned. You think "
					+ "'Have the nurses gone on strike?' You wander around and finds the reception "
					+ "desk which contains a healing item.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1003", "Down the hallway you go. You can hear moans coming from "
					+ "some rooms, but cannot see anything through the windows in the doors. A cold "
					+ "draft sets over you.", false, pf.getPuzzles().get("PUZ001"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1004","Moving forward you goes to the Cafeteria. You go to the McDonald’s"
					+ " and looks around for food. But everything needs to be microwaved and the microwave "
					+ "has no power. You try to open the freezer because there is banging around in there, "
					+ "but the door won’t budge.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1005","This is the waiting area. People would normally wait here for a "
					+ "check-up. All the chairs have been wrecked. Blood was splattered everywhere and the"
					+ " stench is overwhelming. You think ‘Can’t believe I miss that old hospital smell.’", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1006","The entrance to this hospital is on your right, but it is blocked "
					+ "off. There is a trail of blood that goes to the door north of you. And a sign that says "
					+ "E.R. above the door west of you is flashing.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1007","This room is where doctors like to give patients bad news. "
					+ "It’s painted a sky blue and has inspirational posters. It’s more of an office. "
					+ "You hear some eating noises from behind the doctor’s desk. When you enter to see "
					+ "who is eating what, you find a zombie eating the doctor’s brains. Then the zombie"
					+ " stops. There is a silence as time slows down and the patient zombie looks dead "
					+ "at you.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1008","This room is still dark, but you can see an old nail on the floor.",
					false, pf.getPuzzles().get("PUZ002"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1009","This is the waiting area for the E.R. which is just as destroyed as "
					+ "the last waiting room.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1010","There are headphones on the ground next to the Player’s feet."
					+ " And that humming was coming from the possibly tone deaf Janitor Zombie!"
					+ " The floors are being mopped with blood and body parts by the Janitor Zombie."
					+ " The Player thinks “I’ve heard of working over-time but not working after-death”..", true);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			
			tempRoom = new Room("L2001","Fresh air assaults your nostrils."
					+ " You feel comfort for the first time since this ordeal began."
					+ " You look around the Hospital courtyard. Wheelchairs lay abandoned."
					+ " The sense of calm that had begun to settle over you is broken.", true);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2002","You come across a large tree."
					+ " In any other setting you would think this tree in the middle of a grassy field odd."
					+ " However now you are just glad to find a place to rest."
					+ " You begin to climb the tree when out falls a woman in a nurse’s uniform. She attacks.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2003","You run as far as you can."
					+ " Your body still cold from the encounter."
					+ " You take a moment to rest before pressing on.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2004","Puzzle Text will display itself.", false, pf.getPuzzles().get("PUZ003"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2005","The grass here is wet with dew."
					+ " “Odd” you think to yourself as it is the middle of the day."
					+ " It is only after looking down you notice that it is not dew but blood littering the ground."
					+ " Something horrible waits ahead."
					+ " You attempt to continue your southward progress."
					+ " However, you know you can’t leave without looking for further survivors.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2006","You come across a cement wall."
					+ " The words “There is no hope” are written in blood on its otherwise unblemished surface."
					+ " “Damn kids” you think to yourself.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2007","Puzzle text will display itself", false, pf.getPuzzles().get("PUZ004"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2008","You are starting to get annoyed with how this hospital is laid out."
					+ " What would happen if there had been an emergency?"
					+ " Did they really expect someone to solve puzzles to get from building to building?", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2009","The smell of rotting flesh once again overwhelms you."
					+ " The ground is muddy with blood."
					+ " Entrails hang from the edges of the building."
					+ " Limbs lay in odd configurations in front of you."
					+ " You know that once nothing good awaits ahead."
					+ " You start to ponder why you hadn't taken your mother's advice and moved to Canada."
					+ " These kinds of things never happen in Canada.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2010","You move toward the end of the courtyard."
					+ " You see someone, a doctor, bent over a dead body."
					+ " You allow yourself to think that you had found an ally."
					+ " The doctor turns and lunges.", true);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			
			tempRoom = new Room("L3001","After trekking up the stairs you finally reach the third floor of the hospital."
					+ " Inside the room there is a broken window, a waiting area with strewn chairs and glass,"
					+ " a reception desk with blood splattered on the counter, and bloody hand/footprints leading to the North door. "
					+ "On the broken window sill the player can find a healing item.", true);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3002","Upon entering the player is attacked by a Plastic Surgeon Zombie, "
					+ "this Zombie will drop a scalpel that the player can pick up. "
					+ "The room is covered in blood, the ceiling is crumbling and"
					+ " there is one mobile metal patient bed that has been torn apart.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3003","Upon entering the room a puzzle dialog will pop up,"
					+ " the player will have to solve it to continue. "
					+ "This room was the operating room for the plastic surgeon, there is an operating table in the middle of the room covered in blood, human skin, and body fluids, "
					+ "and there is a small desk with patient files and pictures, scalpels, several jars of lips, "
					+ "A Joan Rivers shrine, and other instruments for surgery.", false, pf.getPuzzles().get("PUZ005"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3004","The lights are flickering on and off irregularly, there is a human brain in the middle of the room and all around the brain are blood, bent scalpels, a broken drill, and bloody hand prints. "
					+ "The room looks like remnants of a waiting room, the chairs are stacked to the ceiling, and the small check-in desk is broken in half. "
					+ "In between the broken desk fragments the player can find a healing item.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3005","Upon entering the player is attacked by a Brain Surgeon Zombie. "
					+ "The brain surgeon zombie will drop a bone saw and a bloody note. This area is the surgeon's operating room, there is a broken operating table leaning against the wall. "
					+ "The floor is sticky and covered in. The smell is unbearable."
					+ " The door to the east has a strange bloody insignia on it reminiscent of a skull.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3006","This room is mostly dark with a dimly lit small lamp in the far right of the room. "
					+ "The floor is still sticky. Once your eyes adjust you can make out the shapes of old filing cabinets, extra medical supplies, bandages, strewn pills, more jars with unidentifiable human parts, "
					+ "and more blood than you have seen anywhere else in the hospital. "
					+ "There is a health item the player can pick up when looking at the pills.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3007","Upon entering the room a puzzle dialog will pop up, "
					+ "the player will have to solve it to continue. The room is very dark,"
					+ " you step in some liquid feel around with your foot and notice a narrow "
					+ "trail leading to the west.", false, pf.getPuzzles().get("PUZ006"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3008","When entering the overwhelming smell of flesh and blood makes you wretch, this room looks like the burn unit. "
					+ "There are bloody rags and bandages covering the floors and corpses lie still on stretchers. "
					+ "The amount of light in this room in contrast with the previous rooms makes your eyes constrict painfully.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3009","Upon entering the room a puzzle dialog will pop up; "
					+ "the player will have to solve it to continue. "
					+ "The note from the Brain Surgeon Zombie is the solution to this puzzle, "
					+ "this room has a few chairs against the north wall and a large counter that stretches across the south wall,"
					+ " and it looks like a room for blood work and other medical samples. On the counter are glass and plastic vials, "
					+ "stands, cotton swabs, bandages, forms, chemical tester strips, and a health item.", true, pf.getPuzzles().get("PUZ007"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3010","Upon entering the room you are attacked by a Surgeon General Zombie. "
					+ "There is a spotlight on the west wall with a broken window, there is a message written in blood on the walls, "
					+ "you make out: Death will consume you, light goes dark. The only way out is through.", true);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			
			rooms.get("L1001").setExits(rooms.get("L1002"), null, null, null);
			rooms.get("L1002").setExits(null, null, rooms.get("L1001"), rooms.get("L1003"));
			rooms.get("L1003").setExits(null, rooms.get("L1002"), null, rooms.get("L1004"));
			rooms.get("L1004").setExits(null, rooms.get("L1003"), null, rooms.get("L1005"));
			rooms.get("L1005").setExits(null, rooms.get("L1004"), rooms.get("L1006"), null);
			rooms.get("L1006").setExits(rooms.get("L1005"), rooms.get("L1009"), rooms.get("L1007"), null);
			rooms.get("L1007").setExits(rooms.get("L1006"), rooms.get("L1008"), null, null);
			rooms.get("L1008").setExits(rooms.get("L1009"), null, null, rooms.get("L1007"));
			rooms.get("L1009").setExits(null, rooms.get("L1010"), rooms.get("L1008"), rooms.get("L1006"));
			rooms.get("L1010").setExits(null, null, rooms.get("L2001"), rooms.get("L1009"));
			
			rooms.get("L2001").setExits(rooms.get("L1010"), null, rooms.get("L2002"), null);
			rooms.get("L2002").setExits(rooms.get("L2001"), null, rooms.get("L2003"), null);
			rooms.get("L2003").setExits(rooms.get("L2002"), null, rooms.get("L2004"), null);
			rooms.get("L2004").setExits(rooms.get("L2003"), null, rooms.get("L2005"), null);
			rooms.get("L2005").setExits(rooms.get("L2004"), rooms.get("L2006"), null, null);
			rooms.get("L2006").setExits(rooms.get("L2007"), null, null, rooms.get("L2005"));
			rooms.get("L2007").setExits(rooms.get("L2008"), null, rooms.get("L2006"), null);
			rooms.get("L2008").setExits(rooms.get("L2009"), null, rooms.get("L2007"), null);
			rooms.get("L2009").setExits(rooms.get("L2010"), null, rooms.get("L2008"), null);
			rooms.get("L2010").setExits(rooms.get("L3001"), null, rooms.get("L2009"), null);
			
			rooms.get("L3001").setExits(rooms.get("L3004"), null, rooms.get("L2010"), rooms.get("L3002"));
			rooms.get("L3002").setExits(rooms.get("L3003"), rooms.get("L3001"), null, null);
			rooms.get("L3003").setExits(null, rooms.get("L3004"), rooms.get("L3002"), null);
			rooms.get("L3004").setExits(null, rooms.get("L3005"), rooms.get("L3001"), rooms.get("L3003"));
			rooms.get("L3005").setExits(null, rooms.get("L3006"), null, rooms.get("L3004"));
			rooms.get("L3006").setExits(rooms.get("L3007"), null, null, rooms.get("L3005"));
			rooms.get("L3007").setExits(null, null, rooms.get("L3006"), rooms.get("L3008"));
			rooms.get("L3008").setExits(null, rooms.get("L3007"), null, rooms.get("L3009"));
			rooms.get("L3009").setExits(null, rooms.get("L3008"), null, rooms.get("L3010"));
			rooms.get("L3010").setExits(null, rooms.get("L3009"), null, null);
			
		return rooms;
		}
	}
