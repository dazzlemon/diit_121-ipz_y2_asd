package src;

import java.util.Arrays;

public class Main {
	private static <T> void print(T[] arr) {
		for (T a : arr) {
			System.out.printf(a + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] arr = {7, 6, 16, 8, 32, 4, 1, 6};
		System.out.print("Array before sort: ");
		System.out.println(Arrays.toString(arr));
		
		Sorts.quickSort(arr);
		//Sorts.bubbleSort(arr);
		//Sorts.gnomeSort(arr);
		System.out.print("Array after sort: ");
		System.out.println(Arrays.toString(arr));
	}
}
