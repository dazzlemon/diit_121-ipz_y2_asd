package asd6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public abstract class AbstractGraph implements Graph {
    protected abstract class Vertex implements Graph.Vertex {
        /**
         * Returns neighbours in reverse order(they'll go trough stack and will be in normal order)
         * @return neighbours
         */
        public abstract Iterable<Vertex> neighbours();
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

    private Iterable<Vertex> search(Vertex v, boolean dfs) {
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
        var collection = dfs ? new StackWrapper<Vertex>()
                             : new QueueWrapper<Vertex>();
        collection.push(v);
        var discovered = new Stack<Vertex>();
        while (!collection.isEmpty()) {
            v = collection.pop();
            if (discovered.search(v) == -1) {
                discovered.push(v);

                var vns = v.neighbours();
                if (dfs) {
                    vns = reverse(vns);
                }
                for (var w : vns) {
                    collection.push(w);
                }
            }
        }
        return discovered;
    }

    private Iterable<Vertex> reverse(Iterable<Vertex> it) {
        var newIt = new LinkedList<Vertex>();
        for (var v : it) {
            newIt.addFirst(v);
        }
        return newIt;
    }

    protected abstract Vertex stringToVertex(String v);

    @Override
    public final Iterable<String> dfs(String v) {// mb make own object to be faster?
        var res = new Stack<String>();
        for (var i : search(stringToVertex(v), true)) {
            res.push(i.getId());
        }
        return res;
    }

    @Override
    public final Iterable<String> bfs(String v) {// mb make own object to be faster?
        var res = new Stack<String>();
        for (var i : search(stringToVertex(v), false)) {
            res.push(i.getId());
        }
        return res;
    }
}
