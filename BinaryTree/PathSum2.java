class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),root,targetSum);
        return trolly;
    }
    public void helper( List<List<Integer>> trolly, List<Integer> bag,TreeNode root, int sum){
        if(root == null)
            return; 
        int rem = sum - root.val;
        if(rem == 0 && root.left == null && root.right == null){
            bag.add(root.val); 
            trolly.add(new ArrayList<>(bag));
            bag.remove(bag.size()-1);
            return;
        }
        bag.add(root.val);  
        helper(trolly,bag,root.left,rem);
        helper(trolly,bag,root.right,rem);
        bag.remove(bag.size()-1);   
    }
}
