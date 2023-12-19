class Solution {
    public int strStr(String haystack, String needle) {
        int k = needle.length();
        int j = k - 1;
        int i = 0; 
        while(j<haystack.length()){
            String s1 = haystack.substring(i,j+1);  
            if(needle.equals(s1)){
                return i;
            }
            i++; 
            j++; 
        }
        return -1; 
    }
}
