package asd3.main;

import java.util.Scanner;

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
		// receive
		this.response = "some";

		// send "<from>" "<to>" "<body>"
		this.response = "";

		// help
		this.response = "some";

		// incorrect command 
		this.response = "some";
	}
}
