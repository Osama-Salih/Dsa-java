package dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        int data = node.val;

        if (root == null) {
            root = node;
            return root;
        } else if (data < root.val) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(Node root) {
        if (root != null) {
            displayHelper(root.left);
            System.out.println(root.val);
            displayHelper(root.right);
        }
    }

    public boolean search(int val) {
        return searchHelper(root, val);
    }

    private boolean searchHelper(Node root, int val) {
        if (root == null) {
            return false;
        } else if (root.val == val) {
            return true;
        } else if (root.val > val) {
            return searchHelper(root.left, val);
        } else {
            return searchHelper(root.right, val);
        }
    }

    public void remove(int val) {
        if (search(val)) {
            removeHelper(root, val);
        } else {
            System.out.println(val + " could not be found");
        }
    }

    private Node removeHelper(Node root, int val) {
        if (root == null) {
            return root;
        } else if (val < root.val) {
            root.left = removeHelper(root.left, val);
        } else if (val > root.val) {
            root.right = removeHelper(root.right, val);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.val = successor(root);
                root.right = removeHelper(root.right, root.val);
            } else {
                root.val = predecessor(root);
                root.left = removeHelper(root.left, root.val);
            }
        }
        return root;
    }

    private int successor(Node root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    private int predecessor(Node root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public List<Integer> bfs() {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node current = null;
        while (!queue.isEmpty()) {
            current = queue.poll();
            list.add(current.val);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return list;
    }

    public void dfsPreOrder() {
        dfsPreOrderHelper(root);
    }
    private void dfsPreOrderHelper(Node root) {
        if (root == null) return;

        System.out.println(root.val);
        dfsPreOrderHelper(root.left);
        dfsPreOrderHelper(root.right);
    }

    public void dfsInOrder() {dfsInOrderHelper(root);}
    private void dfsInOrderHelper(Node root) {
        if (root == null) return;

        dfsInOrderHelper(root.left);
        System.out.println(root.val);
        dfsInOrderHelper(root.right);
    }

    public void dfsPostOrder() {dfsPostOrderHelper(root);}
    private void dfsPostOrderHelper(Node root) {
        if (root == null) return;

        dfsPostOrderHelper(root.left);
        dfsPostOrderHelper(root.right);
        System.out.println(root.val);
    }
}