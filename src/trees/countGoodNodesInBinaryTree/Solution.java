package trees.countGoodNodesInBinaryTree;

import trees.TreeNode;

public class Solution {
    private int count = 0;
    private void countNodes(TreeNode root, int newMax) {
        if (root == null) return;
        if (root.val >= newMax) {
            count++;
            newMax = root.val;
        }
        countNodes(root.left, newMax);
        countNodes(root.right, newMax);
    }

    public int goodNodes(TreeNode root) {
        countNodes(root, Integer.MIN_VALUE);
        return count;
    }
}