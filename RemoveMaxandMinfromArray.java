class Solution {
    public int minimumDeletions(int[] nums) {
        int minPosition = -1;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxPosition = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
                minPosition = i;
            }
            if(nums[i] > max){
                maxPosition = i;
                max = nums[i];
            }
        }
        int firstDiff = Math.max(minPosition,maxPosition)+1;//delete from left
        int lastDiff = n - Math.min(maxPosition,minPosition);//when both are towards right
        int midDiff = (n- Math.max(minPosition,maxPosition)) + (Math.min(minPosition,maxPosition)+1);//when both are towards different end
        return Math.min(Math.min(firstDiff,lastDiff),midDiff);
    }
}
