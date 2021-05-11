package asd7;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public abstract class AbstractGraph implements Graph {
    interface ReverseIterable <T extends Comparable<T>> extends Iterable <T> {
        /**
         * reverse the order of elements in collection
         */
        void reverse();
    }

    protected abstract class Vertex 
            implements Graph.Vertex, Comparable<Vertex> {
        /**
         * Returns neighbours in natural order
         * @return neighbours
         */
        public abstract ReverseIterable<Vertex> neighbours();


        @Override
        public final int compareTo(Vertex arg0) {
            return getId().compareToIgnoreCase(arg0.getId());
        }
    }

    private abstract class PushPopCollection <T> {
        public PushPopCollection() {}

        public abstract void push(T t);
        public abstract T pop();
        public abstract boolean isEmpty();
    }

    private class StackWrapper <T> extends PushPopCollection <T> {
        Stack<T> stack;
        
        StackWrapper() {
            stack = new Stack<>();
        }

        @Override
        public void push(T t) {
            stack.push(t);
        }

        @Override
        public T pop() {
            return stack.pop();
        }

        @Override
        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    private class QueueWrapper <T> extends PushPopCollection <T> {
        Queue<T> queue;

        QueueWrapper() {
            queue = new LinkedList<>();
        }

        @Override
        public void push(T t) {
            queue.add(t);
        }

        @Override
        public T pop() {
            return queue.remove();
        }

        @Override
        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    private Iterable<String> search(String vId, boolean dfs)
            throws IllegalArgumentException {
        /**
         * 1st iterative algorithm from wiki
         * https://en.wikipedia.org/wiki/Depth-first_search
         * =====================================================================
         * procedure DFS_iterative(G, v) is
         *      let S be a stack
         *      S.push(v)
         *      while S is not empty do
         *          v = S.pop()
         *          if v is not labeled as discovered then
         *              label v as discovered
         *              for all edges from v to w in G.adjacentEdges(v) do 
         *                  S.push(w)
         * =====================================================================
         * if stack is replaced with queue we'll get bfs
         */
        var v = stringToVertex(vId);
        var collection = dfs ? new StackWrapper<Vertex>()
                             : new QueueWrapper<Vertex>();
        collection.push(v);
        var discovered = new Stack<String>();
        while (!collection.isEmpty()) {
            v = collection.pop();
            if (!discovered.contains(v.getId())) {
                discovered.push(v.getId());

                var vns = v.neighbours();
                if (dfs) {
                    vns.reverse();
                }
                
                for (var w : vns) {
                    collection.push(w);
                }
            }
        }
        return discovered;
    }

    class Dijkstra implements Graph.Dijkstra {
        Map<String, Integer> dist;
        Map<String, String> prev;
        
        String from;

        Dijkstra(Map<String, Integer> dist, Map<String, String> prev, String from) {
            this.dist = dist;
            this.prev = prev;
            this.from = from;
        }

        @Override
        public int getDist(String to) {
            for (var k : dist.keySet()) {
                System.out.println(k + " " + dist.get(k));
            }
            return dist.get(to);
        }
    }

    @Override
    public Dijkstra dijkstra(String source) {
        /**
         * https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
         * 1. Mark all nodes unvisited.
         * 2. Assign to every node a distance value:
         *      set it to zero for our initial node,
         *             to infinity for all other nodes.
         *    Set the initial node as current.
         * 3. For the current node, consider all of its unvisited neighbours
         *    and calculate their distances through the current node.
         *    Compare the newly calculated distance to the current
         *    assigned value and assign the smaller one.
         * 4. When we are done considering all of the unvisited neighbours
         *    of the current node, mark the current node as visited.
         *    A visited node will never be checked again.
         * 5. If the smallest distance among the nodes
         *    in the unvisited set is infinity, then stop.
         *    The algorithm has finished.
         * 6. Otherwise, select the unvisited node that is marked with
         *    the smallest distance, set it as the new "current node",
         *    and go back to step 3.
         */

        var visited = new TreeSet<String>();

        // distance from source to target
        var dist = new TreeMap<String, Integer>();
        dist.put(source, 0);

        // trace from target to source
        var prev = new TreeMap<String, String>();

        // all nodes with connection to source
        var priorityQueue = new PriorityQueue<>((Vertex a, Vertex b) -> {
            var distA = dist.containsKey(a.getId()) ? dist.get(a.getId())
                                                    : Integer.MAX_VALUE;
            var distB = dist.containsKey(b.getId()) ? dist.get(b.getId())
                                                    : Integer.MAX_VALUE;
            return Integer.compare(distA, distB);
        });// returns one with smallest distance
        for (var v : dfs(source)) {
            priorityQueue.add(stringToVertex(v));
        }

        while (!priorityQueue.isEmpty()) {
            var u = priorityQueue.poll();
            for (var v : u.neighbours()) {
                if (!visited.contains(v.getId())) {
                    var oldDist = dist.get(v.getId());// dist from source to V
                    var distU = dist.get(u.getId());// dist from source to U

                    var edgeWeight = 1;
                    var newDist = distU + edgeWeight;// new dist from source to V

                    if (oldDist == null || newDist < oldDist) {
                        dist.remove(v.getId());
                        dist.put(v.getId(), newDist);
                        
                        prev.remove(v.getId());
                        prev.put(v.getId(), u.getId());
                    }
                }
            }
            visited.add(u.getId());
        }
        return new Dijkstra(dist, prev, source);
    }

    /**
     * 
     * @param v
     * @return
     * @throws IllegalArgumentException when contains(v) -> false
     */
    protected abstract Vertex stringToVertex(String v)
        throws IllegalArgumentException;

    @Override
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public final Iterable<String> dfs(String v)
            throws IllegalArgumentException {
        return search(v, true);
    }

    @Override
    public final Iterable<String> bfs(String v)
            throws IllegalArgumentException {
        return search(v, false);
    }
}
