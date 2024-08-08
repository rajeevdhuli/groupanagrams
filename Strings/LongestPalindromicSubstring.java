class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end  = 0;
        int len = 0;
        int[] len1 = new int[3];
        int[] len2 = new int[3];
        for(int i = 0 ; i < n ; i++){
            len1 = longest(s,i,i);
            len2 = longest(s,i,i+1);
            if(len < len1[2]){
                start = len1[0];
                end = len1[1];
                len = len1[2];
            }
            if(len < len2[2]){
                start = len2[0];
                end = len2[1];
                len = len2[2];
            }
        }
        return s.substring(start,end+1);
    }
    public int[] longest(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return new int[]{start + 1, end - 1,end - start-1};
    }
}
