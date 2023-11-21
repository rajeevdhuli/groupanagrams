Sliding Window Approach - 


class Solution {
    public int maxProfit(int[] arr) 
    {
        int l  = 0 , r = 1;
        int maxp = 0;
        while(r < arr.length){
            if( arr[l] < arr[r]){
               int profit = arr[r] - arr[l];
               maxp = Math.max(maxp,profit);
            }
            else{
               l = r;
            }
            r++;
        }
        return maxp;
    }
}
