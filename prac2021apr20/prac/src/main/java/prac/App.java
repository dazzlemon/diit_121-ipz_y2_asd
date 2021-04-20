package prac;

import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter #nodes: ");
        var n = s.nextInt();
        var tree = new RbTree<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            System.out.println("val?: ");
            var v = s.nextInt();
            tree.add(v, v);
            for (var j : tree) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

