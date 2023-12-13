class Solution {
    public int subarraySum(int[] arr, int k) 
    { 
        int n = arr.length;
        Map<Integer,Integer> mp = new HashMap<>();
        int cnt = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum  = sum +  arr[i];
            if(sum == k)
               cnt++;
            int rem = sum - k;
            if(mp.containsKey(rem)){
                cnt+= mp.get(rem);
            }   
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}
