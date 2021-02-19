package asd3.test;

import asd3.main.List;

class ListTest implements ITest {
	public void execute() {
		var list = new List<Integer>();
		assert list.isEmpty(): "Test not passed: List::isEmpty() -> true";


		list.add(0, 0);
		assert list.isEmpty() == false: "Test not passed: List::isEmpty() -> false";
		list = new List<Integer>();


		for (int i = 0; i < 10; i++) {
			list.add(i, i);
			assert list.size() == (i + 1): "Test not passed: List::size() -> " + (i + 1);
		}
	}
}
