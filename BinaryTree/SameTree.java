class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if( p == null && q == null )
            return true;
        else if(p == null || q == null )
            return false;
        return ((p.val == q.val)&&(isSameTree(p.left,q.left))&&(isSameTree(p.right,q.right)));       
    }
}



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
        return helper(p,q);      
    }
    public boolean helper(TreeNode p, TreeNode q){
        if(p == null && q == null)
           return true;
        if(p == null || q == null)
           return false;
        if(p.val != q.val)
           return false;
        if(p.val == q.val){
            boolean left = helper(p.left,q.left);
            boolean right = helper(p.right,q.right);
            if(left && right)
               return true;
        }
        return false;         
    }
}
