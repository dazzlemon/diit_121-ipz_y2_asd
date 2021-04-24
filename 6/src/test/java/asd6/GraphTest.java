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
        assertTrue(graph.add());
    }

    @Test
    public final void testRemove() {
        assertFalse(graph.add());
    }

    @Test
    public final void testDfs() {
        assertFalse(graph.dfs());
    }

    @Test
    public final void testBfs() {
        assertFalse(graph.bfs());
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                    new Object[]{new AdjacencyList()},
                    new Object[]{new AdjacencyMatrix()}
        );
    }
}
