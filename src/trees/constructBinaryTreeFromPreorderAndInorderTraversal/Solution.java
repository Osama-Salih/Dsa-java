package trees.constructBinaryTreeFromPreorderAndInorderTraversal;

import trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderIndexMap.put(inorder[i], i);

        return splitTree(preorder, inorderIndexMap, 0, 0, inorder.length - 1);
    }
    private TreeNode splitTree(int []preOrder, Map<Integer, Integer> inorderIndexMap,int rootIndex, int left, int right) {

        TreeNode root = new TreeNode(preOrder[rootIndex]);
        int mid = inorderIndexMap.get(preOrder[rootIndex]);

        if (mid > left)
            root.left = splitTree(preOrder, inorderIndexMap, rootIndex + 1, left, mid - 1);
        if (mid < right)
            root.right = splitTree(preOrder, inorderIndexMap, rootIndex + mid - left + 1, mid + 1, right);
        return root;
    }
}
