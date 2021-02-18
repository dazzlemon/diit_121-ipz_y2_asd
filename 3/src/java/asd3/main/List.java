package asd3.main;

public class List <E> {
	private class Node {
		public Node next;
		public E data;
	}


	private class Iterator {
		Node next;


		public Iterator(Node n) {
			this.next = n;
		}
		

		public boolean hasNext() {
			return next != null;
		}

		
		public E next() {
			E e = next.data;
			next = next.next;
			return e;
		}
	}


	private Node head = null;


	public boolean isEmpty() {
		return head == null;	
	}

	
	public int size() {
		int size = 0;
		for (var i : Iterator(head)) {
			size++;
		}
		return size;
	}


	public void add(int index, E e) {
		
	}


	public E get(int index) {

	}


	public E remove(int index) {

	}
}
