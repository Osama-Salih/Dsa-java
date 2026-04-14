import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        BT bst = new BT();
        bst.add(1);
        bst.add(2);
        bst.add(3);
        bst.add(5);
        bst.add(4);
    }

    public static class BT {
        private TreeNode root;

        public void add(int value) {
            TreeNode newNode = new TreeNode(value);
            if (root == null) {
                root = newNode;
                return;
            }

            TreeNode temp = root;
            TreeNode parent = null;
            while (temp != null) {
                parent = temp;
                if (value <= temp.val) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }

            if (value <= parent.val) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
    }
}