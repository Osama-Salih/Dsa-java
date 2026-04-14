package trees.binaryTreeRightSideView;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode rightSide = null;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    rightSide = node;
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }

            if (rightSide != null) {
                res.add(rightSide.val);
            }
        }
        return res;
    }
}
