public class Main2 {
	public static void main(String[] args) {

	}
}


class QueueInt {
	private int[] elems;
	private int first;
	private int last;
	private int size;// actual amount of elems


	public QueueInt(int size) {
		last  = -1;
		elems = new int[size];
	}


	public boolean add(int i) {
		if (size < elems.length()) {
			if (last >= elems.length()) {
				last = -1;
			}
			elems[++last] = i;
			size++;
			return true;
		}
		return false;
	}


	public void poll() {

	}
}
