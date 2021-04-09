package asd5;

public class BstTest {
    public static void bstTest() {
        var bst = new BinarySearchTree<Integer, Integer>();

        bst.add(6, 6);
        bst.add(8, 8);
        bst.add(4, 4);
        bst.add(9, 9);
        bst.add(7, 7);
        bst.add(1, 1);
        bst.add(3, 3);
        bst.add(5, 5);
        bst.add(2, 2);
        bst.add(0, 0);

        // 1
        for (var i : bst) {
            System.out.print(i + " ");
        }
        System.out.println("expected 0 1 2 3 4 5 6 7 8 9");

        // 2
        bst.add(6, 6);
        bst.add(8, 8);
        bst.add(4, 4);
        bst.add(9, 9);
        bst.add(7, 7);
        bst.add(1, 1);
        bst.add(3, 3);
        bst.add(5, 5);
        bst.add(2, 2);
        bst.add(0, 0);

        for (var i : bst) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("0 1 2 3 4 5 6 7 8 9 expected");

        // 3
        bst.poll(8);
        for (var i : bst) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("0 1 2 3 4 5 6 7 9 expected (8)");

        // 4
        bst.poll(4);
        for (var i : bst) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("0 1 2 3 5 6 7 9 expected (4)");

        // 5
        bst.poll(1);
        for (var i : bst) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("0 2 3 5 6 7 9 expected (1)");

        // 6
        bst.poll(2);
        for (var i : bst) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("0 3 5 6 7 9 expected (2)");

        // 7
        bst.poll(7);
        for (var i : bst) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("0 3 5 6 9 expected (7)");

        // 8
        bst.poll(0);
        for (var i : bst) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("3 5 6 9 expected (0)");

        // 9
        bst.poll(3);
        for (var i : bst) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("5 6 9 expected (3)");

        // 10
        bst.poll(9);
        for (var i : bst) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("5 6 expected (9)");

        // 11
        bst.poll(6);
        for (var i : bst) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("5 expected (6)");

        // 11
        bst.poll(5);
        for (var i : bst) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("expected none (5)");
    }
}
