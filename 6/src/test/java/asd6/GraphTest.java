package asd6;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class GraphTest {
    public Graph graph;

    public GraphTest(Graph graph) {
        this.graph = graph;
    }

    @Test
    public final void testAdd() {
        graph.add(" ");
        assertTrue(true);
    }

    @Test
    public final void testRemove() {
        graph.remove(" ");
        assertTrue(true);
    }

    @Test
    public final void testDfs() {
        /**
         * test case for dfs(A)
         * expected output: A B E F C D
         * 
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    @@@@@@@@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  AA  @@@@@@@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@***@@    @@***@@@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@@@@@@@@*********@@@@**@@@@@***@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@********@@@@@@@@@@@@**@@@@@@@***@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@***@@@@@@@@@@@@@@@@@@**@@@@@@@@@***@@@@@@@@@
         * @@@@@@@@@@@@@@    @@@@@@@@@@@@@@@@@@@@    @@@@@@@@@@***@    @@
         * @@@@@@@@@@@@@  BB  @@@@@@@@@@@@@@@@@@  CC  @@@@@@@@@@@@  DD  @
         * @@@@@@@@@@***@    @***@@@@@@@@@@@@@@@@    @@@@@@@@@@@@@@    @@
         * @@@@@@@@@***@@@@@@@@***@@@@@@@@@@@@***@@@@@@@@@@@@@@@@@@@@@@@@
         * @@@@@@@@***@@@@@@@@@@***@@@@@@@@@***@@@@@@@@@@@@@@@@@@@@@@@@@@
         * @@    @***@@@@@@@@@@@@@**@    @***@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         * @  EE  @@@@@@@@@@@@@@@@@@  FF  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         * @@    @@@@@@@@@@@@@@@@@@@@    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         */
        graph.add("A");
        graph.add("B");
        graph.add("C");
        graph.add("D");
        graph.add("E");
        graph.add("F");

        graph.add("A", "B");
        graph.add("A", "C");
        graph.add("A", "D");

        graph.add("B", "E");
        graph.add("B", "F");

        graph.add("C", "F");

        var str = "";

        for (var v : graph.dfs("A")) {
            str += v;
        }

        assertTrue(str.compareTo("ABEFCD") == 0);
    }

    @Test
    public final void testBfs() {
        /**
         * test case for bfs
         * expected output: A B C D E F
         * 
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    @@@@@@@@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  AA  @@@@@@@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@***@@    @@***@@@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@@@@@@@@*********@@@@**@@@@@***@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@********@@@@@@@@@@@@**@@@@@@@***@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@***@@@@@@@@@@@@@@@@@@**@@@@@@@@@***@@@@@@@@@
         * @@@@@@@@@@@@@@    @@@@@@@@@@@@@@@@@@@@    @@@@@@@@@@***@    @@
         * @@@@@@@@@@@@@  BB  @@@@@@@@@@@@@@@@@@  CC  @@@@@@@@@@@@  DD  @
         * @@@@@@@@@@***@    @***@@@@@@@@@@@@@@@@    @@@@@@@@@@@@@@    @@
         * @@@@@@@@@***@@@@@@@@***@@@@@@@@@@@@***@@@@@@@@@@@@@@@@@@@@@@@@
         * @@@@@@@@***@@@@@@@@@@***@@@@@@@@@***@@@@@@@@@@@@@@@@@@@@@@@@@@
         * @@    @***@@@@@@@@@@@@@**@    @***@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         * @  EE  @@@@@@@@@@@@@@@@@@  FF  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         * @@    @@@@@@@@@@@@@@@@@@@@    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         */
        graph.add("A");
        graph.add("B");
        graph.add("C");
        graph.add("D");
        graph.add("E");
        graph.add("F");

        graph.add("A", "B");
        graph.add("A", "C");
        graph.add("A", "D");

        graph.add("B", "E");
        graph.add("B", "F");

        graph.add("C", "F");

        var str = "";

        for (var v : graph.bfs("A")) {
            str += v;
        }

        System.out.println(str);
        assertTrue(str.compareTo("ABCDEF") == 0);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                    new Object[]{new AdjacencyMatrix()},// new Object[]{new AdjacencyList()},
                    new Object[]{new AdjacencyMatrix()}
        );
    }
}
