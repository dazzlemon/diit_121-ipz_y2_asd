import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var in    = new Scanner(System.in);
		var text  = in.nextLine();
		var stack = new StackChar(text.length());
		for (int i = 0; i < text.length(); i++) {
			if (isOpenBracket(text.charAt(i))) {
				stack.push(text.charAt(i));
			}
			if (isClosedBracket(text.charAt(i))) {
				if (stack.isEmpty())	{
					System.out.println("Unexpected token " + text.charAt(i) + " at index " + i);
					break;
				} else {
					if (isPair(stack.peek(), text.charAt(i))) {
						stack.pop();
					} else {
						System.out.println("Unexpected token " + text.charAt(i) + " at index " + i);
						break;
					}
				}
			}
		}
		if (!stack.isEmpty()) {
			System.out.println("Not closed brackets");
		} else {
			System.out.println("OK");
		}
	}


	public static boolean isOpenBracket(char c) {
		return c == '(' || c == '[' || c == '{';
	}


	public static boolean isClosedBracket(char c) {
		return c == ')' || c == ']' || c == '}';
	}


	public static boolean isPair(char a, char b) {
		switch (a) {
			case '(':
				return b == ')';
			case '[':
				return b == ']';
			case '{':
				return b == '}';
			default:
				return false;
		}
	}
}


class StackChar {
	private char[] elements;
	private int top;// aka size


	public StackChar(int size) {
		top = -1;
		elements = new char[size];
	}


	public void push(char c) {
		elements[++top] = c;
	}


	public char pop() {
		return elements[top--];
	}


	public char peek() {
		return elements[top];
	}


	public boolean isFull() {
		return top >= elements.length;
	}
	

	public boolean isEmpty() {
		return top < 0;
	}
}
