package asd6;

import java.util.LinkedList;
import java.util.TreeSet;

public class AdjacencyMatrix extends AbstractGraph {
    LinkedList<LinkedList<Boolean>> matrix;
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
        public Iterable<asd6.AbstractGraph.Vertex> neighbours() {
            var list = new LinkedList<AbstractGraph.Vertex>();
            for (int j = 0; j < ids.size(); j++) {
                if (matrix.get(i).get(j)) {
                    list.add(new Vertex(j));
                }
            }
            return list;
        }

        @Override
        public boolean equals(Object other) {
            if (other.getClass() != this.getClass()) {
                return false;
            }
            return i == ((Vertex)other).i;
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
    public void add(String v) {
        if (!ids.contains(v)) {
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
    }

    @Override
    public void add(String v1, String v2) {
        if (ids.contains(v1) && ids.contains(v2) && v1.compareTo(v2) != 0) {
            var i1 = ids.indexOf(v1);
            var i2 = ids.indexOf(v2);
            
            matrix.get(i1).set(i2, true);
        }
    }

    @Override
    public void remove(String v) {
        if (ids.contains(v)) {
            var i = ids.indexOf(v);

            matrix.remove(i);// remove row
            ids.remove(v);// remove id

            for (int row = 0; row < ids.size(); row++) {
                matrix.get(row).remove(i);// remove column
            }
        }
    }

    @Override
    public void remove(String v1, String v2) {
        if (ids.contains(v1) && ids.contains(v2)) {
            var i1 = ids.indexOf(v1);
            var i2 = ids.indexOf(v2);
            
            matrix.get(i1).set(i2, false);
        }
    }

    @Override
    protected Vertex stringToVertex(String v) {
        if (!ids.contains(v)) {
            return null;
        }
        return new Vertex(ids.indexOf(v));
    }
}
