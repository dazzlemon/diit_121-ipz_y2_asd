package asd3.main;

public class PriorityQueue <E extends Comparable<E>> {
	private List<E> list = new List<E>();	


	public boolean isEmpty() {
		return this.list.isEmpty();	
	}


	public void add(E e) {
		if (this.isEmpty()) {
			this.list.add(e);
		} else {
			int i = this.list.size();
			while (i > 0 && e.compareTo(this.list.get(i - 1)) < 0) {	
				i--;
			}
			this.list.add(i, e);
		}
	}


	public E peek() {
		return this.list.get(this.list.size() - 1);
	}


	public E poll() {
		return this.list.remove(this.list.size() - 1);
	}


	public E last() {
		return this.list.get(0);
	}


	public int size() {
		return this.list.size();
	}
}
