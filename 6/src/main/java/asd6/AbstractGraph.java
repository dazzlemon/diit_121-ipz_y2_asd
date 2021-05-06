package asd6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        public int compareTo(Vertex arg0) {
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

    private Iterable<String> search(String vId, boolean dfs) {
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

    /* prolly has to throw something */
    protected abstract Vertex stringToVertex(String v);

    @Override
    public final Iterable<String> dfs(String v) {
        return search(v, true);
    }

    @Override
    public final Iterable<String> bfs(String v) {
        return search(v, false);
    }
}
