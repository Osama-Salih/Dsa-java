package trees.binaryTreeInorderTraversal;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while(!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                res.add(temp.val);
                temp = temp.right;
            }
        }
        return res;
    }
}