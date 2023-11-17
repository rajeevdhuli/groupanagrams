class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <=  high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target)
                return true;

            else if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low = low + 1;
                high = high  - 1;
            }  

            else if(nums[mid] <= nums[high]){
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else
                    high = mid - 1;
            }  
            
            else if(nums[low] <= nums[mid]){
                if( target < nums[mid] && target >= nums[low]){
                    high = mid - 1;
                }
                else
                    low = mid + 1;
            }
        }
        return false;
    }
}
