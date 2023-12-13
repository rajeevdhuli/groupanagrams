class Solution {
    public int numSubarraysWithSum(int[] arr, int goal) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = arr.length;
        int sum = 0 ;
        int cnt = 0;
        for(int i = 0; i< n; i++){
            sum = sum + arr[i];
            if(sum == goal){
                cnt++;
            }
            int rem = sum - goal;
            if(mp.containsKey(rem)){
                cnt+= mp.get(rem);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}
