here it is exact like k = 5 , java ans = 0;

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int n = s.length();
        int start  = 0;
        int end  = 0;
        int maxLength = -1;
        Map<Character,Integer> mp = new HashMap<>();
        while(end < n){
            char c  = s.charAt(end);
            mp.put(c,mp.getOrDefault(c,0)+1);
            
            while(mp.size() > k){
                char ch  = s.charAt(start);
                if(mp.get(ch) == 1){
                    mp.remove(ch);
                }else{
                    mp.put(ch,mp.get(ch)-1);
                }
                start++;
            }
            if(mp.size() == k)
                maxLength = Math.max(maxLength,end - start + 1);
            end++;
        }
        return maxLength;
    }
}




suppose it was atmost then - java , k = 5 output - 4(java)
  

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int n = s.length();
        int start  = 0;
        int end  = 0;
        int maxLength = 0;
        Map<Character,Integer> mp = new HashMap<>();
        while(end < n){
            char c  = s.charAt(end);
            mp.put(c,mp.getOrDefault(c,0)+1);
            
            while(mp.size() > k){
                char ch  = s.charAt(start);
                if(mp.get(ch) == 1){
                    mp.remove(ch);
                }else{
                    mp.put(ch,mp.get(ch)-1);
                }
                start++;
            }
            maxLength = Math.max(maxLength,end - start + 1);
            end++;
        }
        return maxLength;
    }
}
  
  
