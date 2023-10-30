O(n^2)-
    
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0; 
        int n = s.length();
        for(int i = 0; i < n; i++)
        {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int j;
            for(j = i + 1; j < n; j++)
            {
                if(!set.contains(s.charAt(j)))
                {
                    set.add(s.charAt(j)); 
                }
                else
                    break;
            }
            maxlen = Math.max(maxlen, j - i);
        }   
        return maxlen;
    }
}


O(n) - 

    class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        int n = s.length();
        if(n < 2)
           return n;
        Set<Character> set = new HashSet<>();
        int left = 0;
        set.add(s.charAt(left));
        int right = 1;
        while(right < n && left <= right)
        {
            while(set.contains(s.charAt(right)))
            {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            maxlen = Math.max(maxlen, right - left );
        }
        return maxlen;
    }
}
