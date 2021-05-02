package asd6;

import java.util.LinkedList;
import java.util.TreeSet;

public class AdjacencyMatrix extends AbstractGraph {
    LinkedList<LinkedList<Boolean>> matrix;
    TreeSetIndexed<String> ids;
    
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
            // TODO
        }
    }

    @Override
    public void add(String v1, String v2) {
        if (ids.contains(v1) && ids.contains(v2)) {
            // TODO
        }
    }

    @Override
    public void remove(String v) {
        if (ids.contains(v)) {
            // TODO
        }
    }

    @Override
    public void remove(String v1, String v2) {
        if (ids.contains(v1) && ids.contains(v2)) {
            // TODO
        }
    }

    @Override
    protected Vertex stringToVertex(String v) {
        // TODO
        return null;
    }
}
