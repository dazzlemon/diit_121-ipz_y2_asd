package asd6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public final class AdjacencyMatrix extends AbstractGraph {
    LinkedList<LinkedList<Boolean>> matrix;// true - edge, false - no edge
    TreeSetIndexed<String> ids;
    
    private class Vertex extends AbstractGraph.Vertex {
        int i;

        public Vertex(int i) {
            this.i = i;
        }

        @Override
        public String getId() {
            return ids.get(i);
        }

        @Override
        public ReverseIterable<AbstractGraph.Vertex> neighbours() {
            return new VertexSet(i);
        }
    }

    private class VertexSet implements ReverseIterable<AbstractGraph.Vertex> {
        private boolean reversed = false;
        private int rootI;

        VertexSet(int rootI) {
            this.rootI = rootI;
        }
        
        @Override
        public Iterator<AbstractGraph.Vertex> iterator() {
            return new VertexSetIterator(reversed, rootI);
        }

        @Override
        public void reverse() {
            reversed = !reversed; 
        }
    }

    private class VertexSetIterator implements Iterator<AbstractGraph.Vertex> {
        private boolean reversed;
        private int rootI;
        private int i;
        
        VertexSetIterator(boolean reversed, int rootI) {
            this.reversed = reversed;
            this.rootI = rootI;
            while (i < ids.size() && !isITrue()) {// first ::next
                i++;
            }
        }

        @Override
        public boolean hasNext() {
            return i < ids.size() && isITrue();
        }

        @Override
        public asd6.AbstractGraph.Vertex next() {
            var nextV = new Vertex(mappedI());
            do {
                i++;
            } while (i < ids.size() && !isITrue());
            return nextV;
        }

        /**
         * checks if i-th or (ids.size - 1 - i)th is true
         * @return
         */
        private boolean isITrue() {
            return matrix.get(rootI).get(mappedI());
        }

        private int mappedI() {
            return reversed ? ids.size() - 1 - i
                            : i;
        }
    }

    private class TreeSetIndexed <T extends Comparable<T>> extends TreeSet <T> {
        public T get(int i) {
            int j = 0;
            for (var e : this) {
                if (i == j) {
                    return e;
                }
                j++;
            }
            return null;
        }

        public int indexOf(T t) {
            int i = 0;
            for (var e : this) {
                if (e.compareTo(t) == 0) {
                    return i;
                }
                i++;
            }
            return -1;
        }
    }

    AdjacencyMatrix() {
        matrix = new LinkedList<>();
        ids    = new TreeSetIndexed<>();
    }
    
    @Override
    public void add(String v) throws IllegalArgumentException {
        if (contains(v)) {
            throw new IllegalArgumentException(
                "Attempt to add vertex that is already in the graph"
            );
        }

        ids.add(v);
        var i = ids.indexOf(v);

        matrix.add(i, new LinkedList<>());// new row
        
        for (int col = 0; col < ids.size() - 1; col++) {// -1 to set column later
            matrix.get(i).add(false);// no edges at first
        }

        for (int row = 0; row < ids.size(); row++) {// add new column to each row
            matrix.get(row).add(i, false);// no edges at first
        }
    }

    @Override
    public void add(String v1, String v2) {
        if (v1.compareTo(v2) == 0) {
            throw new IllegalArgumentException(
                "Attempt to create edge between one vertex"
            );
        }
        if (!contains(v1) || !contains(v2)) {
            throw new IllegalArgumentException(
                "Attempt to create edge between non existent vertices"
            );
        }
        if (isEdge(v1, v2)) {
            throw new IllegalArgumentException(
                "Attempt to create already existent edge"
            );
        }

        var i1 = ids.indexOf(v1);
        var i2 = ids.indexOf(v2);
        
        matrix.get(i1).set(i2, true);
    }

    @Override
    public void remove(String v) {
        if (!contains(v)) {
            throw new IllegalArgumentException(
                "Attempt to remove non existent vertex"
            );
        }
        
        var i = ids.indexOf(v);

        matrix.remove(i);// remove row
        ids.remove(v);// remove id

        for (int row = 0; row < ids.size(); row++) {
            matrix.get(row).remove(i);// remove column
        }
    }

    @Override
    public void remove(String v1, String v2) {
        if (!contains(v1) || !contains(v2)) {
            throw new IllegalArgumentException(
                "Attempt to remove edge between non existent vertices"
            );
        }

        var i1 = ids.indexOf(v1);
        var i2 = ids.indexOf(v2);
        
        matrix.get(i1).set(i2, false);
    }

    @Override
    protected Vertex stringToVertex(String v) {
        if (!contains(v)) {
            throw new IllegalArgumentException(
                "Attempt to convert string to vertex that is not in this graph"
            );
        }
        return new Vertex(ids.indexOf(v));
    }

    @Override
    public boolean contains(String v) {
        return ids.contains(v);
    }

    @Override
    public void clear() {
        ids.clear();
        matrix.clear();
    }

    @Override
    public int size() {
        return ids.size();
    }

    @Override
    public boolean isEdge(String v1, String v2) {
        if (!contains(v1) || !contains(v2)) {
            throw new IllegalArgumentException(
                "Attempt to check for edge between non existent vertices"
            );
        }
        var i1 = ids.indexOf(v1);
        var i2 = ids.indexOf(v2);

        return matrix.get(i1).get(i2);
    }
}
