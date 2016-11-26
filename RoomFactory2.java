import java.util.HashMap;
import java.util.LinkedHashMap;

public class RoomFactory
	{
		private static HashMap<String, Room> rooms ;
		private static HashMap<String, Artifact> artifacts;
		private static HashMap<String, Zombie> zombies;
		
		public static HashMap<String, Room> getRooms()
		{
			PuzzleFactory pf = new PuzzleFactory();
			ArtifactFactory af = new ArtifactFactory();
			ZombieFactory zf = new ZombieFactory();
			rooms = new LinkedHashMap<String, Room>();
			
			Room tempRoom;
			/* Constructor 
			 * String roomID, String description, Map<String, Room> exitIDs, boolean saveableRoom
			 */
			tempRoom = new Room("L1001","You wake up on the floor of a hospital room. It’s quiet for"
					+ " \na hospital. The nurse call button seems to be broken, but all of the machines"
					+ " \nin the room have no power.", true);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1002","Out in the hallway the hospital looks abandoned. You think "
					+ "\n'Have the nurses gone on strike?' You wander around and finds the reception "
					+ "\ndesk which contains a healing item.", false, af.getAllArtifacts().get("First-Aid Kit"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1003", "Down the hallway you go. You can hear moans coming from "
					+ "\nsome rooms, but cannot see anything through the windows in the doors. A cold "
					+ "\ndraft sets over you.", false, pf.getPuzzles().get("PUZ001"), af.getAllArtifacts().get("Crowbar"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1004","Moving forward you go to the Cafeteria. You go to the McDonald’s"
					+ "\nand looks around for food. But everything needs to be microwaved and the microwave "
					+ "\nhas no power. You try to open the freezer because there is banging around in there, "
					+ "\nbut the door won’t budge.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1005","This is the waiting area. People would normally wait here for a "
					+ "\ncheck-up. All the chairs have been wrecked. Blood was splattered everywhere and the"
					+ "\nstench is overwhelming. You think ‘Can’t believe I miss that old hospital smell.’", false, zf.getAllZombies().get("MO8"),af.getAllArtifacts().get("Mixtape"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1006","The entrance to this hospital is on your right, but it is blocked "
					+ "\noff. There is a trail of blood that goes to the door north of you. And a sign that says "
					+ "\nE.R. above the door west of you is flashing.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1007","This room is where doctors like to give patients bad news. "
					+ "\nIt’s painted a sky blue and has inspirational posters. It’s more of an office. "
					+ "\nYou hear some eating noises from behind the doctor’s desk. When you enter to see "
					+ "\nwho is eating what, you find a zombie eating the doctor’s brains. Then the zombie"
					+ " \nstops. There is a silence as time slows down and the patient zombie looks dead "
					+ "\nat you.", false,zf.getAllZombies().get("MO1"),null);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1008","This room is still dark, but you can see an old nail on the floor.",
					false, pf.getPuzzles().get("PUZ002"),af.getAllArtifacts().get("Flashlight" + "Old Nail"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1009","This is the waiting area for the E.R. which is just as destroyed as "
					+ "\nthe last waiting room.", false, af.getAllArtifacts().get("First-Aid Kit"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L1010","There are headphones on the ground next to the Player’s feet."
					+ " \nAnd that humming was coming from the possibly tone deaf Janitor Zombie!"
					+ " \nThe floors are being mopped with blood and body parts by the Janitor Zombie."
					+ " \nYou think to yourself “I’ve heard of working over-time but not working after-death”..", true,zf.getAllZombies().get("MO2") ,af.getAllArtifacts().get("Mop Handle"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			
			tempRoom = new Room("L2001","Fresh air assaults your nostrils."
					+ " \nYou feel comfort for the first time since this ordeal began."
					+ " \nYou look around the Hospital courtyard. Wheelchairs lay abandoned."
					+ " \nThe sense of calm that had begun to settle over you is broken.", true,af.getAllArtifacts().get("First-Aid Kit"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2002","You come across a large tree."
					+ " \nIn any other setting you would think this tree in the middle of a grassy field odd."
					+ " \nHowever now you are just glad to find a place to rest."
					+ " \nYou begin to climb the tree when out falls a woman in a nurse’s uniform. She attacks.", false,zf.getAllZombies().get("MO3"),af.getAllArtifacts().get("Syringe"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2003","You run as far as you can."
					+ " \nYour body still cold from the encounter."
					+ " \nYou take a moment to rest before pressing on.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2004","You enter the hallway.", false, pf.getPuzzles().get("PUZ003"), null);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2005","The grass here is wet with dew."
					+ " \n“Odd” you think to yourself as it is the middle of the day."
					+ " \nIt is only after looking down you notice that it is not dew but blood littering the ground."
					+ " \nSomething horrible waits ahead."
					+ " \nYou attempt to continue your southward progress."
					+ " \nHowever, you know you can’t leave without looking for further survivors.", false,af.getAllArtifacts().get("First-Aid Kit"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2006","You come across a cement wall."
					+ " \nThe words “There is no hope” are written in blood on its otherwise unblemished surface."
					+ "\n“Damn kids” you think to yourself.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2007","Moving forward,", false, pf.getPuzzles().get("PUZ004"), af.getAllArtifacts().get("Obamacare Armor"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2008","You are starting to get annoyed with how this hospital is laid out."
					+ " \nWhat would happen if there had been an emergency?"
					+ " \nDid they really expect someone to solve puzzles to get from building to building?", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2009","The smell of rotting flesh once again overwhelms you."
					+ " \nThe ground is muddy with blood."
					+ " \nEntrails hang from the edges of the building."
					+ " \nLimbs lay in odd configurations in front of you."
					+ " \nYou know that once nothing good awaits ahead."
					+ " \nYou start to ponder why you hadn't taken your mother's advice and moved to Canada."
					+ " \nThese kinds of things never happen in Canada.", false,af.getAllArtifacts().get("First-Aid Kit"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L2010","You move toward the end of the courtyard."
					+ " \nYou see someone, a doctor, bent over a dead body."
					+ " \nYou allow yourself to think that you had found an ally."
					+ " \nThe doctor turns and lunges.", true,zf.getAllZombies().get("MO4"),af.getAllArtifacts().get("Stethoscope"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			
			tempRoom = new Room("L3001","After trekking up the stairs you finally reach the third floor of the hospital."
					+ " \nInside the room there is a broken window, a waiting area with strewn chairs and glass,"
					+ " \na reception desk with blood splattered on the counter, and bloody hand/footprints leading to the North door. "
					+ "\nOn the broken window sill the player can find a healing item.", true,af.getAllArtifacts().get("First-Aid Kit"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3002", "The room is covered in blood, the ceiling is crumbling and"
					+ "\nthere is one mobile metal patient bed that has been torn apart."
					+ "As you approach the bed, somthing luncges for your feet, but you were able to jumpo back in time.", false,zf.getAllZombies().get("MO5"),af.getAllArtifacts().get("Scalpel"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3003", "This room was the operating room for the plastic surgeon, there is an operating table in the middle of the room covered in blood, human skin, and body fluids, "
					+ "\nand there is a small desk with patient files and pictures, scalpels, several jars of lips, "
					+ "\nA Joan Rivers shrine, and other instruments for surgery.", false, pf.getPuzzles().get("PUZ005"),null);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3004","The lights are flickering on and off irregularly, there is a human brain in the middle of the room and all around the brain are blood, bent scalpels, a broken drill, and bloody hand prints. "
					+ "\nThe room looks like remnants of a waiting room, the chairs are stacked to the ceiling, and the small check-in desk is broken in half. "
					, false,af.getAllArtifacts().get("First-Aid Kit"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3005","This area is the surgeon's operating room, there is a broken operating table leaning against the wall. "
					+ "\nThe floor is sticky and covered in. The smell is unbearable."
					+ "\nThe door to the east has a strange bloody insignia on it reminiscent of a skull.", false,zf.getAllZombies().get("MO6"),af.getAllArtifacts().get("Bone Saw" + "Random Note"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3006","This room is mostly dark with a dimly lit small lamp in the far right of the room. "
					+ "\nThe floor is still sticky. Once your eyes adjust you can make out the shapes of old filing cabinets, extra medical supplies, bandages, strewn pills, more jars with unidentifiable human parts, "
					+ "\nand more blood than you have seen anywhere else in the hospital. ", false,af.getAllArtifacts().get("First-Aid Kit"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3007","The room is very dark,"
					+ "\nyou step in some liquid feel around with your foot and notice a narrow "
					+ "\ntrail leading to the west.", false, pf.getPuzzles().get("PUZ006"),null);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3008","When entering the overwhelming smell of flesh and blood makes you wretch, this room looks like the burn unit. "
					+ "\nThere are bloody rags and bandages covering the floors and corpses lie still on stretchers. "
					+ "\nThe amount of light in this room in contrast with the previous rooms makes your eyes constrict painfully.", false);
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3009",
					 "This room has a few chairs against the north wall and a large counter that stretches across the south wall,"
					+ "\nand it looks like a room for blood work and other medical samples. On the counter are glass and plastic vials, "
					+ "\nstands, cotton swabs, bandages, forms, chemical tester strips, and a health item.", true, pf.getPuzzles().get("PUZ007"),af.getAllArtifacts().get("First-Aid Kit"));
			rooms.put(tempRoom.getRoomID(), tempRoom);
			tempRoom = new Room("L3010", "There is a spotlight on the west wall with a broken window, there is a message written in blood on the walls, "
					+ "\nyou make out: Death will consume you, light goes dark. The only way out is through.", true,zf.getAllZombies().get("MO7"), null);
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