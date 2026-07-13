/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res, Integer.MIN_VALUE);

        return res[0];
    }

    private void dfs(TreeNode root, int[] res, int maxSoFar) {
        if (root == null) return;

        if (root.val >= maxSoFar) {
            res[0]++;
            maxSoFar = root.val;
        }

        dfs(root.left, res, maxSoFar);
        dfs(root.right, res, maxSoFar);
    }
}
