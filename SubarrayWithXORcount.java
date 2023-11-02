O(n)
public class Solution {
    public int solve(int[] A, int B) {
        Map<Integer,Integer> mp = new HashMap<>();
        int xo = 0;
        int cnt  = 0;
        int n = A.length;
        for(int i = 0;i < n;i++)
        {
            xo^= A[i];
            if(xo == B)
               cnt++;
            int rem = xo ^ B;
            if(mp.containsKey(rem))
               cnt = cnt + mp.get(rem);
            mp.put(xo,mp.getOrDefault(xo,0)+1);      
        }
        return cnt;
    }
}
