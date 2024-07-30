O(N^2)  -

class Solution
{
    long substrCount (String S, int K) {
        // your code here
        int n = S.length();
        long totDis = 0;
        for(int start = 0 ; start < n ; start++){
            Map<Character,Integer> mp = new HashMap<>();
            int distinct = 0;
            for(int end = start; end < n; end++){
                char ch = S.charAt(end);
                mp.put(ch,mp.getOrDefault(ch,0)+1);
                if(mp.size() == K){
                    totDis++;
                }else if(mp.size() > K){
                    break;
                }
            }
        }
        return totDis;
    }
}

O(N) -




class Solution
{
    long substrCount (String S, int K) {
        // your code here
        return count(S,K) - count(S,K-1);
    }
    public long count(String s, int k){
        int n = s.length();
        int left = 0 ;
        long total = 0;
        Map<Character,Integer> mp = new HashMap<>();
        for(int right = 0 ; right < n ; right++){
           mp.put(s.charAt(right),mp.getOrDefault(s.charAt(right),0)+1);
           while(mp.size() > k){
               mp.put(s.charAt(left),mp.get(s.charAt(left))-1);
               if(mp.get(s.charAt(left)) == 0){
                   mp.remove(s.charAt(left));
               }
               left++;
           }
           total+= right - left + 1;
        }
        return total;
    }
}
