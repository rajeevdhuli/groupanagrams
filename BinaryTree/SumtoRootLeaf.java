class Solution {
    public int sumNumbers(TreeNode root) {
        int[] ans = new int[1];
        helper(root,0,ans);
        return ans[0];
    }
    public int helper(TreeNode root,int sum,int[] ans){
        if(root == null){
            return 0;
        }
        sum = sum *10 + root.val;
        if(root.left == null && root.right == null){
            ans[0]+= sum;
            return ans[0];
        }
        helper(root.left,sum,ans);
        helper(root.right,sum,ans);
        return ans[0];
    }
}




class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    public int helper(TreeNode root,int sum){
        if(root == null){
            return 0;
        }
        sum = sum *10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }
        int leftsum = helper(root.left,sum);
        int rightsum =helper(root.right,sum);
        return leftsum + rightsum;
    }
}
