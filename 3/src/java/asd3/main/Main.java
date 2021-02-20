package asd3.main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
	public static void main(String[] args) {
		var manager = new PostManager();
		manager.run();
	}
}


class PostManager {
	private String query;
	private boolean isRunning;
	private String response;
	private Scanner in = new Scanner(System.in).useDelimiter("\n");
	private Post post = new Post();

	public void run() {
		this.isRunning = true;
		do {
			System.out.print("###POST###: ");
			this.query = in.next();
			this.resolveQuery();
			System.out.println(this.response);
		}	while (isRunning);
	}


	public void resolveQuery() {
		if (this.query.compareTo("quit") == 0) {
			this.response = "";
			this.isRunning = false;
		} else if (this.query.compareTo("receive") == 0) {
			var msg = post.receive();
			this.response = String.format("from: %s\n", msg.from)
			              + String.format("to: %s\n", msg.to)
			              + String.format("to: %s\n", msg.body);
		} else if (!this.sendMatch() && this.query.compareTo("help") == 0) {	
			this.response = "Commands:\n"
			              + "\tquit\n"
			              + "\treceive\n"
			              + "\tsend \"<from>\" \"<to>\" \"<body>\" <priority>";
		} else {
			this.response = "Incorrect command, try \'help\'";
		}
	}


	public boolean sendMatch() {
		var p = Pattern.compile("send \"(.+)\" \"(.+)\" \"(.+)\" (\\d+)");//^$ are included by matches()
		var m = p.matcher(this.query);
		var isMatch = m.matches();
		if (isMatch) {
			var msg = new Message(
				m.group(1),// from
				m.group(2),// to
				m.group(3),// body
				Integer.parseInt(m.group(4))// priority
			);
			post.send(msg);
			this.response = "";
		}
		return isMatch;
	}
}
