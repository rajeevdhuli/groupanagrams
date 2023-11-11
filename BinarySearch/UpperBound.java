public class Solution {
    public static int upperBound(int []nums, int x, int n){
        // Write your code here.
        int l = 0;
        int h = n - 1;
        int ans = n;
        int mid;
        while(l <= h){
            mid = (l + h)/2;
            if(nums[mid] > x ){
                ans = mid ;
                h = mid  - 1;
            }
            else if(nums[mid] <= x)
               l = mid + 1;
                  
        }
        return ans;
    }
}



upper_bound returns iterator to first element in the given range 
-which is Greater than val.

  Upper Bound - return first/smallest index such that arr[index] > target.
