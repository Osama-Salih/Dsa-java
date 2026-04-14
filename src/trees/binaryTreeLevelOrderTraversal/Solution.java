package trees.binaryTreeLevelOrderTraversal;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                if (node != null) {
                    level.add(node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }

            if (level.size() > 0) {
                res.add(level);
            }
        }
        return res;
    }
}
