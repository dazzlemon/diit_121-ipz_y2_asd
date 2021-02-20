package asd3.main;

public class Message implements Comparable<Message> {
	public String from;
	public String to;
	public String body;
	public int priority;


	public Message(String from, String to, String body, int priority) {
		this.from     = from;
		this.to       = to;
		this.body     = body;
		this.priority = priority;
	}


	public int compareTo(Message other) {
		return this.priority > other.priority ? 1
		     : this.priority < other.priority ? -1
		                                      : 0;
	}
}
