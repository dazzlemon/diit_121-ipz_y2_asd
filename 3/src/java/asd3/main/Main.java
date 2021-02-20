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
	private Scanner in = new Scanner(System.in);
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
		if (this.query.compareTo("receive") == 0) {
			var msg = post.receive();
			this.response = String.format("from: %s\n", msg.from)
			              + String.format("to: %s\n", msg.to)
			              + String.format("to: %s\n", msg.body);
		} else if (!this.sendMatch() && this.query.compareTo("help") == 0) {	
			this.response = "Commands:\n"
			              + "\treceive\n"
			              + "\tsend \"<from>\" \"<to>\" \"<body>\" <priority>\n";
		} else {
			this.response = "Incorrect command, try \'help\'";
		}
	}


	public boolean sendMatch() {
		var sendPattern = Pattern.compile("^send \"(.+)\" \"(.+)\" \"(.+)\" (\\d+)$");
		var sendMatcher = sendPattern.matcher(this.query);
		var isMatch = sendMatcher.matches();
		if (isMatch) {
			var msg = new Message(
				sendMatcher.group(1),// from
				sendMatcher.group(2),// to
				sendMatcher.group(3),// body
				Integer.parseInt(sendMatcher.group(4))// priority
			);
			post.send(msg);
			this.response = "";
		}
		return isMatch;
	}
}
