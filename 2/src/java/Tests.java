package src.java;

import java.util.Random;
import java.util.Arrays;

public class Tests {
	public static void fill(Integer[] a) {
		var r = new Random();
		//for (var i : a) {//idk why this doesnt work
		//	i = r.nextInt();
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt();
		}
	}

	public static int[] quickSort() {
		int[] res = new int[1000];
		for (int i = 0; i < res.length; i++) {
			var a = new Integer[i + 1];
			fill(a);
			res[i] = Sorts.quickSort(a);
		}
		return res;
	}

	public static int[] bubbleSort() {
		int[] res = new int[1000];
		for (int i = 0; i < res.length; i++) {
			var a = new Integer[i + 1];
			fill(a);
			res[i] = Sorts.bubbleSort(a);
		}
		return res;
	}

	public static int[] gnomeSort() {
		int[] res = new int[1000];
		for (int i = 0; i < res.length; i++) {
			var a = new Integer[i + 1];
			fill(a);
			res[i] = Sorts.gnomeSort(a);
		}
		return res;
	}
}
