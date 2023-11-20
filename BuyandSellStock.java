class Solution {
    public int maxProfit(int[] arr) 
    {
        int n = arr.length;
        int min = arr[0];
        int profit = 0;
        for(int i  = 1; i <  n ; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            profit = Math.max(profit,arr[i] - min);
        }
        return profit;
    }
}




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
