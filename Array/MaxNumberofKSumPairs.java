class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0; 
        int right = n - 1;
        int sum = 0;
        int cnt = 0;
        while(left < right){
            sum =  nums[left] + nums[right];
            if(sum == k){
               cnt++;
               left++;
               right --;
            }
            else if (sum > k){
                right--;
            }
            else{
                left++;
            }
        }
        return cnt;
    }
}
