package trees.insertIntoABinarySearchTree;

import trees.TreeNode;

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
            return root;
        }

        TreeNode temp = root;
        TreeNode parent = null;
        while(temp != null) {
            parent = temp;
            if (val > temp.val) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }

        if (val > parent.val) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        return root;
    }
}
