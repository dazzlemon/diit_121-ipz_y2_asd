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
		var pq = new PriorityQueue<Integer>();
		pq.add(7);
		pq.add(3);
		pq.add(2);
		pq.add(1);
		pq.add(6);
		pq.add(8);
		pq.add(4);
		pq.add(5);
		pq.add(9);
		var str  = "123456789";
		var str_ = "";
		while (!pq.isEmpty()) {
			str_ += pq.poll();
		}
		System.out.println(str_);
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
