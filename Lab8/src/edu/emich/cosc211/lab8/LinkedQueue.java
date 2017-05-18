package edu.emich.cosc211.lab8;

import edu.emich.cosc211.util.Queue;
import edu.emich.cosc211.util.Student;
import edu.emich.cosc211.util.GenericLinkedList.GenericLinkedListNode;
import edu.emich.cosc211.util.GenericLinkedList;

@SuppressWarnings("unused")
public class LinkedQueue extends GenericLinkedList implements Queue<Student> {

	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	@Override

	/**
	 * Takes in a student item and puts them into the classlist at the end
	 */
	public boolean offer(Student item) {
		
		GenericLinkedListNode node = this.getHead();
		while (node != null) {
			node = node.getNext();
		}
		GenericLinkedListNode newNode = new GenericLinkedListNode(item);
		node.setNext(newNode);
		return true;
	}

	@Override
	public Student poll() {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	/*
	 * shows the user the head node (non-Javadoc)
	 * 
	 * @see edu.emich.cosc211.util.Queue#peek()
	 */
	public Student peek() {
		return this.getHead();
	}

	@Override
	/*
	 * tells whether or not the list is empty (non-Javadoc)
	 * 
	 * @see edu.emich.cosc211.util.Queue#isEmpty()
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub

		return false;
	}

	/*Clears the list
	 * (non-Javadoc)
	 * 
	 * @see edu.emich.cosc211.util.GenericLinkedList#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
