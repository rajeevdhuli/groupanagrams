class Solution {
    public int[] searchRange(int[] nums, int target){
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        int[] ans = new int[2];
        int f = binary_search(nums,target,l,h,true);
        int last = binary_search(nums,target,l,h,false);
        ans[0] = f;
        ans[1] = last;
        return ans;
    }
    public static int binary_search(int[] nums,int target, int low, int high,boolean flag){
        int result = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                result = mid;
                if(flag)
                   high = mid - 1;
                else
                    low = mid + 1;   
            }
            else if (nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }      
        }
        return result;
    }
}
