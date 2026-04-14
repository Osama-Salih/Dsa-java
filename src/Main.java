import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        BT bst = new BT();
        bst.add(10);
        bst.add(7);
        bst.add(15);
        bst.add(3);
        bst.add(9);
        bst.add(12);

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