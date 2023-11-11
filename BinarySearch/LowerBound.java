public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        int l = 0;
        int h = n - 1;
        int mid ;
        int ans = n;
        while(l <= h){
            mid = (l + h)/2;
            if(arr[mid] >= x){
                ans =  mid;
                h = mid - 1;
            }

            else if(arr[mid] < x)
               l = mid + 1;
        }
        return ans;
        // Write your code here
    }
}

lower_bound returns iterator to first element in the given range 
-which is EQUAL_TO or Greater than val.

  Lower bound - return smallest/first index such that arr[index] >= target.
