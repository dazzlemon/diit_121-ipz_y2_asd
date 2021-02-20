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
			// TODO: poll from post
			this.response = "some";
		} else if (!this.sendMatch() && this.query.compareTo("help") == 0) {	
			this.response = "some";//TODO	
		} else {
			// TODO: incorrect command 
			this.response = "some";
		}
	}

	public boolean sendMatch() {
		var sendPattern = Pattern.compile("^send \"(.+)\" \"(.+)\" \"(.+)\"$");
		var sendMatcher = sendPattern.matcher(this.query);
		var isMatch = sendMatcher.matches();
		if (isMatch) {
			var from = sendMatcher.group(1);
			var to   = sendMatcher.group(2);
			var body = sendMatcher.group(3);
			// TODO: Post::send 
		this.response = "";
		}
		return isMatch;
	}
}
