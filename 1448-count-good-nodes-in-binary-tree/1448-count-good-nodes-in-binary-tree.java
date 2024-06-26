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
        int maxValue = Integer.MIN_VALUE;
        return dfs(root, maxValue); 
    }
    public int dfs(TreeNode node, int maxi) {
        int res =0;
        if(node!=null && node.val>= maxi) {
            maxi = node.val;
            res = 1;
        }
        if(node.left!=null) {
         res+=  dfs(node.left, maxi);
        }
        if(node.right!=null) {
          res+= dfs(node.right, maxi);

        }        
        return res;
        
    }
}