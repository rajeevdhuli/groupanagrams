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
