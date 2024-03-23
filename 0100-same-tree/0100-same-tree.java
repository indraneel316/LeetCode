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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pNodes =  compareTree(new ArrayList<>(), p);
        List<Integer> qNodes =  compareTree(new ArrayList<>(), q);
        int i =0;
        if(pNodes.size()!=qNodes.size()) {
            return false;
        }
while (i < pNodes.size()) {
    if (pNodes.get(i) == null && qNodes.get(i) == null) {
           i++;
        // Both nodes are null, continue.
    } else if (pNodes.get(i) != null && qNodes.get(i) != null && pNodes.get(i).equals(qNodes.get(i))) {
          i++;
        // Both nodes are not null and equal, continue.
    } else {
        // Either one node is null and the other isn't, or they're both not null but not equal.
        return false;
    }
}
                 return true;

       }   

    public List<Integer> compareTree(List<Integer> values, TreeNode root) {
        if(root ==null) {
            values.add(null);
            return values;
        }
        else {
        values.add(root.val);
        compareTree(values, root.left);
        compareTree(values, root.right);
        }

        return values; 
    }
}