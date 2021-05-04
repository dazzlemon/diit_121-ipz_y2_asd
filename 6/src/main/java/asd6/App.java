package asd6;

public class App {
    public static void main(String[] args) {
        var g = new AdjacencyMatrix();

        g.add("A");
        g.add("B");
        g.add("C");
        g.add("D");
        g.add("E");

        g.add("A", "B");

        g.add("B", "A");
        g.add("B", "C");

        g.add("C", "A");
        g.add("C", "E");
        g.add("C", "D");

        g.add("E", "A");

        print(g);

        g.remove("D");
        System.out.println("Remove D");
        print(g);

        g.remove("C");
        System.out.println("Remove C");
        print(g);
    }

    public static void print(Graph g) {
        System.out.print("dfs: ");
        for (var v : g.dfs("A")) {
            System.out.print(v);
        }
        System.out.println();

        System.out.print("bfs: ");
        for (var v : g.bfs("A")) {
            System.out.print(v);
        }
        System.out.println();
    }
}
