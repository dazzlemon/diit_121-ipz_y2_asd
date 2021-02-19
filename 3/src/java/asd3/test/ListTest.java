package asd3.test;

import asd3.main.List;

interface Test {
	public void execute();
}

class ListTest1 implements Test {
	public void execute() {
		var list = new List<Integer>();
		assert list.isEmpty(): "Test not passed: List::isEmpty()";
	}
}

public class ListTest {
	public static void main(String[] args) {
		Test[] tests = new Test[] {
			new ListTest1()
		};
		for (var test : tests) {
			test.execute();
		}
	}
}
