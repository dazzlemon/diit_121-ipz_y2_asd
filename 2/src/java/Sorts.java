package src.java;

public class Sorts {
	public static <T extends Comparable<T>> int gnomeSort(T[] a) {
		var counter = new OperationCounter();
		counter.assign();// int i = 1 -> assignment
		for (int i = 1; i < a.length; i++) {
			counter.assign();// int j = i -> assignment
			for (int j = i; j > 0 && a[j - 1].compareTo(a[j]) > 0; j--) {	
				counter.assign(); counter.assign(); counter.assign();// swap counts as 3 assignments
				_swapByIdx(a, j - 1, j);

				counter.comp(); counter.comp();// j > 0, compareTo -> comparison; twice
				counter.incDec();// j - 1, j-- -> decrement;                      once (essintially the same operation)
				counter.jmp();// for loop
			}
			counter.comp();// i < a.length -> comparison
			counter.incDec();// i++        -> increment
			counter.jmp();// for loop
		}
		return counter.getCount();
	}	

	public static <T extends Comparable<T>> int bubbleSort(T[] a) {
		var counter = new OperationCounter();
		counter.assign();// int n = a.length -> assignment
		for (int n = a.length; n > 1; ) {	
			counter.assign();// int newN = 0 -> assignment
			int newN = 0;

			counter.assign();// int i = 1 -> assignment
			for (int i = 1; i < n; i++) {
				counter.comp();// compareTo -> comparison
				counter.jmp();// if
				if (a[i - 1].compareTo(a[i]) > 0) {
					counter.assign(); counter.assign(); counter.assign();// swap -> 3 assignments
					_swapByIdx(a, i - 1, i);
					counter.assign();// assignment
					newN = i;
				}
				counter.comp();// i < n -> comparison
				counter.incDec();// i++ -> increment
				counter.jmp();// for loop
			}
			counter.assign();// n = newN -> assignment
			n = newN;

			counter.comp();// n > 1 -> comparison
			counter.jmp();// for loop
		}
		return counter.getCount();
	}

	public static <T extends Comparable<T>> int quickSort(T[] a) {
		var counter = new OperationCounter();
		_quickSort(a, 0, a.length - 1, counter);
		return counter.getCount();
	}

	private static <T extends Comparable<T>> void _quickSort(T[] a, int lo, int hi, OperationCounter counter) {
  	counter.comp();// comparison
		counter.jmp();// if
		if (lo < hi) {
			counter.assign();// assignment + _partitions counter
    	var p = _partition(a, lo, hi, counter);
			counter.jmp();// function
	
			counter.jmp();// if
			counter.comp();// comparison
			if (p > 0) {
				// + recursions counter
				_quickSort(a, lo, p - 1, counter);
				counter.jmp();// function
			}
			// + recursions counter
    	_quickSort(a, p + 1, hi, counter);
			counter.jmp();// function
		}
	}

	private static <T extends Comparable<T>> int _partition(T[] a, int lo, int hi, OperationCounter counter) {
		var pivot = a[hi];
		var i = lo;

		counter.assign(); counter.assign(); counter.assign();// pivot = a[hi], i = lo, j = hi; three assignments
		for (var j = lo; j <= hi; j++) {
			counter.comp();// comparison
			if (a[j].compareTo(pivot) < 0) {
				counter.assign(); counter.assign(); counter.assign();// swap -> 3 assignments
				counter.incDec();// increment
				_swapByIdx(a, i++, j);
			}
			counter.comp();// j <= hi comparison
			counter.incDec();// j++ increment
		}
		counter.assign(); counter.assign(); counter.assign();// swap
		_swapByIdx(a, i, hi);
		return i;
	}

	private static <T> void _swapByIdx(T[] a, int i, int j) {
		T t    = a[i];
		a[i]   = a[j];
		a[j]   = t;
	}
}
