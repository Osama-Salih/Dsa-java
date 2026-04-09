package trees.binaryTreePreorderTraversal;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return List.of();

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            res.add(current.val);

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        return res;
    }
}
