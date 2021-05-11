package asd7;

public interface Graph {
    public interface Vertex {
        public String getId();
    }

    /**
     * Adds vertex
     * @param v vertex to add
     */
    public void add(String v);

    /**
     * Adds edge between two vertices
     * @param v1 edge start
     * @param v2 edge end
     */
    public void add(String v1, String v2);

    /**
     * Removes vertex and all its edges
     * @param v vertex to remove
     */
    public void remove(String v);

    /**
     * Removes edge between two vertices
     * @param v1 edge start
     * @param v2 edge end
     */
    public void remove(String v1, String v2);
    
    /**
     * Returns iterable object that traverses Graph with depth first search alogirthm
     * @param start
     * @return
     */
    public Iterable<String> dfs(String start);

    /**
     * Returns iterable object that traverses Graph with breadth first search alogirthm
     * @param start
     * @return
     */
    public Iterable<String> bfs(String start);

    /**
     * @param v
     * @return is [v] in this graph
     */
    public boolean contains(String v);
    
    /**
     * 
     * @param v1
     * @param v2
     * @return is there an edge between [v1] & [v2]
     */
    public boolean isEdge(String v1, String v2);

    /**
     * remove all vertices & edges
     */
    public void clear();

    /**
     * @return size() == 0
     */
    public boolean isEmpty();

    /**
     * @return # of vertices
     */
    public int size();
}
