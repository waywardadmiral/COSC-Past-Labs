package edu.emich.cosc211.util;

/**
 * A simple generic linked list class.
 *
 * @author eddie gurnee
 *
 * @param <T>
 */
public class GenericLinkedList<T> {
	/**
	 * Inner class to track individual data nodes.
	 *
	 * @author eddie gurnee
	 *
	 */
	public class GenericLinkedListNode {
		private T data;
		private GenericLinkedListNode next;

		/**
		 * Constructor for a linked list node
		 * 
		 * @param data
		 */
		public GenericLinkedListNode(T data) {
			this.setData(data);
			this.setNext(null);
		}

		/**
		 * 
		 * @return the next node in the list
		 */
		public GenericLinkedListNode getNext() {
			return next;
		}

		/**
		 * Takes in a node and adds it to the list
		 * 
		 * @param next
		 *            the node to be added
		 */
		public void setNext(GenericLinkedListNode next) {
			this.next = next;
		}

		/**
		 * 
		 * @return the data from a node
		 */
		public T getData() {
			return data;
		}

		/**
		 * sets the data for a specific node
		 * 
		 * @param data
		 *            the data to set
		 */
		public void setData(T data) {
			this.data = data;
		}
	}

	private GenericLinkedListNode head;
	private GenericLinkedListNode tail;

	public GenericLinkedList() {
		this.setHead(null);
	}

	/**
	 * Returns the specific element at a requested index.
	 *
	 * @param index
	 * @return
	 */
	public T get(int index) {
		GenericLinkedListNode node = this.getHead();
		for (int i = 0; i < index; i++) {
			node = node.getNext();
		}
		return node.getData();
	}

	/**
	 * returns the head node
	 * 
	 * @return head node
	 */
	public GenericLinkedListNode getHead() {
		return head;
	}

	/**
	 * sets the head node
	 * 
	 * @param head
	 *            node to become head
	 */
	public void setHead(GenericLinkedListNode head) {
		this.head = head;
	}

	/**
	 * clears the list
	 */
	public void clear() {
		this.head = null;
	}

	/**
	 * 
	 * @return the size of the list
	 */
	public int size() {
		int i = 0;
		@SuppressWarnings("unchecked")
		GenericLinkedListNode node = new GenericLinkedListNode((T) this.getHead());
		while (node.getNext() != null) {
			i++;
		}
		return i;

	}

	/**
	 * 
	 * @param element
	 *            element to check for
	 * @return boolean of whether the element is there or not
	 */
	public boolean contains(T element) {
		@SuppressWarnings("unchecked")
		GenericLinkedListNode node = new GenericLinkedListNode((T) this.getHead());
		if (element != node) {
			node = node.getNext();
		}
		return true;
	}

	/**
	 * 
	 * @param element
	 *            element to be found
	 * @return the index of the element requested
	 */
	public int indexOf(T element) {
		int index = 0;
		while (element != this.get(index)) {
			index++;
		}
		return index;
	}

	/**
	 * sets the element at a specific index to the element listed
	 * 
	 * @param index
	 *            where the element will be set
	 * @param element
	 *            element to set
	 */
	public void set(int index, T element) {
		this.get(index);
		this.set(index, element);

	}

	// TODO: Treat as queue
	/**
	 * returns the head of a linked list
	 * 
	 * @return head
	 */
	public GenericLinkedListNode getFirst() {
		return this.getHead();
	}

	// XXX: Treat as stack
	// XXX: getFirst()
	// XXX: addToFront()

	// XXX: remove(int index)
	// XXX: remove(T element)
	// XXX: add(int index, T element)
}
