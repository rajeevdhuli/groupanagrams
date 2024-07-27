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

c++


class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        int n = nums.size();
        set<vector<int>> set;
        for(int i = 0 ; i < n - 3; i++){
            for(int j = i + 1; j < n - 2; j++){
                for(int k = j + 1; k < n - 1 ; k++){
                    for(int l = k + 1; l < n ; l++){
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target){
                            vector<int> vec;
                            vec.push_back(nums[i]);
                            vec.push_back(nums[j]);
                            vec.push_back(nums[k]);
                            vec.push_back(nums[l]);
                            sort(vec.begin(),vec.end());
                            set.insert(vec);
                        }
                    }
                }
            }
        }
        vector<vector<int>> ans(set.begin(),set.end());
        return ans;
    }
};    



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




Alternate --


 class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        int n = nums.size();
        sort(nums.begin(),nums.end());
        vector<vector<int>> vec;
        for(int i = 0 ; i < n - 3; i++){
            while( i > 0 && i < n - 3 && nums[i] == nums[i-1])
                i++;
            for(int j = i + 1; j < n - 2; j++){
                while(j < n - 2 && j > i + 1 && nums[j] == nums[j-1])
                    j++;
                int left = j + 1;
                int right = n - 1;
                while(left < right){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[left];
                    sum += nums[right];
                    /* since sum is large make sure you are adding individually*/
                    if(sum > target){
                        right--;
                    }else if (sum < target){
                        left++;
                    }else{
                        vector<int> temp = {nums[i],nums[j],nums[left],nums[right]};
                        vec.push_back(temp);
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }
                }
            }
        }
        return vec;
    }
};   
    
