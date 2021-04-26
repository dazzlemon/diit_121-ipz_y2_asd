package asd6;

import java.util.LinkedList;

public class AdjacencyMatrix implements Graph {
    LinkedList<LinkedList<Boolean>> matrix;
    LinkedList<String> ids;
    
    AdjacencyMatrix() {
        matrix = new LinkedList<>();
        ids    = new LinkedList<>();
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
