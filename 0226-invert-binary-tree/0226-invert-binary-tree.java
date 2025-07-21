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
    public TreeNode invertTree(TreeNode root) {
        return invertTreeRec(root);
    }

    public TreeNode invertTreeRec(TreeNode node) {
        if (node == null) {
            return null;
        }

        // Swap the children
        TreeNode temp = node.left;
        node.left = invertTreeRec(node.right);
        node.right = invertTreeRec(temp);

        return node;
    }
}