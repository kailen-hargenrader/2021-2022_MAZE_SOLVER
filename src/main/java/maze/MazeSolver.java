package maze;

import structure.ListInterface;
import structure.RecursiveLinkedList;

public class MazeSolver implements MazeSolution {
	private Maze maze;
	private ListInterface<Room> solution = new RecursiveLinkedList<Room>();
	public MazeSolver(Maze Maze) {
		maze = Maze;
	}
	@Override
	public Maze getMaze() {
		return maze;
	}

	@Override
	public ListInterface<Room> getSolution() {
		if(checkRoom(maze.getStart(), new RecursiveLinkedList<Room>())) return solution;
		throw new UnsolvableMazeException("No solution.");
	}
	private boolean checkRoom(Room room, RecursiveLinkedList<Room> visited) {
		if(room.isExit()) {
			visited.insertLast(room);
			solution = visited;
			return true;
		}
		if(!(visited.contains(room) != -1 || room.getRooms().size() == 0)) {
			visited.insertLast(room);
			for(int i = 0; i<room.getRooms().size(); i++) {
				if(checkRoom(room.getRooms().get(i), visited)) return true;
			}
		}
		return false;
	}
}
