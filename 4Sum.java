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




class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int  n = nums.length;
        for(int i = 0; i < n - 3; i++)
        {
            if(i > 0 && nums[i] == nums[i-1])
                       continue;
            for(int j = i + 1;j < n - 2; j++)
            {
                if(j - 1 > i  && nums[j] == nums[j-1])
                       continue;
                for(int k = j + 1; k < n - 1; k++)
                {
                    if(k -1 > j  && nums[k] == nums[k-1])
                       continue;
                    for(int l = k + 1; l < n; l++)
                    {
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target)
                        {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            ans.add(temp);
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}



O(n^3) - 


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int  n = nums.length;
        for(int i = 0; i < n - 3; i++)
        {
            if(i > 0 && nums[i] == nums[i-1])
                    continue;
            for(int j = i + 1;j < n - 2; j++)
            {
                if(j - 1 > i  && nums[j] == nums[j-1])
                    continue;
                int left = j + 1;
                int right = n - 1;
                while(left < right)
                {
                    long sum = (long)nums[i] + nums[j] + nums[left] +nums[right];
                    if( sum == target)
                    {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        ans.add(temp);
                        left++;
                        right--;
                        while( left < n && nums[left] == nums[left-1])
                           left++;
                    }
                    else if ( sum < target)
                        left++;
                    else
                        right--;    
                }
            }
        }
        return ans;
    }
}    
