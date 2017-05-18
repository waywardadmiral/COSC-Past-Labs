package Project2;

@SuppressWarnings("rawtypes")
public class Stacks implements Stack {
	private class Node {
		private String item;
		private Node link;

		@SuppressWarnings("unused")
		public Node() {
			item = null;
			link = null;
		}

		public Node(String newItem, Node linkValue) {
			item = newItem;
			link = linkValue;
		}
	}

	private Node head;

	public Stacks() {
		head = null;
	}

	public void push(String itemName) {
		head = new Node(itemName, head);
	}

	@Override
	public String pop() {
		if (head == null) {
			throw new IllegalStateException();
		} else {
			String returnItem = head.item;
			head = head.link;
			return returnItem;
		}
	}

	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public Object peek() {
		
		return null;
	}

	@Override
	public Object push(Object item) {
		// TODO Auto-generated method stub
		return null;
	}

}
