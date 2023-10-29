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
