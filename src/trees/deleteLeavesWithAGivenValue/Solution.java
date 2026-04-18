package trees.deleteLeavesWithAGivenValue;

import trees.TreeNode;

public class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.val == target && (root.left == null && root.right == null))
            root = null;
        return root;
    }
}
