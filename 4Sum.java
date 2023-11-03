O(N^4) - 

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        int  n = nums.length;
        for(int i = 0; i < n - 3; i++)
        {
            for(int j = i + 1;j < n - 2; j++)
            {
                for(int k = j + 1; k < n - 1; k++)
                {
                    for(int l = k + 1; l < n; l++)
                    {
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target)
                        {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}
