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
			int i = 0;
			while (i < this.list.size() && e.compareTo(list.get(i)) < 0) {
				i++;
			}
			this.list.add(i, e);
		}
	}


	public E peek() {
		return this.list.get(list.size() - 1);
	}


	public E poll() {
		return this.list.remove(list.size() - 1);
	}
}
