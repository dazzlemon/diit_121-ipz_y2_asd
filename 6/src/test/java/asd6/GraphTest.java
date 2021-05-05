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
        /**
         * test case
         * expected output:
         *   dfs(A) -> A B E F C D
         *   bfs(A) -> A B C D E F
         * 
         * @@@@@@@@
         * @@    @@
         * @ from @
         * @@    @@
         * @@@**@@@
         * @@@**@@@
         * @@@**@@@
         * @@@**@@@
         * @@\--/@@
         * @@    @@
         * @  to  @
         * @@    @@
         * @@@@@@@@
         *
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    @@@@@@@@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@****  AA  ****@@@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@*******@@    @@****@@@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@@@@@@@@*******@@@@@@**@@@@@****@@@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@@@********@@@@@@@@@@@@**@@@@@@@****@@@@@@@@@@
         * @@@@@@@@@@@@@@@@@\--/@@@@@@@@@@@@@@@@@\--/@@@@@@@@****@@@@@@@@
         * @@@@@@@@@@@@@@    @@@@@@@@@@@@@@@@@@@@    @@@@@@@@@@\--/    @@
         * @@@@@@@@@@@@@  BB  @@@@@@@@@@@@@@@@@@  CC  @@@@@@@@@@@@  DD  @
         * @@@@@@@@@@***@    @***@@@@@@@@@@@@@@@@    @@@@@@@@@@@@@@    @@
         * @@@@@@@@@***@@@@@@@@***@@@@@@@@@@@@***@@@@@@@@@@@@@@@@@@@@@@@@
         * @@@@@@@@***@@@@@@@@@@****@@@@@@@****@@@@@@@@@@@@@@@@@@@@@@@@@@
         * @@    \--/@@@@@@@@@@@@\--/    \--/@@@@@@@@@@@@@@@@@@@@@@@@@@@@
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
    }

    @Test
    public final void testDfs() {
        var str = "";
        for (var v : graph.dfs("A")) {
            str += v;
        }

        assertTrue(
            graph.getClass().getTypeName() + "::dfs is wrong",
            str.compareTo("ABEFCD") == 0
        );
    }

    @Test
    public final void testBfs() {
        var str = "";
        for (var v : graph.bfs("A")) {
            str += v;
        }
        
        assertTrue(
            graph.getClass().getTypeName() + "::bfs is wrong",
            str.compareTo("ABCDEF") == 0
        );
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
            new Object[]{new AdjacencyList()},
            new Object[]{new AdjacencyMatrix()}
        );
    }
}
