package asd5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        //BstTest.bstTest();

        var io = new IO();
        io.run();
    }
}

class IO {
    private String query;
    private boolean isRunning;
    private String response;
    private Scanner in = new Scanner(System.in).useDelimiter("\n");
    private BinarySearchTree<String, Wish> wishList = new BinarySearchTree<>();

    public void run() {
        this.isRunning = true;
        System.out.println("see \'help\', to check out available commands");
		do {
			System.out.print("###CHRISTMAS###: ");
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
        case "ls":
            this.response = "";
            for (var wish : wishList) {
                this.response += "\t" + wish.toString() + "\n";
            }
            break;
        case "help":
            this.response = "Commands:\n"
                          + "\tquit\n"
                          + "\tget \"<receiver>\"\n"
                          + "\tls\n"
                          + "\tadd \"<type>\" \"<receiver>\", type = TOY | GADGET | CLOTH | FOOD";
            break;
        default:
            if (!this.addMatch() && !this.getMatch()) {
			    this.response = String.format("<%s> is incorrect command, try \'help\'", this.query);
		    }
            break;
        }
	}

    /**
	 * Checks if the query is correct <add> command,
	 * if true resolves it and returns true
	 */
    private boolean addMatch() {
        // wish "<type>" "<receiver>""
        var p = Pattern.compile("add \"(.+)\" \"(.+)\"");//^$ are included by matches()
		var m = p.matcher(this.query);
		var isMatch = m.matches();
		if (isMatch) {
            WishType wt;
			switch (m.group(1)) {
            case "TOY":
                wt = WishType.TOY;
                break;
            case "GADGET":
                wt = WishType.TOY;
                break;
            case "CLOTH":
                wt = WishType.TOY;
                break;
            case "FOOD":
                wt = WishType.TOY;
                break;
            default:
                return false;// bad
            }
            
            wishList.add(m.group(2), new Wish(wt, m.group(2)));
			this.response = "successufully added";
		}
		return isMatch;
    }

    /**
     * Checks if the query is correct <get> command
     * @return
     */
    private boolean getMatch() {
        var p = Pattern.compile("get \"(.+)\"");//^$ are included by matches()
		var m = p.matcher(this.query);
		var isMatch = m.matches();
		if (isMatch) {
            var wish = wishList.get(m.group(1));
			this.response = wish == null ? "no such wish"
                                         : wish.toString();
		}
		return isMatch;
    }
}
