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

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (currNode == null) {
                sb.append("null").append(",");
            } else {
                sb.append(currNode.val).append(",");
                queue.offer(currNode.left);
            queue.offer(currNode.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();

            if (!values[index].equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(parent.left);
            }

            index++;

            if (!values[index].equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(parent.right);
            }
            index++;
        }

        return root;
    }
}
