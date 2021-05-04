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

        for (var v : g.dfs("A")) {
            System.out.println(v);
        }
    }
}
