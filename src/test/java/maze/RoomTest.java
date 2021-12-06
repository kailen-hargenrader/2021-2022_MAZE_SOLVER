package maze;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import config.Configuration;

public class RoomTest {

	private ImplementedRoom room;

	@Before
	public void setup() {
		room = Configuration.getRoom();
		if (room == null)
			fail("You seem to have forgotten to set which builder to use in the Configuraiton.getMazeBuilder method.");
		if (room == Configuration.getRoom())
			fail("You should return a new instance of MazeBuilder when Configuration.getMazeBuilder() is called.");
	}

	@Test(timeout = 50)
	public void testGetLongDescription() {
		assertEquals("Long", room.getFullDescription());
	}
	
	@Test(timeout = 50)
	public void testGetShortDescription() {
		assertEquals("Short", room.getShortDescription());
	}
	
	@Test(timeout = 50)
	public void testIsExit() {
		assertFalse(room.isExit());
	}

	@Test(timeout = 50)
	public void testgetRooms() {
		assertEquals(0, room.getRooms().size());
	}
	
	@Test(timeout = 50)
	public void testAddRoom() {
		room.addRooms(new ImplementedRoom());
		assertEquals(1, room.getRooms().size());
	}
}

