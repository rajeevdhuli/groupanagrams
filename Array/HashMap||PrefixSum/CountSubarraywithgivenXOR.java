public class Solution {
    public int solve(int[] A, int B) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = A.length;
        int xor_sum = 0;
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            xor_sum = xor_sum ^ A[i];
            if(xor_sum == B)
              cnt++;
            int rem = xor_sum ^ B;
            if(mp.containsKey(rem)){
                cnt+= mp.get(rem);
            }  
            mp.put(xor_sum,mp.getOrDefault(xor_sum,0)+1);
        }
        return cnt;   
    }
}
