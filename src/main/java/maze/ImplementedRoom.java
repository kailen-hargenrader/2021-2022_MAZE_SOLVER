package maze;

import structure.ListInterface;
import structure.RecursiveLinkedList;
/**
 * Implements room with Long description, Short description, and a boolean for if the room is an exit.
 * @author monke
 *
 */
public class ImplementedRoom implements Room {
	private String Long = new String();
	private String Short = new String();
	private Boolean Exit;
	private RecursiveLinkedList<Room> rooms = new RecursiveLinkedList<Room>();
	/**
	 * If no passed variables, make empty descriptions and make room not an exit.
	 */
	public ImplementedRoom() {
		Long = "";
		Short = "";
		Exit = false;
	}
	/**
	 * initiate Implemented Room with passed variables
	 * @param l the long description
	 * @param s the short description
	 * @param exit if Implemented Room is an exit
	 */
	public ImplementedRoom(String l, String s, Boolean exit) {
		Long = l;
		Short = s;
		Exit = exit;
	}
	@Override
	public String getFullDescription() {
		return Long;
	}

	@Override
	public String getShortDescription() {
		return Short;
	}

	@Override
	public boolean isExit() {
		return Exit;
	}

	@Override
	public ListInterface<Room> getRooms() {
		return rooms;
	}
	
	/**
	 * Add room to list of neighboring rooms.
	 * @param room
	 */
	public void addRoom(Room room) {
		rooms.insertLast(room);
	}

}
