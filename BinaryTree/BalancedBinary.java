 
   //Definition for a binary tree node.
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode() {}
//        TreeNode(int val) { this.val = val; }
//        TreeNode(int val, TreeNode left, TreeNode right) {
//           this.val = val;
//           this.left = left;
//          this.right = right;
//       }
//   }
 
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight (root) != -1;
    }
    public int dfsHeight(TreeNode root){
        int left = 0 ;
        int right = 0 ;
        if(root == null){
            System.out.println("null "+left+" "+right);
            return 0;
        }
        System.out.println("before left "+root.val+" "+left+" "+right);
         left = dfsHeight(root.left);
        System.out.println("after left "+root.val+" "+left+" "+right);
        if(left == -1){
           System.out.println("RETURN LEFT -1 "+root.val+" "+left+" "+right); 
           return -1;
        }
        System.out.println("before right "+root.val+" "+left+" "+right);
        right = dfsHeight(root.right);
        if(right == -1){
           System.out.println("RETURN RIGHT -1 "+root.val+" "+left+" "+right); 
           return -1;
        } 
        System.out.println("after right "+root.val+" "+left+" "+right);   
        if(Math.abs(left - right) > 1){
            System.out.println("UNBALANCED "+root.val+" "+left+" "+right); 
            return -1;
        }
        int max = Math.max(left,right)+1;
        System.out.println("MAX "+root.val+" "+max);
        return max;

    }
}
