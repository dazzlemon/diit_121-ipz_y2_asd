package src;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		var qs = Tests.quickSort();
		var bs = Tests.bubbleSort();
		var gs = Tests.gnomeSort();
		System.out.println(Arrays.toString(qs));
		System.out.println(Arrays.toString(bs));
		System.out.println(Arrays.toString(gs));
	}
}
