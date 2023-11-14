public class Solution {
    public static int count(int arr[], int n, int x) {
        //Your code goes here
        int l = 0;
        int h = n - 1;
        int target = x;
        int f = binary_search(arr,target,l,h,true);
        int last = binary_search(arr,target,l,h,false);
        int ans = ((last - f + 1) == 1)? 0: (last - f + 1);
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
