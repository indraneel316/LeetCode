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
    public boolean isBalanced(TreeNode root) {
         
        if(height(root)==-1) {
            return false;
        }
        return true;
    }
    
    
    public int height(TreeNode root) {
            if(root==null) {
            return 0;
        }
            int leftPath = height(root.left);
            int rightPath = height(root.right);
            if(leftPath ==-1 || rightPath ==-1) {
                return -1;
            }
            int diff = Math.abs(leftPath - rightPath);
            if(diff>1) {
                return -1;
            }
            return Math.max(leftPath, rightPath)+1;
    }
}