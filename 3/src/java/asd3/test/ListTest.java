package asd3.test;

import asd3.main.List;

class ListTest implements ITest {
	public void execute() {
		this.isEmptyTest();	
		this.sizeTest();
		this.addTest();
		this.addIdxTest();
		this.getTest();
	}


	private void isEmptyTest() {
		var list = new List<Integer>();
		assert list.isEmpty(): "Test not passed: List::isEmpty() -> true";

		list.add(0, 0);
		assert list.isEmpty() == false: "Test not passed: List::isEmpty() -> false";
	}


	private void sizeTest() {
		var list = new List<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i, i);
			assert list.size() == (i + 1): "Test not passed: List::size() -> " + (i + 1);
		}
	}


	private void addTest() {
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


	private void addIdxTest() {
		var list = new List<Integer>();
		list.add(-1);
		for (int i = 0; i < 10; i++) {
			list.add(1, i);
			var str = "";
			for (int j = i; j >= 0; j--) {
				str += j;
			}
			var str_ = "";
			for (int j = 1; j < list.size(); j++) {
				str_ += list.get(j);
			}
			assert str.compareTo(str_) == 0: "Test not passed: List::add -> Expected: " + str + ", Actual: " + str_; 
		}
	}


	private void getTest() {
		var list = new List<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		for (int i = 0; i < list.size(); i++) {
			var i_ = list.get(i);
			assert i_ == i: "Test failed: List::get -> Expected: " + i + ", Actual: " + i_;
		}	
	}
}
