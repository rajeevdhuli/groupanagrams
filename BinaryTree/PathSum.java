class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return helper(root,targetSum);
    }
    public boolean helper(TreeNode root, int sum){
        if(root == null)
            return false;
        int rem = sum - root.val;
        boolean flag = false;
        if(rem == 0 && root.left == null && root.right == null){
            return true;
        }
        flag = helper(root.left,rem);
        if(flag)
           return true;
        flag =  helper(root.right,rem);
        return flag;
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
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return helper(root,targetSum);
    }
    public boolean helper(TreeNode root, int sum){
        int rem = sum - root.val;
        boolean flag = false;
        if(rem == 0 && root.left == null && root.right == null){
            return true;
        }
        if(root.left != null){
            flag = helper(root.left,rem);
        }
        if(flag)
           return true;
        if(root.right != null){
            flag =  helper(root.right,rem);
        }
        return flag;
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
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        boolean flag = false;
        return helper(root,targetSum,flag);
    }
    public boolean helper(TreeNode root, int sum, boolean flag){
        int rem = sum - root.val;
        if(rem == 0 && root.left == null && root.right == null){
            return true;
        }
        if(root.left != null){
            flag = helper(root.left,rem,flag);
        }
        if(flag)
           return true;
        if(root.right != null){
            flag = helper(root.right,rem,flag);
        }
        return flag;
    }
}
