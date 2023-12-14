class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mp = new HashMap<>();
        int n = s.length();
        int m = t.length();
        for(char c:t.toCharArray()){
            //inert all elements in map 
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        //keep count of all distinct characters
        int count = mp.size();
        int r = 0;//right
        int l = 0;//left
        int minLength = Integer.MAX_VALUE;
        String ans = "";
        int left = -1 ;
        int right = -1;
        while(r < n){
            if(mp.containsKey(s.charAt(r))){
                //once you have encountered the character present in t start    decreasing them
                mp.put(s.charAt(r), mp.get(s.charAt(r)) - 1);
                //suppose t = abac , then u cannot decrease 'a' count
                // until u meet 2 'a'. s = 'abdca' then u cannot decrease 
                // a count until you meet 2 'a' in s. 
                if(mp.get(s.charAt(r)) == 0){
                    count--;
                }
            }
            while(count == 0){
                if(r - l + 1 < minLength){
                    //keep track of left and right for final answer
                    minLength = r - l + 1;
                    left = l;
                    right = r;
                }
                if(mp.containsKey(s.charAt(l))){
                    //take ex 1 - after first window 'ADOBEC' then one more 'B'
                    //is encountered so b value becomes -1, 
                    mp.put(s.charAt(l),mp.get(s.charAt(l)) + 1);
                    //if l becomes 3 and you increment 'B' value in map
                    //u have to increment only if you meet both 'B' 
                    if(mp.get(s.charAt(l)) > 0){
                        count++;
                    }
                }
                l++;
            }
            r++;
        }
        if(left == -1 || right == -1){
            return ans;
        }
        ans = s.substring(left,right+1);
        return ans;
    }
}
