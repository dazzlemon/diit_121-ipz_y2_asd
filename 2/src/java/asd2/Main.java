package asd2;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.io.PrintStream;
import java.io.FileOutputStream;

public class Main {
	public static void print(int[] a) {
		System.out.println(Arrays.stream(a)
											.mapToObj(String::valueOf)
											.collect(Collectors.joining(" ")));
	}
	public static void main(String[] args) {
		var qs = Tests.quickSort();
		var bs = Tests.bubbleSort();
		var gs = Tests.gnomeSort();
		
		try {
			PrintStream out = new PrintStream(new FileOutputStream("tests.txt"));
			System.setOut(out);
		} catch (Exception e) {
			System.out.println("If you see this, file tests.txt couldn't be accessed");
		}
		print(qs);
		print(bs);
		print(gs);
	}
}
