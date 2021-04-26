package asd6;

public interface Graph {
    public interface Vertex {
        public String getId();
    }

    /**
     * Adds vertex
     * @param v vertex to add
     */
    public void add(Vertex v);

    /**
     * Adds edge between two vertices
     * @param v1 edge start
     * @param v2 edge end
     */
    public void add(Vertex v1, Vertex v2);

    /**
     * Removes vertex and all its edges
     * @param v vertex to add
     */
    public void remove(Vertex v);

    /**
     * Removes edge between two vertices
     * @param v1 edge start
     * @param v2 edge end
     */
    public void remove(Vertex v1, Vertex v2);
    
    /**
     * Returns iterable object that traverses Graph with depth first search alogirthm
     * @param start
     * @return
     */
    public Iterable<String> dfs(Vertex start);

    /**
     * Returns iterable object that traverses Graph with breadth first search alogirthm
     * @param start
     * @return
     */
    public Iterable<String> bfs(Vertex start);
}
