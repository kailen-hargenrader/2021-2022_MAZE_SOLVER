package structure;

/**
 * Recursively implements a linked list
 * @author monke
 *
 * @param <T>
 */
public class RecursiveLinkedList<T> implements ListInterface<T> {

	private int count;
	private Node<T> head, tail;
	
	/**
	 * Initializes linked list with no start or end and a size of 0
	 */
	public RecursiveLinkedList() {
		count = 0;
		head = null;
		tail = null;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public ListInterface<T> insertFirst(T elem) {
		// similar to push
		if(elem == null) throw new NullPointerException("Cannot pass null into list");
		// create a node
		Node<T> newNode = new Node<T>(elem);
		// set it's next to the current head
		newNode.setNext(head);
		// update head to point to our new node
		head = newNode;
		//update tail if this is the first element
		if(size() == 0) tail = newNode;
		//increment count
		count++;
		// return our list
		return this;
	}

	@Override
	public ListInterface<T> insertLast(T elem) {
		if(elem == null) throw new IllegalStateException("Cannot pass null into list");
		// create a node
		Node<T> newNode = new Node<T>(elem);
		// if size is 0, make newNode head
		if(size() == 0) head = newNode;
		// else set existing tail before newNode
		else tail.setNext(newNode);
		// update tail to point to our new node
		tail = newNode;
		//increment count
		count++;
		// return our list
		return this;
	}


	@Override
	public ListInterface<T> insertAt(int index, T elem) {
		//If elem is null then throw exception
		if(elem == null) throw new IllegalStateException("Cannot pass null into list");
		//If head or tail call insertFirst or insertLast
		if(index==0) return insertFirst(elem);
		if(index==size()) return insertLast(elem);
		//increment count
		count++;
		//if not first or last call helper
		return insertAtHelper(index-1, elem, head);
	}
	private ListInterface<T> insertAtHelper(int index, T elem, Node<T> node) {
		//recursion until node.getNext() is at index
		if(index==0) {
			Node<T> newNode = new Node<T>(elem);
			newNode.setNext(node.getNext());
			node.setNext(newNode);
			return this;
		}
		return insertAtHelper(index-1, elem, node.getNext());
	}


	@Override
	public T removeFirst() {
		//if empty list throw exception
		if(isEmpty()) throw new IllegalStateException("Cannot remove null");
		//set head to second node and return original head elem
		T elem = head.getElement();
		head = head.getNext();
		count--;
		return elem;
	}

	@Override
	public T removeLast() {
		//if empty list throw exception
		if(isEmpty()) throw new IllegalStateException("Cannot remove null");
		//call flexible method
		return removeAt(size()-1);
	}

	@Override
	public T removeAt(int index) {
		//if index not in range throw exception
		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException("Index outside of list");
		//if index is 0 call remove first
		if(index==0) return removeFirst();
		//decrement count
		count--;
		//call helper
		return removeAtHelper(index-1, head);
	}
	private T removeAtHelper(int index, Node<T> node) {
		//recursion till node.getNext() is at index
		if(index==0) {
			//save elem at index
			T elem = node.getNext().getElement();
			//if not at the end of the list, link to node after index
			if(node.getNext().getNext() != null) {
				node.setNext(node.getNext().getNext());
			}
			//if at end set next to null
			else {
				node.setNext(null);
			}
			return elem;
		}
		return removeAtHelper(index-1, node.getNext());
	}

	@Override
	public T getFirst() {
		//if empty throw exception
		if(isEmpty()) throw new IllegalStateException("cannot retrieve null");
		return head.getElement();
	}

	@Override
	public T getLast() {
		//if empty throw exception
		if(tail==null) throw new IllegalStateException("cannot retrieve null");
		return tail.getElement();
	}

	@Override
	public T get(int index) {
		//if index out of bounds throw exception
		if(index<0 || index>size()-1) throw new IndexOutOfBoundsException("index outside of list");
		//if is empty throw exception
		if(isEmpty()) throw new IllegalStateException("Cannot retrieve null");
		//call helper method
		return get(head, index).getElement();
	}

	private Node<T> get(Node<T> currentNode, int currentIndex) {
		//recursion till at index, then return node
		if(currentIndex == 0) {
			return currentNode;
		}
		return get(currentNode.getNext(), currentIndex-1);
	}

	@Override
	public boolean remove(T elem) {
		//if elem at head decrement, set head, and return true
		if(head.getElement()==elem) {
			head = head.getNext();
			count--;
			return true;
		}
		//call helper
		return removeHelper(elem, head);
	}
	private boolean removeHelper(T elem, Node<T> node) {
		//if not end of list check node.getNext() 
		if(node.getNext() != null) {
			if(node.getNext().getElement()==elem) {
				//skip node at elem, decrement, return true
				node.setNext(node.getNext().getNext());
				count--;
				return true;
			}
			//recursion until end or elem is found
			return removeHelper(elem, node.getNext());
		}
		//if end return false
		else return false;
	}

	@Override
	public int contains(T elem) {
		return contains(elem, head, 0);
	}

	private int contains(T toFind, Node<T> toCheck, int currentIndex) {
		// 2 base cases
		// base 1 - I've reached end of the list (return -1)
		// base 2 - I've found the node (toCheck.getElement().equals(toFind)) return currentIndex

		// 1 recursive case
		// contains(toFind, toCheck.getNext(), currentIndex+1)
		if(isEmpty()) return -1;
		if(toCheck.getElement()==toFind) return currentIndex;
		if(toCheck.getNext()==null) return -1;
		return contains(toFind, toCheck.getNext(), currentIndex+1);
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

}
