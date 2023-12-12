class Solution {
    private int cnt = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
           return 0;
        helper(root,(long)targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return cnt;   
    }
    public void helper(TreeNode root, long sum){
        if(root == null){
            return;
        }
        long rem = sum - root.val;
        if(rem == 0 ){
            cnt++;
        }
        helper(root.left,rem);
        helper(root.right,rem);
    }
}










class Solution {
    // private int cnt = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
           return 0;
         return helper(root,(long)targetSum)+ pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }
    public int helper(TreeNode root, long sum){
        int cnt = 0;
        if(root == null){
            return 0;
        }

        if(sum == root.val ){
            cnt++;
        }
        cnt+= helper(root.left,sum - root.val);
        cnt+= helper(root.right,sum - root.val);
        return cnt;
    }
}
