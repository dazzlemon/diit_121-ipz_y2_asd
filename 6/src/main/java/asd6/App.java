package asd6;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        var io = new IO();
        io.run();
    }
}

class IO {
    private String query;
    private boolean isRunning;
    private String response;
    private Scanner in = new Scanner(System.in).useDelimiter("\n");
    private Graph graph = new AdjacencyList();// AdjacencyMatrix

    public void run() {
        this.isRunning = true;
        System.out.println("see \'help\', to check out available commands");
		do {
			System.out.print("###GRAPH###: ");
			this.query = in.next();
			this.resolveQuery();
			System.out.println(this.response);
		} while (isRunning);
    }

    /**
	 * Changes this.response according to this.query
	 */
	private void resolveQuery() {
        switch (this.query) {
        case "quit":
            this.response = "";
            this.isRunning = false;
            break;
        case "size":
            this.response = "size: " + graph.size();
            break;
        case "clear":
            graph.clear();
            this.response = "cleared";
        case "help":
            this.response = "Commands:\n"
                          + "\tquit\n"
                          + "\tsize\n"
                          + "\tclear\n"
                          + "\tcontains \"<v>\"\n"
                          + "\tdfs \"<start>\"\n"
                          + "\tbfs \"<start>\"\n"
                          + "\tadd \"<v>\"\n"
                          + "\tadd \"<v1>\" \"<v2>\"\n"
                          + "\tremove \"<v>\"\n"
                          + "\tremove \"<v1>\" \"<v2>\"\n";
            break;
        default:
            if (!this.match()) {
			    this.response = String.format("<%s> is incorrect command, try \'help\'", this.query);
		    }
            break;
        }
	}

    private boolean match() {
        return !addMatch() && !removeMatch() && !dfsMatch() && bfsMatch() && containsMatch();
    }

    /**
	 * Checks if the query is correct <add> command,
	 * if true resolves it and returns true
	 */
    private boolean addMatch() {
        // add "v"
        // add "v1" "v2"
        var p = Pattern.compile("add \"(.+)\" \"(.+)\"");//^$ are included by matches()
		var m = p.matcher(this.query);
		var isMatch = m.matches();
		if (isMatch) {
			this.response = "\tsuccessufully added";
		}
		return isMatch;
    }

    private boolean removeMatch() {
        return false;// TODO
    }

    private boolean dfsMatch() {
        return false;// TODO
    }

    private boolean bfsMatch() {
        return false;// TODO
    }

    private boolean containsMatch() {
        return false;// TODO
    }
}
