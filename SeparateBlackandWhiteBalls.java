class Solution {
    public long minimumSteps(String s) {
        long n  = s.length();
        long swap = 0;
        int left = 0;
        long oneCnt =  0;
        while(left < n){
            if(s.charAt(left) == '1'){
                oneCnt++;   
            }
            else if (s.charAt(left) == '0' && oneCnt > 0){
                swap+=oneCnt;
            }
            left++;
        }
        return swap;
    }
}
