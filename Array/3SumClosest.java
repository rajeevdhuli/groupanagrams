O(N^3) -- BRUTE FORCE ---
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        int minDiff = Integer.MAX_VALUE; 
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int diff = Math.abs(sum - target);
                    if(minDiff > diff){
                        ans = sum;
                        minDiff = diff;
                    }
                }
            }
        }
        return ans;
    }
}



O(N^2)
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
