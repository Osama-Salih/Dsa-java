package trees.deleteNodeInABST;

import trees.TreeNode;

public class Solution {
    private int getMax(TreeNode temp) {
        while(temp.right != null) {
            temp = temp.right;
        }
        return temp.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                int maxValue = getMax(root.left);
                root.val = maxValue;
                root.left = deleteNode(root.left, maxValue);
            }
        }
        return root;
    }
}
