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
