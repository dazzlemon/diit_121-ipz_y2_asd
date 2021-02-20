package asd3.test;

import asd3.main.PriorityQueue;

public class PriorityQueueTest implements ITest {
	public void execute() {
		this.isEmptyTest();
		this.addTest();
		this.peekTest();
		this.pollTest();
	}


	private void isEmptyTest() {
		var pq = new PriorityQueue<Integer>();
		var e = pq.isEmpty();
		assert e: failMessage("PriorityQueue::isEmpty()", true, e);

		pq.add(0);
		e = pq.isEmpty();
		assert !e: failMessage("PriorityQueue::isEmpty()", false, e);
	}
	
	
	private void addTest() {
		// setup
		var pq = new PriorityQueue<Integer>();
		pq.add(5);// 5

		// add top priority
		pq.add(6);// 6 5

		// add lowest priority
		pq.add(3);// 6 5 3

		// add middle priority
		pq.add(4);// 6 5 4 3

		var str  = "6543";
		var str_ = "";
		while (!pq.isEmpty()) {
			str_ += pq.poll();
		}
		assert str.compareTo(str_) == 0: failMessage("PriorityQueue::add", str, str_);
	}
	
	
	private void peekTest() {
		
	}
	
	
	private void pollTest() {
	
	}


	private <T, E> String failMessage(String testSubject, T expectedValue, E actualValue) {
		var a = String.valueOf(actualValue);
		var e = String.valueOf(expectedValue);
		return "Test failed: " + testSubject + " -> Expected: " + e + ", Actual: " + a;
	}
} 
