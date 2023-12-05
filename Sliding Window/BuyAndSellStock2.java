class Solution {
    public int maxProfit(int[] arr) {
        int l  = 0 , r = 1;
        int maxp = 0;
        int profit = 0;
        while(r < arr.length ){
            if( arr[l] < arr[r]){
               profit+= arr[r] - arr[l];
               l = r;
            }
            else{
               l = r;
            }
            r++;
        }
        return profit;
    }
}
