package asd3.main;

public class Post {
	private PriorityQueue<Message> queue;


	public void send(Message m) {
		queue.add(m);
	}


	public Message receive() {
		return queue.poll();
	}
}
