package src;

public class Sorts {
	public static <T extends Comparable<T>> void gnomeSort(T[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 && a[j - 1].compareTo(a[j]) > 0; j--) {
				_swapByIdx(a, j - 1, j);
			}
		}
	}	

	public static <T extends Comparable<T>> void bubbleSort(T[] a) {
		for (int n = a.length; n > 1; ) {
			int newN = 0;
			for (int i = 1; i < n; i++) {
				if (a[i - 1].compareTo(a[i]) > 0) {
					_swapByIdx(a, i - 1, i);
					newN = i;
				}
			}
			n = newN;
		}
	}

	public static <T extends Comparable<T>> void quickSort(T[] a) {
		_quickSort(a, 0, a.length - 1);
	}

	private static <T extends Comparable<T>> void _quickSort(T[] a, int lo, int hi) {
  if (lo < hi) {
    var p = _partition(a, lo, hi);
		if (p > 0) {
			_quickSort(a, lo, p - 1);
		}
    _quickSort(a, p + 1, hi);
	}
}

	private static <T extends Comparable<T>> int _partition(T[] a, int lo, int hi) {
	var pivot = a[hi];
	var i = lo;
	for (var j = lo; j <= hi; j++) {
		if (a[j].compareTo(pivot) < 0) {
			_swapByIdx(a, i++, j);
		}
	}
	_swapByIdx(a, i, hi);
	return i;
}

	private static <T> void _swapByIdx(T[] a, int i, int j) {
		T t    = a[i];
		a[i]   = a[j];
		a[j]   = t;
	}
}
