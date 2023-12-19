class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        int min = Math.min(Math.min(l1,l2),l3);
        int maxLength = 0;
        for(int i = 0 ; i < min; i++){
            if(s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i))
                maxLength++;
            else
                break;
        }
        if(maxLength == 0)
            return -1;
        int ans  = (l1 - maxLength) + (l2 - maxLength) + (l3 - maxLength);
        return ans;    
        
        
    }
}
