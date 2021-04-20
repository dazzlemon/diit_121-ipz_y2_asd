package prac;

import java.util.Stack;
import java.util.Iterator;

public class RbTree <Key extends Comparable<Key>, Data> implements Iterable<Data> {
    private class Node {
        public Key key;
        public Data data;

        public Node left;
        public Node right;
        public Node parent;

        public boolean isBlack;// if false -> isRed

        public Node(Key key, Data data, Node parent) {
            this.key  = key;
            this.data = data;
        }

        @Override
        public String toString() {
            return String.format(
                "RbTree::Node: {key: %s, data: %s,\n\tleft: %s,\n\tright: %s, color}", 
                                key,     data,        left,        right,     isBlack ? "BLACK" : "RED"    
            );
        }
    }


    private Node root;


    public void add(Key key, Data data) {
        var p = parent(key);
        var n = new Node(key, data, p);
        if (p == null) {// root == null
            root = n;
            root.isBlack = true;
        } else {
            if (p.key.compareTo(key) > 0) {
                p.left = n;
            } else {
                p.right = n;
            }
        }
    }


    private Node parent(Key key) {
        var curr = root;
        var next = root;
        while (next != null && next.key != key) {
            curr = next;
            next = key.compareTo(curr.key) < 0 ? curr.left
                                               : curr.right;
        }
        return curr;
    }


    private Node grandparent(Node node) {
        return node.parent == null ? null
                                   : node.parent.parent;
    }


    private Node uncle(Node node) {
        var gp = grandparent(node);
        return gp == null ? null
                          : gp.right == node.parent ? gp.left
                                                    : gp.right;
    }


    private void case1(Node node) {
        if (node == root && !node.isBlack) {
            node.isBlack = true;
        } else {
            case2(node);
        }
    }


    private void case2(Node node) {
        if (!node.parent.isBlack) {
            case3(node);
        }
    }

    private void case3(Node node) {
        var u = uncle(node);
        if (!node.parent.isBlack && u != null & !u.isBlack) {
            node.parent.isBlack = true;
            u.isBlack           = true;
            u.parent.isBlack    = false;
            case1(u.parent);
        }
    }


    @Override
    public RbtIterator iterator() {
        return new RbtIterator();
    }


    class RbtIterator implements Iterator<Data> {
        private Stack<Node> stack = new Stack<>();
        private Node curr = root;


        @Override
        public boolean hasNext() {
            return !stack.empty() || curr != null;
        }


        public Data next() {
            while (true) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    var ret = curr.data;
                    curr = curr.right;
                    return ret;
                }
            }
        }
    }
}
