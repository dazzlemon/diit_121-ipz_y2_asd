package asd3.main;

public class PriorityQueue <E extends Comparable<E>> {
	private List<E> list = new List<E>();	


	public boolean isEmpty() {
		return list.isEmpty();	
	}


	public void add(E e) {
		if (this.isEmpty()) {
			list.add(e);
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (e.compareTo(list.get(i)) < 0) {
					list.add(i, e);
				}
			}
		}
	}


	public E peek() {
		return list.get(list.size() - 1);
	}


	public E poll() {
		return list.remove(list.size() - 1);
	}
}
