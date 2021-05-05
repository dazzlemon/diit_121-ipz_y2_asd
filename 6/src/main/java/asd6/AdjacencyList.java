package asd6;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class AdjacencyList extends AbstractGraph {// no multimap in java...
    SortedMap<String, NavigableSet<String>> map = new TreeMap<>();

    @Override
    public void add(String v) {
        if (!map.containsKey(v)) {
            map.put(v, new TreeSet<>());
        }
    }

    @Override
    public void add(String v1, String v2) {
        if (map.containsKey(v1) && map.containsKey(v2) && v1.compareTo(v2) != 0) {
            map.get(v1).add(v2);
        }
    }

    @Override
    public void remove(String v) {
        if (map.containsKey(v)) {
            map.remove(v);

            for (var k : map.keySet()) {
                map.get(k).remove(v);
            }
        }
    }

    @Override
    public void remove(String v1, String v2) {
        if (map.containsKey(v1) && map.containsKey(v2)) {
            map.get(v1).remove(v2);
        }
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
        
        @Override
        public boolean equals(Object other) {
            if (other.getClass() != this.getClass()) {
                return false;
            }
            return id == ((Vertex)other).id;
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
            return null;
        }
        return new Vertex(v);
    }
}
