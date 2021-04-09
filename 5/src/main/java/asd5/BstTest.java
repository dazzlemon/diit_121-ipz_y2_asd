package asd5;

import java.util.ArrayList;
import java.util.Arrays;

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
        System.out.println();
        System.out.println("0 1 2 3 4 5 6 7 8 9 expected");

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
        var removeOrder = Arrays.asList(8, 4, 1, 2, 7, 0, 3, 9, 6, 5);
        var ord = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        for (var i : removeOrder) {
            bst.poll(i);
            ord.remove(i);

            for (var j : bst) {
                System.out.print(j + " ");
            }
            System.out.println();

            for (var j : ord) {
                System.out.print(j + " ");
            }
            System.out.println("expected (" + i + ")");
        }
    }
}
