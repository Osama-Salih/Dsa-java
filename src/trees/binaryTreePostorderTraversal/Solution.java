package trees.binaryTreePostorderTraversal;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        while(current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    res.add(temp.val);

                    while(!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        res.add(temp.val);
                    }
                } else {
                    current = temp;
                }
            }
        }
        return res;
    }
}
