package trees.diameterOfBinaryTree;

import trees.TreeNode;

public class Solution {
    private int maxHeight = 0;
    public int diameterOfBinaryTree(TreeNode root) {
      getHeight(root);
      return maxHeight;
    }
    private int getHeight(TreeNode node) {
       if (node == null) return 0;

       int leftHeight = getHeight(node.left);
       int rightHeight = getHeight(node.right);

       maxHeight = Math.max(maxHeight, leftHeight + rightHeight);
       return 1 + Math.max(leftHeight, rightHeight);
    }
}
