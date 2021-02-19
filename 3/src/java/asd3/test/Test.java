package asd3.test;

public class Test {
	public static void main(String[] args) {
		ITest[] tests = new ITest[] {
			new ListTest()
		};
		for (var test : tests) {
			test.execute();
		}
	}
}
