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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageOfLevels = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return averageOfLevels;
        }
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            long sum = 0;
            int i = size;
            while(size-- > 0){
                if(q.peek().left != null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right != null){
                    q.offer(q.peek().right);
                }
                sum+= q.poll().val;
            }
            double res = (double)sum/i;
            averageOfLevels.add(res);
        }
        return averageOfLevels;   
    }
}
