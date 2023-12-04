class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c=  s.charAt(i);
            if(freq[c-'a'] == 0){
                freq[c-'a'] = i+1;
            }else{
                int dis = i - freq[c-'a'] ;
                if(distance[c-'a'] != dis){
                    return false;
                }
            }
        }
        return true;
    }
}
