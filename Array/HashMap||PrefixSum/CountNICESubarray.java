class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        int sum = 0 ;
        int cnt = 0;
        for(int i = 0; i < n;i++){
            if(nums[i] % 2 == 1)
                sum++;
            if(sum == k){
                cnt++;
            }
            int rem = sum - k;
            if(mp.containsKey(rem)){
                cnt+= mp.get(rem);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}
