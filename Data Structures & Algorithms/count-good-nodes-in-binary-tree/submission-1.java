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
        int[] result = new int[1];
        goodNodes(root, Integer.MIN_VALUE, result);

        return result[0];
    }

    public void goodNodes(TreeNode root, int maxSoFar, int[] ans) {
        if (root == null) {
            return;
        }

        if (root.val >= maxSoFar) {
            ans[0]++;
            maxSoFar = root.val;
        }
        
        goodNodes(root.left, maxSoFar, ans);
        goodNodes(root.right, maxSoFar, ans);
    }
}
