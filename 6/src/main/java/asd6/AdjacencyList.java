package asd6;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public final class AdjacencyList extends AbstractGraph {// no multimap in java...
    SortedMap<String, NavigableSet<String>> map = new TreeMap<>();

    @Override
    public void add(String v) {
        if (contains(v)) {
            throw new IllegalArgumentException();
        }
        map.put(v, new TreeSet<>());
    }

    @Override
    public void add(String v1, String v2) {
        if (!contains(v1) || !contains(v2)) {
            throw new IllegalArgumentException();
        }
        if (v1.compareTo(v2) == 0) {
            throw new IllegalArgumentException();
        }
        map.get(v1).add(v2);
    }

    @Override
    public void remove(String v) {
        if (!contains(v)) {
            throw new IllegalArgumentException();
        }
        map.remove(v);

        for (var k : map.keySet()) {
            map.get(k).remove(v);
        }
    }

    @Override
    public void remove(String v1, String v2) {
        if (!contains(v1) || !contains(v2)) {
            throw new IllegalArgumentException();
        }
        map.get(v1).remove(v2);
    }

    private class Vertex extends AbstractGraph.Vertex {
        String id;

        Vertex(String id) {
            this.id = id;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public ReverseIterable<AbstractGraph.Vertex> neighbours() {
            return new VertexSet(id);
        }
    }

    private class VertexSet implements ReverseIterable<AbstractGraph.Vertex> {
        private boolean reversed = false;
        private String root;

        VertexSet(String root) {
            this.root = root;
        }
        
        @Override
        public Iterator<AbstractGraph.Vertex> iterator() {
            return new VertexSetIterator(reversed, root);
        }

        @Override
        public void reverse() {
            reversed = !reversed; 
        }
    }

    private class VertexSetIterator implements Iterator<AbstractGraph.Vertex> {
        private Iterator<String> it;
        
        VertexSetIterator(boolean reversed, String root) {
            it = reversed ? map.get(root).descendingIterator()
                          : map.get(root).iterator();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public asd6.AbstractGraph.Vertex next() {
            return new Vertex(it.next());
        }
    }

    @Override
    protected Vertex stringToVertex(String v) {
        if (!map.containsKey(v)) {
            throw new IllegalArgumentException();
        }
        return new Vertex(v);
    }

    @Override
    public boolean contains(String v) {
        return map.containsKey(v);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.keySet().size();
    }

    @Override
    public boolean isEdge(String v1, String v2) {
        if (!contains(v1) || !contains(v2)) {
            throw new IllegalArgumentException();
        }
        return map.get(v1).contains(v2);
    }
}
