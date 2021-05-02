package asd6;

import java.util.LinkedList;
import java.util.TreeSet;

public class AdjacencyMatrix implements Graph {
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
    public void add(Vertex v) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void add(Vertex v1, Vertex v2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void remove(Vertex v) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void remove(Vertex v1, Vertex v2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Iterable<String> dfs(Vertex start) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<String> bfs(Vertex start) {
        // TODO Auto-generated method stub
        return null;
    }
}
