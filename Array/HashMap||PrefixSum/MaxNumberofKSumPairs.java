

O(n) time, O(n) space


             class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n= nums.length;
        int cnt = 0;
        for(int i = 0; i < n; i++)
        {
            int rem = k - nums[i];
            if(mp.containsKey(rem))
            {
                cnt++;
                if(mp.get(rem) == 1)
                   mp.remove(rem);
                else
                   mp.put(rem,mp.get(rem)-1);   
            }
            else
                mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        return cnt;
    }
}




