class Solution {
    public int longestOnes(int[] arr, int k) {
        int zeroCnt  = 0;
        int oneCnt = 0;
        int start = 0;
        for(int end = 0; end < arr.length; end++){
            if(arr[end] == 0)
               zeroCnt++;
            while(zeroCnt > k){
                if(arr[start] == 0)
                    zeroCnt--;
                start++;
            }   

            oneCnt = Math.max(oneCnt, end - start + 1);   
        }
        return oneCnt;
        
    }
}
