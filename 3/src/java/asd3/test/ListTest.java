package asd3.test;

import asd3.main.List;

class ListTest implements ITest {
	public void execute() {
		var list = new List<Integer>();
		assert list.isEmpty(): "Test not passed: List::isEmpty() -> true";


		list.add(0, 0);
		assert list.isEmpty() == false: "Test not passed: List::isEmpty() -> false";
	}
}
