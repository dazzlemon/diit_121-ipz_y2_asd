package src;

public class OperationCounter {
	private int _counter = 0;
	private int _incDecCost = 1;
	private int _comparisonCost = 1;
	private int _assignmentCost = 1;

	public void incDec() {
		_counter += _incDecCost;
	}

	public void comp() {
		_counter += _comparisonCost;
	}

	public void assign() {
		_counter += _assignmentCost;
	}

	public int getCount() {
		return _counter;
	}
}
