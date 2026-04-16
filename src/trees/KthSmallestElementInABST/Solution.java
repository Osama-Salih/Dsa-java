package trees.KthSmallestElementInABST;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private void dfsTraversal(TreeNode root, List<Integer> list, int k) {
        if (root == null) return;
        if (list.size() >= k) return;

        dfsTraversal(root.left, list, k);
        list.add(root.val);
        dfsTraversal(root.right, list, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfsTraversal(root, list, k);
        return list.get(k - 1);
    }
}
