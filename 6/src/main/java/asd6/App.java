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
    private Graph graph = new AdjacencyMatrix();// AdjacencyList

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
                          + "\tremove \"<v1>\" \"<v2>\"\n"
                          + "\tisEdge \"<v1>\" \"<v2>\"\n";
            break;
        default:
            if (!this.match()) {
			    this.response = String.format("<%s> is incorrect command, try \'help\'", this.query);
		    }
            break;
        }
	}

    private boolean match() {
        return addMatch()
            || removeMatch()
            || dfsMatch()
            || bfsMatch()
            || containsMatch()
            || isEdgeMatch();
    }

    /**
	 * Checks if the query is correct <add> command,
	 * if true resolves it and returns true
	 */
    private boolean addMatch() {
        // add "v"
        // add "v1" "v2"
        var p = Pattern.compile("add \"([^\"]+)\"( \"([^\"]+)\")?");//^$ are included by matches()
		var m = p.matcher(this.query);
		var isMatch = m.matches();
		if (isMatch) {
            var v1 = m.group(1);
            var v2 = m.group(3);

            try {
                if (v2 == null) {
                    graph.add(v1);
                    this.response = String.format(
                        "\tSuccessfully added vertex \"%s\"",
                        v1
                    );
                } else {
                    graph.add(v1, v2);
                    this.response = String.format(
                        "\tSuccessfully added edge from \"%s\" to \"%s\"",
                        v1, v2
                    );
                }
            } catch (IllegalArgumentException e) {
                this.response = "\t" + e.getMessage();
            }
		}
		return isMatch;
    }

    private boolean removeMatch() {
        // remove "v"
        // remove "v1" "v2"
        var p = Pattern.compile("remove \"([^\"]+)\"( \"([^\"]+)\")?");//^$ are included by matches()
		var m = p.matcher(this.query);
		var isMatch = m.matches();
		if (isMatch) {
            var v1 = m.group(1);
            var v2 = m.group(3);

            try {
                if (v2 == null) {
                    graph.remove(v1);
                    this.response = String.format(
                        "\tSuccessfully removed vertex \"%s\"",
                        v1
                    );
                } else {
                    graph.remove(v1, v2);
                    this.response = String.format(
                        "\tSuccessfully removed edge from \"%s\" to \"%s\"",
                        v1, v2
                    );
                }
            } catch (IllegalArgumentException e) {
                this.response = "\t" + e.getMessage();
            }
		}
		return isMatch;
    }

    private boolean dfsMatch() {
        // dfs "v"
        var p = Pattern.compile("dfs \"([^\"]+)\"");//^$ are included by matches()
		var m = p.matcher(this.query);
		var isMatch = m.matches();
		if (isMatch) {
            var v = m.group(1);

            try {
                this.response = "\t";
                for (var w : graph.dfs(v)) {
                    response += w;
                }
            } catch (IllegalArgumentException e) {
                this.response = "\t" + e.getMessage();
            }
		}
		return isMatch;
    }

    private boolean bfsMatch() {
        return false;// TODO
    }

    private boolean containsMatch() {
        return false;// TODO
    }

    private boolean isEdgeMatch() {
        return false;// TODO
    }
}
