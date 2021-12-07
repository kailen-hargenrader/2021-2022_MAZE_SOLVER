package maze;

/**
 * Implements the @MazeBuilder abstract
 * @author monke
 *
 */
public class MazeBuilderImplementation implements MazeBuilder{

	@Override
	public Room createRoom(String longDescription, String shortDescription) {
		if(longDescription == null || shortDescription == null) throw new NullPointerException("Descriptions cannot be null");
		return new ImplementedRoom(longDescription, shortDescription, false);
	}

	@Override
	public Room createExit(String longDescription, String shortDescription) {
		if(longDescription == null || shortDescription == null) throw new NullPointerException("Descriptions cannot be null");
		return new ImplementedRoom(longDescription, shortDescription, true);
	}

	@Override
	public MazeBuilder addPassage(Room room0, Room room1) {
		if(room0 == null || room1 == null) throw new NullPointerException("rooms cannot be null");
		addOneWayPassage(room1, room0);
		addOneWayPassage(room0, room1);
		return this;
	}

	@Override
	public MazeBuilder addOneWayPassage(Room fromRoom, Room toRoom) {
		if(fromRoom == null || toRoom == null) throw new NullPointerException("Rooms cannot be null");
		fromRoom.addRooms(toRoom);
		return this;
	}

}
