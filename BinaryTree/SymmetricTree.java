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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode root1 = root.left;
        TreeNode root2 = root.right;
        return helper(root1,root2);
    }
    public boolean  helper(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null || root1.val != root2.val)
            return false;
        if(root1.val == root2.val){
            boolean left = helper(root1.left,root2.right);
            boolean right = helper(root1.right,root2.left);
            if(left && right){
                return true;
            }
        }
        return false;
    }
}
















class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
            TreeNode lsub = queue.poll();
            TreeNode rsub = queue.poll();
            if(lsub == null && rsub == null)
                continue;
            if(lsub == null || rsub == null || lsub.val != rsub.val){
                return false;
            }
            queue.offer(lsub.left);
            queue.offer(rsub.right);
            queue.offer(lsub.right);
            queue.offer(rsub.left); 
        }
        return true;
    }
}


