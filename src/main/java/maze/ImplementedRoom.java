package maze;

import structure.ListInterface;
import structure.RecursiveLinkedList;

class ImplementedRoom implements Room {
	private String Long = new String();
	private String Short = new String();
	private Boolean Exit;
	private RecursiveLinkedList<Room> rooms = new RecursiveLinkedList<Room>();
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
