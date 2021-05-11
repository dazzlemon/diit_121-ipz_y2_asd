package asd7;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        var io = new IO();
        io.run();
    }
}

class IO {
    interface Command {
        String run(String... args);
        String getName();
        String getDescription();
        int getMinArgs();
        int getMaxArgs();
    }

    abstract class Command0args implements Command {
        @Override
        public int getMinArgs() {
            return 0;
        }

        @Override
        public int getMaxArgs() {
            return 0;
        }
    }

    abstract class Command1arg implements Command {
        @Override
        public int getMinArgs() {
            return 1;
        }

        @Override
        public int getMaxArgs() {
            return 1;
        }
    }

    abstract class Command2args implements Command {
        @Override
        public int getMinArgs() {
            return 2;
        }

        @Override
        public int getMaxArgs() {
            return 2;
        }
    }

    abstract class Command1or2args extends Command1arg {
        @Override
        public int getMaxArgs() {
            return 2;
        }
    }

    IO() {
        // graph.add("A");
        // graph.add("B");
        // graph.add("C");
        // graph.add("D");
        // graph.add("E");
        // graph.add("F");

        // graph.add("A", "B");
        // graph.add("A", "C");
        // graph.add("A", "D");

        // graph.add("B", "E");
        // graph.add("B", "F");

        // graph.add("C", "F");
        // graph.add("C", "A");

        commands = new Command[] {
            new Command0args() {
                @Override
                public String run(String... args) {
                    isRunning = false;
                    return "";
                }

                @Override
                public String getName() {
                    return "quit";
                }

                @Override
                public String getDescription() {
                    return "";
                }
            },
            new Command0args() {
                @Override
                public String run(String... args) {
                    return "size: " + graph.size();
                }

                @Override
                public String getName() {
                    return "size";
                }

                @Override
                public String getDescription() {
                    return "";
                }
            },
            new Command0args() {
                @Override
                public String run(String... args) {
                    graph.clear();
                    return "cleared";
                }

                @Override
                public String getName() {
                    return "clear";
                }

                @Override
                public String getDescription() {
                    return "";
                }
            },
            new Command0args() {
                @Override
                public String run(String... args) {
                    var str = "Commands:\n";
                    for (var c : commands) {
                        str += "\t" + c.getName() + " " + c.getDescription() + "\n";
                    }
                    return str;
                }

                @Override
                public String getName() {
                    return "help";
                }

                @Override
                public String getDescription() {
                    return "";
                }
            },
            new Command1arg() {
                @Override
                public String run(String... args) {
                    String str;
                    try {
                        str = "\t" + graph.contains(args[0]);
                    } catch (IllegalArgumentException e) {
                        str = "\t" + e.getMessage();
                    }
                    return str;
                }

                @Override
                public String getName() {
                    return "contains";
                }

                @Override
                public String getDescription() {
                    return "\"<v>\"";
                }
            },
            new Command1arg() {
                @Override
                public String run(String... args) {
                    String str;
                    try {
                        str = "\t";
                        for (var w : graph.dfs(args[0])) {
                            str += w;
                        }
                    } catch (IllegalArgumentException e) {
                        str = "\t" + e.getMessage();
                    }
                    return str;
                }

                @Override
                public String getName() {
                    return "dfs";
                }

                @Override
                public String getDescription() {
                    return "\"<start>\"";
                }
            },
            new Command1arg() {
                @Override
                public String run(String... args) {
                    String str;
                    try {
                        str = "\t";
                        for (var w : graph.bfs(args[0])) {
                            str += w;
                        }
                    } catch (IllegalArgumentException e) {
                        str = "\t" + e.getMessage();
                    }
                    return str;
                }

                @Override
                public String getName() {
                    return "bfs";
                }

                @Override
                public String getDescription() {
                    return "\"<start>\"";
                }
            },
            new Command1or2args() {
                @Override
                public String run(String... args) {
                    String str;
                    try {
                        if (args.length == 1 || args[1] == null) {
                            graph.add(args[0]);
                            str = String.format(
                                "\tSuccessfully added vertex \"%s\"",
                                args[0]
                            );
                        } else {// == 2s
                            graph.add(args[0], args[1]);
                            str = String.format(
                                "\tSuccessfully added edge from \"%s\" to \"%s\"",
                                args[0], args[1]
                            );
                        }
                    } catch (IllegalArgumentException e) {
                        str = "\t" + e.getMessage();
                    }
                    return str;
                }

                @Override
                public String getName() {
                    return "add";
                }

                @Override
                public String getDescription() {
                    return "\"<v1>\"[ \"<v2>\"]";
                }
            },
            new Command1or2args() {
                @Override
                public String run(String... args) {
                    String str;
                    try {
                        if (args.length == 1 || args[1] == null) {
                            graph.remove(args[0]);
                            str = String.format(
                                "\tSuccessfully removeed vertex \"%s\"",
                                args[0]
                            );
                        } else {// == 2s
                            graph.remove(args[0], args[1]);
                            str = String.format(
                                "\tSuccessfully removed edge from \"%s\" to \"%s\"",
                                args[0], args[1]
                            );
                        }
                    } catch (IllegalArgumentException e) {
                        str = "\t" + e.getMessage();
                    }
                    return str;
                }

                @Override
                public String getName() {
                    return "remove";
                }

                @Override
                public String getDescription() {
                    return "\"<v1>\"[ \"<v2>\"]";
                }
            },
            new Command1or2args() {
                @Override
                public String run(String... args) {
                    String str = "";
                    var dijkstra = graph.dijkstra(args[0]);
                    if (args.length == 2 && args[1] != null) {
                        String trace = "\t";
                        for (var v : dijkstra.getTrace(args[1])) {
                            trace += v + " ";
                        }
                        str = String.format(
                            "Path from %s to %s is %s long\n" +
                            trace, args[0], args[1], dijkstra.getDist(args[1])
                        );
                    } else {// == 1
                        str += "from to dist\n";
                        for (var v : graph.dfs(args[0])) {
                            str += String.format(
                                "   %s  %s    %s\n", 
                                args[0], v, dijkstra.getDist(v)
                            );
                        }
                    }
                    return str;
                }

                @Override
                public String getName() {
                    return "dijkstra";
                }

                @Override
                public String getDescription() {
                    return "\"<source>\"[ \"<target>\"]";
                }
            },
            new Command2args() {
                @Override
                public String run(String... args) {
                    String str;
                    try {
                        str = "\t" + graph.isEdge(args[0], args[1]);
                    } catch (IllegalArgumentException e) {
                        str = "\t" + e.getMessage();
                    }
                    return str;
                }

                @Override
                public String getName() {
                    return "isEdge";
                }

                @Override
                public String getDescription() {
                    return "\"<v1>\" \"<v2>\"";
                }
            }
        };
    }

    private Command[] commands;

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
        var p = Pattern.compile("(\\S+)( \"([^\"]+)\")?( \"([^\"]+)\")?");//^$ are included by matches()
        var m = p.matcher(query);
        if (m.matches()) {
            var commandName = m.group(1);
            var arg1 = m.group(3);
            var arg2 = m.group(5);
            var nArgs = arg1 == null ? 0
                                     : arg2 == null ? 1
                                                    : 2;
            var found = false;
            for (int i = 0; i < commands.length && !found; i ++) {
                var c = commands[i];
                if (c.getName().compareTo(commandName) == 0) {
                    found = true;
                    if (c.getMaxArgs() >= nArgs && c.getMinArgs() <= nArgs) {
                        response = c.run(arg1, arg2);
                    } else {
                        response = String.format("wrong amount of args, try \'help\'", query);
                    }
                }
            }
            if (!found) {
                response = String.format("<%s> is incorrect command, try \'help\'", query);
            }
        } else {
            response = String.format("<%s> is incorrect command, try \'help\'", query);
        }
	}
}
