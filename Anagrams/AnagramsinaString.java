class Solution {
    public List<Integer> findAnagrams(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        List<Integer> ans = new ArrayList<>();
        if( n < m)
           return ans;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0 ; i <  m; i++){
            freq1[s2.charAt(i)-'a']++;
            freq2[s1.charAt(i)-'a']++;
        }

        int cnt  = 0;
        for(int i = 0 ; i < 26; i++){
            if(freq1[i] == freq2[i])
               cnt++;
        }
        int r,l;
        for(int i = m ; i < n ; i++){
            r = s1.charAt(i) - 'a';
            l = s1.charAt(i - m) - 'a';

            if(cnt == 26)
               ans.add(i-m);

            freq2[r]++;
            if(freq1[r] == freq2[r])
               cnt++;
            else if(freq2[r] == (freq1[r] + 1))
               cnt--;

            freq2[l]--; 
            if(freq1[l] == freq2[l])
               cnt++;
            else if(freq2[l] == (freq1[l] - 1))
               cnt--;        
        }

        if(cnt == 26)
           ans.add(n-m);
        return ans;   
    }
}

