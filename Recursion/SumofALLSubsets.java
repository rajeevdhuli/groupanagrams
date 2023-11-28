class Solution {
    int ans  = 0;
    public int subsetXORSum(int[] nums) {
        helper(nums,0,0);
        return  ans;
    }
    public void helper( int[] nums,int start, int sum){
        ans+=sum;
        for(int i = start; i < nums.length;i++){
            sum=sum+nums[i];
            helper(nums,i+1,sum);
            sum =sum-nums[i];
        }
    }
}
