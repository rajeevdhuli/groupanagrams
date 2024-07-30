O(N^2)--

class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int beauty = 0;
        for(int i = 0; i < n; i++){
            Map<Character,Integer> mp = new HashMap<>();
            for(int j = i ; j < n ; j++){
                char ch = s.charAt(j);
                mp.put(ch,mp.getOrDefault(ch,0)+1);
                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;

                for(int value : mp.values()){
                    maxFreq = Math.max(maxFreq,value);
                    minFreq = Math.min(minFreq,value);
                }

                beauty+= maxFreq - minFreq;
            }
        }
        return beauty;
    }
}



using array -


class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;
        for (int i = 0; i < n; i++) {
            int[] charCount = new int[26];
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                charCount[c - 'a']++;
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;
                for (int count : charCount) {
                    if (count > 0) {
                        maxFreq = Math.max(maxFreq, count);
                        minFreq = Math.min(minFreq, count);
                    }
                }
                totalBeauty += (maxFreq - minFreq);
            }
        }

        return totalBeauty;

    }
}
