package asd3.main;

public class List <E> {
	private class Node {
		public Node(Node next, E data) {
			this.next = next;
			this.data = data;
		}


		public Node next = null;
		public E data;
	}


	private Node head = null;


	public boolean isEmpty() {
		return head == null;	
	}

	
	public int size() {
		int size = 0;
		for (var i = this.head; i != null; i = i.next) {
			size++;
		}
		return size;
	}

	
	public void add(E e) {
		var newLast = new Node(null, e);
		if (this.isEmpty()) {
			this.head = newLast;
		} else {
			var node = this.head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = newLast;
		}
	}


	public void add(int index, E e) {
		if (index == this.size()) {
			this.add(e);
		} else {	
			var node = this.head;
			for (int i = 0; i < index - 1; i++) {
				node = node.next;
			}
			node.next = new Node(node.next, e);
		}
	}


	public E get(int index) {
		var node = this.head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node.data;
	}


	public E remove(int index) {
		var node = this.head;
		for (int i = 0; i < index - 1; i++) {
			node = node.next;
		}
		var data = node.next.data;
		node.next = node.next.next;
		return data;
	}
}
