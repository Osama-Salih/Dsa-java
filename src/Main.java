import trees.TreeNode;
import trees.binaryTreeMaximumPathSum.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
//        BT bst = new BT();
//        bst.add(1);
//        bst.add(2);
//        bst.add(3);
//        bst.add(5);
//        bst.add(4);
//        TreeNode root = new TreeNode(-15);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
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

        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) return null;

            String[] parts = data.split(",");

            TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            // 1, 2, 3, n, n, 4, 5, n, n, n, n
            int i = 1;
            while(!q.isEmpty() && i < parts.length) {
                TreeNode parent = q.poll();

                // left child
                if (i < parts.length && !parts[i].equals("n")) {
                    TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
                    parent.left = left;
                    q.offer(left);
                }
                i++;

                // right child
                if (i < parts.length && !parts[i].equals("n")) {
                    TreeNode right = new TreeNode(Integer.parseInt(parts[i]));
                    parent.right = right;
                    q.offer(right);
                }
                i++;
            }
            return root;
        }
    }
}