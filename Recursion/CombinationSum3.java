class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),nums,n,k,0,0);
        return trolly;
    }
    public void helper(List<List<Integer>> trolly,List<Integer> bag,int[] nums,int target,int k,int i, int sum){
        if(sum == target && bag.size() == k){
            trolly.add(new ArrayList<>(bag));
            return;
        }
        if(sum > target || bag.size() > k){
            return;
        }
        if(i == nums.length) {
            return;
        }
        bag.add(nums[i]);
        helper(trolly,bag,nums,target,k,i+1,sum+nums[i]);
        bag.remove(bag.size()-1);
        helper(trolly,bag,nums,target,k,i+1,sum);
    }
}


USING FOR LOOP -
    

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),nums,n,k,0,0);
        return trolly;
    }
    public void helper(List<List<Integer>> trolly,List<Integer> bag,int[] nums,int target,int k,int start, int sum){
        if(sum == target && bag.size() == k){
            trolly.add(new ArrayList<>(bag));
            return;
        }
        if(sum > target || bag.size() > k){
            return;
        }
        for(int i = start; i < nums.length; i++){
        bag.add(nums[i]);
        helper(trolly,bag,nums,target,k,i+1,sum+nums[i]);
        bag.remove(bag.size()-1);
        }
    }
}







class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),1,n,k,0);
        return trolly;
    }
    public void helper(List<List<Integer>> trolly,List<Integer> bag,int start,int target,int k,int sum){
        if(sum == target && bag.size() == k){
            trolly.add(new ArrayList<>(bag));
            return;
        }
        if(sum > target || bag.size() > k){
            return;
        }
        for(int i = start; i <= 9; i++){
        bag.add(i);
        helper(trolly,bag,i+1,target,k,sum+i);
        bag.remove(bag.size()-1);
        }
    }
}
