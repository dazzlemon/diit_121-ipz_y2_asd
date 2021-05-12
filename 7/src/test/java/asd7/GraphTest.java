package asd7;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.jupiter.api.Assertions;

@RunWith(Parameterized.class)
public class GraphTest {
    public GraphFactory graphFactory;

    public GraphTest(GraphFactory graphFactory) {
        this.graphFactory = graphFactory;
    }

    public void graphInit(Graph graph) {
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
         * @@@@@@@@@@@@@@@@@\--/@@@@@@@@@@@@@@@@@@**@@@@@@@@@****@@@@@@@@
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
        graph.add("C", "A");
    }

    @Test
    public final void testDfs() {
        var graph = graphFactory.graph();
        graphInit(graph);

        var str1 = "";
        for (var v : graph.dfs("A")) {
            str1 += v;
        }

        var str2 = "";
        for (var v : graph.dfs("C")) {
            str2 += v;
        }

        assertTrue(
            graph.getClass().getTypeName() + "::dfs is wrong",
            str1.compareTo("ABEFCD") == 0 && str2.compareTo("CABEFD") == 0
        );
    }

    @Test
    public final void testBfs() {
        var graph = graphFactory.graph();
        graphInit(graph);

        var str1 = "";
        for (var v : graph.bfs("A")) {
            str1 += v;
        }

        var str2 = "";
        for (var v : graph.bfs("C")) {
            str2 += v;
        }

        assertTrue(
            graph.getClass().getTypeName() + "::bfs is wrong",
            str1.compareTo("ABCDEF") == 0 && str2.compareTo("CAFBDE") == 0
        );
    }

    @Test
    public final void testIllegalArgs() {
        var graph = graphFactory.graph();
        graphInit(graph);

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                graph.dfs("M");
            },
            graph.getClass().getTypeName() + "::dfs doesnt throw"
        );

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                graph.bfs("M");
            },
            graph.getClass().getTypeName() + "::bfs doesnt throw"
        );

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                graph.add("A");
            },
            graph.getClass().getTypeName() + "::add already existent vertex doesnt throw"
        );

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                graph.add("A", "B");
            },
            graph.getClass().getTypeName() + "::add already existent edge doesnt throw"
        );

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                graph.add("A", "M");
            },
            graph.getClass().getTypeName() + "::add edge for non existent vertex doesnt throw"
        );

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                graph.remove("M");
            },
            graph.getClass().getTypeName() + "::remove non existent vertex doesnt throw"
        );

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                graph.remove("A", "M");
            },
            graph.getClass().getTypeName() + "::remove edge for non existent vertex doesnt throw"
        );

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                graph.dijkstra("M");
            },
            graph.getClass().getTypeName() + "::dijkstra for non existent source doesnt throw"
        );

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                graph.dijkstra("A").getDist("M");
            },
            graph.getClass().getTypeName() + "::dijkstra::dist for non existent target doesnt throw"
        );

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                graph.dijkstra("A").getTrace("M");
            },
            graph.getClass().getTypeName() + "::dijkstra::trace for non existent target doesnt throw"
        );
    }

    @Test
    public final void testDijkstra() {
        var graph = graphFactory.graph();
        graphInit(graph);

        assertTrue("AA wrong", graph.dijkstra("A").getDist("A") == 0);
        assertTrue("AB wrong", graph.dijkstra("A").getDist("B") == 1);
        assertTrue("AC wrong", graph.dijkstra("A").getDist("C") == 1);
        assertTrue("AD wrong", graph.dijkstra("A").getDist("D") == 1);
        assertTrue("AE wrong", graph.dijkstra("A").getDist("E") == 2);
        assertTrue("AF wrong", graph.dijkstra("A").getDist("F") == 2);

        assertTrue("CC wrong", graph.dijkstra("C").getDist("C") == 0);
        assertTrue("CA wrong", graph.dijkstra("C").getDist("A") == 1);
        assertTrue("CB wrong", graph.dijkstra("C").getDist("B") == 2);
        assertTrue("CD wrong", graph.dijkstra("C").getDist("D") == 2);
        assertTrue("CE wrong", graph.dijkstra("C").getDist("E") == 3);
        assertTrue("CF wrong", graph.dijkstra("C").getDist("F") == 1);
    }


    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
            new Object[]{new AdjacencyListFactory()},
            new Object[]{new AdjacencyMatrixFactory()}
        );
    }
}

interface GraphFactory {
    public Graph graph();
}

class AdjacencyListFactory implements GraphFactory {
    @Override
    public Graph graph() {
        return new AdjacencyList();
    }
}

class AdjacencyMatrixFactory implements GraphFactory {
    @Override
    public Graph graph() {
        return new AdjacencyMatrix();
    }
}
