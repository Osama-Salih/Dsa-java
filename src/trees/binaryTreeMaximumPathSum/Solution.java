package trees.binaryTreeMaximumPathSum;

import trees.TreeNode;

public class Solution {
    private int result = Integer.MIN_VALUE;
    private int maxPathSumUtil(TreeNode root) {
        if (root == null) return 0;

        int left = maxPathSumUtil(root.left);
        int right = maxPathSumUtil(root.right);

        int maxStraight = Math.max(Math.max(left, right) + root.val, root.val);
        int maxCaseVal = Math.max(maxStraight, left + right + root.val);
        result = Math.max(result, maxCaseVal);

        return maxStraight;
    }
    public int maxPathSum(TreeNode root) {
       maxPathSumUtil(root);
       return result;
    }
}
