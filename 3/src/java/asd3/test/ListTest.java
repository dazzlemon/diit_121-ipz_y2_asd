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
			assert str.compareTo(str_) == 0: this.failMessage("List::add", str, str_); 
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
			assert str.compareTo(str_) == 0: failMessage("List::add", str, str_);
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
		var list = new List<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.remove(5);
		var str = "012346789";
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
