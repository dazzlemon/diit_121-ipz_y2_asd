package asd2;

import java.util.Random;
import java.util.Arrays;

public class Tests {
	private static final int LOOPS = 64;

	public static void fill(Integer[] a) {
		var r = new Random();
		//for (var i : a) {//idk why this doesnt work
		//	i = r.nextInt();
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt();
		}
	}

	public static int[] quickSort() {
		int[] res = new int[100];
		for (int i = 1; i < res.length; i++) {
			var a = new Integer[i + 1];
			
			int sum = 0;
			for (int j = 0; j < LOOPS; j++) {
				fill(a);
				sum += Sorts.quickSort(a);
			}

			res[i] = sum / LOOPS;
		}
		return res;
	}

	public static int[] bubbleSort() {
		int[] res = new int[100];
		for (int i = 1; i < res.length; i++) {
			var a = new Integer[i + 1];
			
			int sum = 0;
			for (int j = 0; j < LOOPS; j++) {
				fill(a);
				sum += Sorts.bubbleSort(a);
			}

			res[i] = sum / LOOPS;
		}
		return res;
	}

	public static int[] gnomeSort() {
		int[] res = new int[100];
		for (int i = 1; i < res.length; i++) {
			var a = new Integer[i + 1];
			
			int sum = 0;
			for (int j = 0; j < LOOPS; j++) {
				fill(a);
				sum += Sorts.gnomeSort(a);
			}

			res[i] = sum / LOOPS;
		}
		return res;
	}
}
