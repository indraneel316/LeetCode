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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root !=null && subRoot ==null) {
            return true;
        }
        if(root ==null && subRoot !=null) {
            return false;
        }
        
        if(compareTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    boolean flag =false;
    public boolean compareTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
         if(root == null || subRoot == null) {
            return false;
        }    
        return root.val == subRoot.val && compareTree(root.left, subRoot.left) && compareTree(root.right, subRoot.right);
    }
}