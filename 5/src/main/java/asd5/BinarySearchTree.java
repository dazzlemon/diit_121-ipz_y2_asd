package asd5;

import java.util.Stack;

public class BinarySearchTree <Key extends Comparable<Key>, Data> {
    private class Node {
        public Key key;
        public Data data;
        public Node left = null;
        public Node right = null;


        public Node(Key key, Data data) {
            this.key = key;
            this.data = data;
        }
    }


    private Node root = null;


    /**
     * Returns data of node by key.
     * @param key to search by
     * @return Data of node with key, or null if it doesnt exist
     */
    public Data get(Key key) {
        return null;
    }


    /**
     * Adds or replaces data by key.
     * @param data
     * @param key
     */
    public void add(Key key, Data data) {
        var newNode = new Node(key, data);

        var curr = root;
        var next = root;
        while (next != null && next.key != key) {
            curr = next;

            if (key.compareTo(curr.key) < 0) {
                next = curr.left;    
            } else {
                next = curr.right;
            }
        }
        if (curr == null) {
            root = newNode;
        } else {
            if (key.compareTo(curr.key) < 0) {
                curr.left = newNode;
            } else {
                curr.right = newNode;
            }
        }

        // Node curr = root;
        // Node prev = null;

        // while (curr != null) {
        //     prev = curr;
        //     if (key.compareTo(curr.key) < 0) {
        //         curr = curr.left;
        //     } else {
        //         curr = curr.right;
        //     }
        // }
        // if (prev == null) {
        //     prev = newNode;
        //     root = prev;
        // } else if (key.compareTo(prev.key) < 0) {
        //     prev.left = newNode;
        // } else {
        //     prev.right = newNode;
        // }
    }


    /**
     * Same as get, but removes node from collection.
     * @param key to search by
     * @return Data of node, or null.
     */
    public Data poll(Key key) {
        return null;//tmp
    }


    //in order
    void inOrder() {
        var stack = new Stack<Node>();
        var curr = root;
        while(!stack.empty() || curr != null){
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                curr = stack.pop();
                System.out.printf("%d  ", curr.data);
                curr = curr.right;
            }
        }
    }
}
