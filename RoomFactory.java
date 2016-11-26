import java.util.HashMap;
import java.util.LinkedHashMap;

/**Class: RoomFactory
 * @author Janna Timmer, Matthew Nelson, Matthew Xiong
 * @version 1.0
 * Course: ITEC 3860 Fall 2016
 * Written: Nov 20, 2016
 * 
 *
 * This class creates and collects Room objects.
 *
 * Purpose: To organize Room creation into a separate class.
 */

public class RoomFactory
{
	private static HashMap<String, Room> rooms ;
	private static HashMap<String, Artifact> artifacts;
	private static HashMap<String, Zombie> zombies;

	/**getRooms
	 * Creates and returns all the rooms in the game.
	 * @return rooms All rooms in the game.
	 */
	public static HashMap<String, Room> getRooms()
	{
		PuzzleFactory pf = new PuzzleFactory();
		ArtifactFactory af = new ArtifactFactory();
		rooms = new LinkedHashMap<String, Room>();

		Room tempRoom;
		/* Constructor 
		 * String roomID, String description, Map<String, Room> exitIDs, boolean saveableRoom
		 */
		tempRoom = new Room("L1001", 
				"You wake up on the floor of a hospital room. It’s quiet for a hospital. "
				+ "\nThe nurse call button seems to be broken, and none of the machines"
				+ " \nin the room have power.", true);
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L1002", 
				"Out in the hallway, the hospital looks abandoned. You think \"Have the "
				+ "\nnurses gone on strike?\" You wander around and find the reception desk. "
				+ "\nYou discover some whiskey hidden inside.", false, af.getAllArtifacts().get("Whiskey"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L1003", 
				"Down the hallway you go. You can hear moans coming from some rooms, "
				+ "\nbut cannot see anything through the windows in the doors. A cold "
				+ "\ndraft sets over you.", false, pf.getPuzzles().get("PUZ001"), af.getAllArtifacts().get("Crowbar"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L1004",
				"Moving forward, you head to the Cafeteria. You walk to the McDonald’s and look "
				+ "\naround for food, but everything needs to be microwaved, and the microwave has "
				+ "\nno power. You hear some banging around in the freezer and try to open it,"
				+ "\nbut the door won’t budge.", false);
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L1005",
				"This is the waiting area. People would normally wait here for a check-up. "
				+ "\nAll the chairs have been wrecked. Blood has been splattered everywhere, and the"
				+ "\nstench is overwhelming. You think, \"Can’t believe I miss that old hospital smell.\"", 
				false, ZombieFactory.getAllZombies().get("M08"),af.getAllArtifacts().get("Mixtape"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L1006",
				"The entrance to this hospital is on your right, but it is blocked off. "
				+ "\nThere is a trail of blood that goes to the door north of you. A sign "
				+ "\nthat says E.R. above the door west of you is flashing.", false);
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L1007",
				"This room is where doctors like to give patients bad news. It’s painted "
				+ "\na sky blue and has inspirational posters. It’s more of an office. You hear "
				+ "\nsome eating noises from behind the doctor’s desk. When you enter to see who "
				+ "\nis eating what, you find a zombie eating the doctor’s brains. Then the "
				+ "\nzombie stops. There is a silence as time slows down and the patient zombie "
				+ "\nlooks dead at you.", false, ZombieFactory.getAllZombies().get("M01"),null);
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L1008","",
				false, pf.getPuzzles().get("PUZ002"),af.getAllArtifacts().get("Flashlight"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L1009","This is the waiting area for the E.R. which is just as destroyed as "
				+ "\nthe last waiting room. There's a first-aid kit lying in the midst of a broken desk.", 
				false, af.getAllArtifacts().get("First-Aid Kit"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L1010",
				"There are headphones on the ground next to your feet. And that humming was "
				+ "\ncoming from the possibly tone deaf Janitor Zombie! The floors are being"
				+ "\nmopped with blood and body parts by the Janitor Zombie. You think \"I’ve "
				+ "\nheard of working over-time but not working after-death\"...", 
				true,ZombieFactory.getAllZombies().get("M02") ,af.getAllArtifacts().get("Mop Handle"));
		rooms.put(tempRoom.getRoomID(), tempRoom);

		tempRoom = new Room("L2001",
				"Fresh air assaults your nostrils."
				+ " \nYou feel comfort for the first time since this ordeal began."
				+ " \nYou look around the Hospital courtyard. Wheelchairs lay abandoned."
				+ " \nThe sense of calm that had begun to settle over you is broken.", true,
				af.getAllArtifacts().get("First-Aid Kit"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L2002",
				"You come across a large tree. In any other setting you would think "
				+ "\nthis tree in the middle of a grassy field odd. However, now you "
				+ "\nare just glad to find a place to rest. You begin to climb the tree "
				+ "\nwhen out falls a woman in a nurse’s uniform. She attacks.",
				false,ZombieFactory.getAllZombies().get("M03"),af.getAllArtifacts().get("Syringe"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L2003",
				"You run as far as you can, your body still cold from the "
				+ "\nencounter. You take a moment to rest before pressing on.", false);
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L2004",""/*"Puzzle Text will display itself."*/, false, pf.getPuzzles().get("PUZ003"), null);
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L2005","The grass here is wet with dew."
				+ "\n\"Odd\" you think to yourself, as it is the middle of the day."
				+ "\nIt is only after looking down you notice that it is not dew, but blood "
				+ "\nlittering the ground. Something horrible waits ahead."
				+ "\nYou attempt to continue your southward progress."
				+ "\nHowever, you know you can’t leave without looking for further survivors.",
				false,af.getAllArtifacts().get("First-Aid Kit"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L2006",
				"You come across a cement wall. The words \"There is no hope\" "
				+ "\nare written in blood on its otherwise unblemished surface."
				+ "\n\"Damn kids,\" you think to yourself.", false);
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L2007", "", false, pf.getPuzzles().get("PUZ004"),
				af.getAllArtifacts().get("Obamacare Armor"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L2008","You are starting to get annoyed with how this hospital is laid out."
				+ " \nWhat would happen if there had been an emergency?"
				+ " \nDid they really expect someone to solve puzzles to get from building to building?", false);
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L2009",
				"As you enter, you trip over another first-aid kit."
				+ "\nThe smell of rotting flesh once again overwhelms you. The ground"
				+ "\nis muddy with blood. Entrails hang from the edges of the building."
				+ "\nLimbs lay in odd configurations in front of you. You know that "
				+ "\nnothing good awaits ahead. You start to ponder why you hadn't "
				+ "\ntaken your mother's advice and moved to Canada. These kinds of "
				+ "\nthings never happen in Canada.", false,af.getAllArtifacts().get("First-Aid Kit"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L2010",
				"You move toward the end of the courtyard. You see someone, a doctor, "
				+ "\nbent over a dead body. You allow yourself to think that you had "
				+ "\nfound an ally. The doctor turns and lunges.", true,ZombieFactory.getAllZombies().get("M04"),
				af.getAllArtifacts().get("Stethoscope"));
		rooms.put(tempRoom.getRoomID(), tempRoom);

		tempRoom = new Room("L3001","After trekking up the stairs you finally reach the third floor of the hospital."
				+ "\nInside the room there is a broken window, a waiting area with strewn chairs and glass,"
				+ "\na reception desk with blood splattered on the counter, and bloody hand/footprints leading to "
				+ "\nthe North door. On the broken window sill, you see another first-aid kit.", true,af.getAllArtifacts().get("First-Aid Kit"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L3002","The room is covered in blood, the ceiling is crumbling and"
				+ "\nthere is one mobile metal patient bed that has been torn apart.", false,
				ZombieFactory.getAllZombies().get("M05"),af.getAllArtifacts().get("Scalpel"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L3003","This room was the operating room for the plastic surgeon, there is "
				+ "\nan operating table in the middle of the room covered in blood, human skin, "
				+ "\nand body fluids, and there is a small desk with patient files and pictures, "
				+ "\nscalpels, several jars of lips, a Joan Rivers shrine, and other instruments for surgery.", 
				false, pf.getPuzzles().get("PUZ005"),null);
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L3004","The lights are flickering on and off irregularly, there is a human brain"
				+ "\nin the middle of the room and all around the brain are blood, bent scalpels, "
				+ "\na broken drill, and bloody hand prints. "
				+ "\nThe room looks like remnants of a waiting room, the chairs are stacked to the ceiling, "
				+ "\nand the small check-in desk is broken in half. In between the broken desk fragments, "
				+ "\nyou see what looks to be a first-aid kit.", false,af.getAllArtifacts().get("First-Aid Kit"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L3005","This area is the surgeon's operating room. There is a broken operating "
				+ "\ntable leaning against the wall. The floor is sticky and covered in blood. The smell "
				+ "\nis unbearable. The door to the east has a strange bloody insignia on it reminiscent "
				+ "\nof a skull.", false,ZombieFactory.getAllZombies().get("M06"),af.getAllArtifacts().get("Bone Saw"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L3006","This room is mostly dark with a dimly lit small lamp in the far right"
				+ "\nof the room. The floor is still sticky. Once your eyes adjust, you can make out "
				+ "\nthe shapes of old filing cabinets, extra medical supplies, bandages, strewn pills,"
				+ "\nmore jars with unidentifiable human parts, and more blood than you have seen "
				+ "\nanywhere else in the hospital. You notice a note on top of one of the filing cabinets.", 
				false, af.getAllArtifacts().get("Note"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L3007",
				"The room is very dark. You step in some liquid and feel around with your foot,"
				+ "\nnoticing a narrow trail leading to the west.", false, pf.getPuzzles().get("PUZ006"),null);
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L3008","When entering, the overwhelming smell of flesh and blood makes you "
				+ "\nwretch, this room looks like the burn unit. There are bloody rags and bandages "
				+ "\ncovering the floors, and corpses lie still on stretchers. The amount of light in "
				+ "\nthis room in contrast with the previous rooms makes your eyes constrict painfully."
				+ "\nYou see a first-aid kit lying partially underneath one of the corpses.", false, 
				af.getAllArtifacts().get("First-Aid Kit"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L3009",
				"This room has a few chairs against the north wall and a large counter that "
				+ "\nstretches across the south wall. It looks like a room for blood work and other "
				+ "\nmedical samples. On the counter are glass and plastic vials, stands, cotton swabs, "
				+ "\nbandages, forms, chemical tester strips, and another first-aid kit.", true, 
				pf.getPuzzles().get("PUZ007"),af.getAllArtifacts().get("First-Aid Kit"));
		rooms.put(tempRoom.getRoomID(), tempRoom);
		tempRoom = new Room("L3010","There is a spotlight on the west wall with a broken window. There"
				+ "\nis a message written in blood on the walls. You make out: \"Death will consume you, "
				+ "\nlight goes dark. The only way out is through.\"", true,
				ZombieFactory.getAllZombies().get("M07"), null);
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