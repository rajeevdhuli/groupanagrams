class Solution {
    public int mySqrt(int x) {
        if(x == 0)
           return 0;
        if(x == 1)
        return 1;   
        int low =  0;
        int high = x;
        while(low<=high){
            int mid = low + (high-low)/2;
            if((mid ) == x/mid)
               return mid;
            if((mid ) > x/mid ){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }
}
