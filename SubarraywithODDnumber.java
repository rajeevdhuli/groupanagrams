

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        Map<Integer,Integer> mp = new HashMap<>();
        int sum =0;
        int cnt=0;
        for(int i =0 ;i< n;i++)
        {
            if(A[i]%2 == 1)
               A[i]=1;
            else
               A[i]=0;   
        }
        for(int i =0;i< n;i++)
        {
            sum = sum+A[i];
            if(sum == B)
               cnt++;
            int rem = sum -B;
            if(mp.containsKey(rem))
               cnt+=mp.get(rem); 
            mp.put(sum,mp.getOrDefault(sum,0)+1);     
        }
        return cnt;
    }
}
