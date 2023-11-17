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








PSEUDO CODE -

    
Function checkInclusion(s1, s2):
    n = length of s1
    m = length of s2

    if n > m:
        return false

    freq1 = array of size 26 initialized with zeros
    freq2 = array of size 26 initialized with zeros

    // Count frequencies of characters in the first n characters of s2 and s1
    for i from 0 to n-1:
        freq1[s1[i] - 'a']++
        freq2[s2[i] - 'a']++

    cnt = 0

    // Compare frequencies of characters and count how many are same
    for i from 0 to 25:
        if freq1[i] == freq2[i]:
            cnt++

    // Slide a window through s2 and update frequencies accordingly
    for i from n to m-1:
        r = s2[i] - 'a'
        l = s2[i - n] - 'a'

        // If all frequencies match, return true
        if cnt == 26:
            return true

        freq2[r]++

        // Update cnt based on the changes in frequencies
        //if new element adding on s2 is same as s2 then ++;
        // else --;
        if freq1[r] == freq2[r]:
            cnt++
        else if freq2[r] == (freq1[r] + 1):
            cnt--

        freq2[l]--

        // Update cnt based on the changes in frequencies
        // if after removing they become same like 'e' in s1 is 0 , and after removing 'e' in s2 it becomes 0 then you increment count, 
        //else if elemnt was present in s1 and now you are removing it then you decremnt it .
        if freq1[l] == freq2[l]:
            cnt++
        else if freq2[l] == (freq1[l] - 1):
            cnt--

    return (cnt == 26)
