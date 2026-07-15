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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val + ",");
                q.add(node.left);
                q.add(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;

        String[] vals = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (!vals[index].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(vals[index]));
                queue.add(curr.left);
            }
            index++;

            if (!vals[index].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(vals[index]));
                queue.add(curr.right);
            }
            index++;
        }

        return root;
    }
}
