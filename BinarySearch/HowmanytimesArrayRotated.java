class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;
        int low = 0;
        int high = n - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;
            if(nums[low] <= nums[high])
                return low;
            else if((nums[mid] <= nums[next]) && (nums[mid] <= nums[prev])){
                return mid;
            }
            else if(nums[mid] <= nums[high])
                high = mid - 1;
            else if(nums[mid] >= nums[low])
                low = mid + 1;           
        }
        return -1;
        
    }
}
