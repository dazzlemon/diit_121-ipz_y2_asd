package asd3.test;

import asd3.main.List;

public class ListTest implements ITest {
	public void execute() {
		this.isEmptyTest();	
		this.sizeTest();
		this.addTest();
		this.addIdxTest();
		this.getTest();
		this.removeTest();
	}


	private void isEmptyTest() {
		var list = new List<Integer>();
		var e = list.isEmpty();
		assert e: failMessage("List::isEmpty()", true, e);

		list.add(0, 0);
		e = list.isEmpty();
		assert !e: failMessage("List::isEmpty()", false, e);
	}


	private void sizeTest() {
		var list = new List<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i, i);
			var sz = list.size();
			assert sz == (i + 1): failMessage("List::size()", i + 1, sz);
		}
	}


	private void addIdxTest() {
		// setup
		var list = new List<Integer>();
		list.add(0, 2);// 2

		// insert at 0
		list.add(0, 0);// 0 2

		// insert at 1
		list.add(1, 1);// 0 1 2

		// insert at size
		list.add(list.size(), 4);// 0 1 2 4
		
		// insert at size - 1
		list.add(list.size() - 1, 3);// 0 1 2 3 4

		var str  = "01234";
		var str_ = "";
		for (int i = 0; i < list.size(); i++) {
			str_ += list.get(i);
		}
		assert str.compareTo(str_) == 0: failMessage("List::add", str, str_);
	}


	private void addTest() {
		var list = new List<Integer>();
		var str  = "";
		for (int i = 0; i < 10; i++) {
			list.add(i);
			str += i;
			var str_ = "";
			for (int j = 0; j < list.size(); j++) {
				str_ += list.get(j);
			}
			assert str.compareTo(str_) == 0: this.failMessage("List::add", str, str_); 
		}
	}


	private void getTest() {
		var list = new List<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		for (int i = 0; i < list.size(); i++) {
			var i_ = list.get(i);
			assert i_ == i: failMessage("List::get", i, i_);
		}	
	}


	private void removeTest() {
		// setup
		var list = new List<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		// remove at 0
		list.remove(0);// 1 2 3 4 5 6 7 8 9
		
		// remove at 1
		list.remove(1);// 1 3 4 5 6 7 8 9

		// remove at size - 1
		list.remove(list.size() - 1);// 1 3 4 5 6 7 8

		var str = "1345678";
		var str_ = "";
		for (int i = 0; i < list.size(); i++) {
			str_ += list.get(i);
		}
		assert str.compareTo(str_) == 0: failMessage("List::remove", str, str_);
	}


	private <T, E> String failMessage(String testSubject, T expectedValue, E actualValue) {
		var a = String.valueOf(actualValue);
		var e = String.valueOf(expectedValue);
		return "Test failed: " + testSubject + " -> Expected: " + e + ", Actual: " + a;
	}
}
