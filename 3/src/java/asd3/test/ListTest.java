package asd3.test;

import asd3.main.List;

class ListTest implements ITest {
	public void execute() {
		this.isEmptyTest();	
		this.sizeTest();
		this.addTest();
		this.addIdxTest();
	}


	public void isEmptyTest() {
		var list = new List<Integer>();
		assert list.isEmpty(): "Test not passed: List::isEmpty() -> true";

		list.add(0, 0);
		assert list.isEmpty() == false: "Test not passed: List::isEmpty() -> false";
	}


	public void sizeTest() {
		var list = new List<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i, i);
			assert list.size() == (i + 1): "Test not passed: List::size() -> " + (i + 1);
		}
	}


	public void addTest() {
		var list = new List<Integer>();
		var str  = "";
		for (int i = 0; i < 10; i++) {
			list.add(i, i);
			str += i;
			var str_ = "";
			for (int j = 0; j < list.size(); j++) {
				str_ += list.get(j);
			}
			assert str.compareTo(str_) == 0: "Test not passed: List::add -> Expected: " + str + ", Actual: " + str_; 
		}
	}


	public void addIdxTest() {

	}
}
