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
		System.out.println("see \'help\', to check out available commands");
		do {
			System.out.print("###POST###: ");
			this.query = in.next();
			this.resolveQuery();
			System.out.println(this.response);
		}	while (isRunning);
	}


	/**
	 * Changes this.response according to this.query
	 */
	private void resolveQuery() {
		if (this.query.compareTo("quit") == 0) {
			this.response = "";
			this.isRunning = false;
		} else if (this.query.compareTo("receive") == 0) {
			if (this.post.isEmpty()) {
				this.response = "Post it empty try to \'send\' first!(See \'help\')";
			} else {
				this.response = post.receive().toString();
			}
		} else if (this.query.compareTo("help") == 0) {	
			this.response = "Commands:\n"
			              + "\tquit\n"
			              + "\treceive\n"
			              + "\tsend \"<from>\" \"<to>\" \"<body>\" <priority>";
		} else if (!this.sendMatch()) {
			this.response = String.format("<%s> is incorrect command, try \'help\'", this.query);
		}
	}


	/**
	 * Checks if the query is correct <send> command,
	 * if true resolves it and returns true
	 */
	private boolean sendMatch() {
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
