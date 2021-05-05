package asd6;

import java.util.LinkedList;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class AdjacencyList extends AbstractGraph {// no multimap in java...
    SortedMap<String, SortedSet<String>> map = new TreeMap<>();

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
        public Iterable<asd6.AbstractGraph.Vertex> neighbours() {
            var list = new LinkedList<AbstractGraph.Vertex>();
            for (var v : map.get(id)) {
                list.add(new Vertex(v));
            }
            return list;
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
