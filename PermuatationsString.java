class Solution {
    public boolean checkInclusion(String s1, String s2) {

      int n = s1.length();
      int m = s2.length();

      if( n > m)
         return false;

      int[] freq1 = new int[26];
      int[] freq2 = new int[26];
      
      for(int i = 0 ; i <  n; i++){

         freq1[s1.charAt(i)-'a']++;
         freq2[s2.charAt(i)-'a']++;

      }

      int cnt  = 0;
      for(int i = 0 ; i < 26; i++){
         if(freq1[i] == freq2[i])
            cnt++;
      }

      for(int i = n ; i < m ; i++){

         int r = s2.charAt(i) - 'a';
         int l = s2.charAt(i - n) - 'a';

         if(cnt == 26)
            return true;

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
      return (cnt == 26);
   }
}



class Solution {
   public boolean checkInclusion(String s1, String s2) {
      int n = s1.length();
      int m = s2.length();

      if( n > m )
         return false;

      int[] freq1 = new int[26];
      int[] freq2 = new int[26];

      for(int i = 0 ; i < n ; i++){
         freq1[s1.charAt(i) - 'a']++;
         freq2[s2.charAt(i) - 'a']++;
      } 

      for(int i = n; i < m; i++){
         int cnt = 0;
         for(int j = 0 ; j < 26; j++){
            if(freq1[j] == freq2[j])
               cnt++;
         }
         if(cnt == 26)
            return true;
         freq2[s2.charAt(i) - 'a']++;
         freq2[s2.charAt(i - n) - 'a']--;   
      }

      for(int i = 0 ; i < 26; i++){
         if(freq1[i] != freq2[i])
            return false;
      }
      return true; 
   }
}
