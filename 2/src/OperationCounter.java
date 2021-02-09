package src;

public class OperationCounter {
	private int _counter = 0;
	private int _incDecCost;
	private int _comparisonCost;
	private int _assignmentCost;

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
