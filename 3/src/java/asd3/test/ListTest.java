package asd3.test;

import asd3.main.List;

class ListTest implements ITest {
	public void execute() {
		var list = new List<Integer>();
		assert list.isEmpty(): "Test not passed: List::isEmpty()";
	}
}
