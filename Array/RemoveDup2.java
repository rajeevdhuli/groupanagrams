class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0 ; 
        int right = 0 ;
        int n = nums.length;
        while(right < n){
            int cnt = 1;
            while(right < n - 1 && nums[right] == nums[right+1]){
                cnt++;
                right++;   
            }
            int i  = 0;
            while(i < Math.min(2,cnt)){
                nums[left] = nums[right];
                left++;
                i++;
            }
            right++;
        }
        return left;
    }
}
