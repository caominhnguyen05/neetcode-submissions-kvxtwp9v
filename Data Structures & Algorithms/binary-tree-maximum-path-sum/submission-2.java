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
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[]{root.val};
        dfs(root, ans);
        return ans[0];
    }

    private int dfs(TreeNode node, int[] ans) {
        if (node == null) {
            return 0;
        }

        int leftDown = Math.max(0, dfs(node.left, ans));
        int rightDown = Math.max(0, dfs(node.right, ans));

        int maxThroughNode = node.val + leftDown + rightDown;
        ans[0] = Math.max(ans[0], maxThroughNode);

        return node.val + Math.max(leftDown, rightDown);
    }
}
