class Solution {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length;
        int l = 0; 
        int r  = 0;
        Set<Integer> set = new HashSet<>();
        int minSize = Integer.MAX_VALUE;
        while( r < n){
            while(set.contains(cards[r]) && l <= r){
                minSize = Math.min(r-l+1,minSize);
                set.remove(cards[l]);
                l++;
            }
            set.add(cards[r]);
            r++;
        }
        if(minSize == Integer.MAX_VALUE)
             return -1;
        return minSize;
    }
}




Brute Force - 



class Solution {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length;
        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i < n ; i++){
            Set<Integer> set = new HashSet<>();
            set.add(cards[i]);
            for(int j = i + 1; j < n ; j++){
                if(set.contains(cards[j])){
                    minLength = Math.min(minLength,j - i + 1);
                }
                set.add(cards[j]);
            }
        }
        if(minLength == Integer.MAX_VALUE){
            return -1;
        }
        return minLength;
    }
}
