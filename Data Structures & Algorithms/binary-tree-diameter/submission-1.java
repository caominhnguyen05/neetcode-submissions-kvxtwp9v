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
    public int diameterOfBinaryTree(TreeNode root) {
        // Stores the largest diameter found so far
        int[] ans = new int[1];

        dfs(root, ans);
        return ans[0];
    }

    private int dfs(TreeNode node, int[] ans) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left, ans);
        int right = dfs(node.right, ans);

        // Update diamter
        ans[0] = Math.max(ans[0], left + right);

        return 1 + Math.max(left, right);
    }
}
