class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans  = 0;
        Arrays.sort(nums);
        int minDis = Integer.MAX_VALUE;
        for(int i = 0; i < n - 2; i++)
        {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int l = i + 1;
            int r = n - 1;
            while(l < r)
            {
                int sum = nums[i] + nums[l] + nums[r];
                int gap = Math.abs(target - sum);
                if(minDis > gap)
                {
                    minDis = gap;
                    ans = sum;
                }
                if( sum < target)
                {
                    l++;
                }
                else
                    r--;
            }    
        }
        return ans;
    }
}
