class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int maxEle = nums[0];
        for(int i = 0; i < n ; i++){
            if(maxEle != nums[i]){
                cnt--;
            }else if(maxEle == nums[i]){
                cnt++;
            }
            if(cnt == 0){
                cnt++;
                maxEle = nums[i];
            }
        }
        return maxEle;
    }
}
