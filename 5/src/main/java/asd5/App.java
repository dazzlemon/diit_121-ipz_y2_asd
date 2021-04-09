package asd5;

import java.util.LinkedList;
import java.util.Queue;
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
    private Queue<Wish> wishList = new LinkedList<>();

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
        case "receive":
            if (this.wishList.isEmpty()) {
                this.response = "no wishes available, try to \'wish\' first!(See \'help\')";
            } else {
                var wish = wishList.remove();
                WishCounter.count(wish.getWishType());
                this.response = "received " + wish.toString();
            }
            break;
        case "ls":
            this.response = "";
            for (var wish : wishList) {
                this.response += "\t" + wish.toString() + "\n";
            }
            break;
        case "sz":
            this.response = String.format("%s wishes available", wishList.size());
            break;
        case "stats":
            this.response = WishCounter.statsString();
            break;
        case "help":
            this.response = "Commands:\n"
                          + "\tquit\n"
                          + "\treceive\n"
                          + "\tls - print queue\n"
                          + "\tsz - print amount of elems in queue\n"
                          + "\tstats\n"
                          + "\twish \"<type>\" \"<receiver>\", type = TOY | GADGET | CLOTH | FOOD";
            break;
        default:
            if (!this.wishMatch()) {
			    this.response = String.format("<%s> is incorrect command, try \'help\'", this.query);
		    }
            break;
        }
	}

    /**
	 * Checks if the query is correct <wish> command,
	 * if true resolves it and returns true
	 */
    private boolean wishMatch() {
        // wish "<type>" "<receiver>""
        var p = Pattern.compile("wish \"(.+)\" \"(.+)\"");//^$ are included by matches()
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
            wishList.add(new Wish(wt, m.group(2)));
			this.response = "";
		}
		return isMatch;
    }
}
