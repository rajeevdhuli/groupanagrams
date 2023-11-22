class Solution {
    public int characterReplacement(String s, int k) {
        char[] c  = s.toCharArray();
        int n = c.length;
        int start = 0, end  = 0;
        int maxLength = 0;
        int mostFreq = 0;
        Map<Character,Integer> mp = new HashMap<>();
        while(end < n){
            mp.put(c[end],mp.getOrDefault(c[end],0)+1);
            //find longest repeating character replacement
            mostFreq = Math.max(mostFreq, mp.get(c[end]));
            //example - AABACAD k=2 , length(7) - mostfreq(4) = 3(B,D,C) >  2 hence skrink 
            while((end - start + 1) - mostFreq > k){
                if(mp.get(c[start]) == 1 )
                   mp.remove(c[start]);
                else   
                   mp.put(c[start],mp.get(c[start])-1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}
