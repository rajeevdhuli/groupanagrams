class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0 ;i < nums.length; i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            int value = mp.get(nums[i]);
            if(value == (int)(nums.length / 3 )+1)
                ans.add(nums[i]);
            if(ans.size() == 2)
                break;    
        }
        return ans;
    }
}

c++ O(N)    -

class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int n = nums.size();
        vector<int> vec;
        int cnt1 = 0;
        int cand1 = INT_MIN;
        int cnt2 = 0;
        int cand2 = INT_MIN;
        for(int i = 0 ; i < n; i++){
            if(cand1 == nums[i] && cand2 != nums[i]) {
                cnt1++;
            }else if(cnt1 == 0 && cand2 != nums[i]){
                cand1 = nums[i];
                cnt1++;
            }else if(cand2 == nums[i] && cand1 != nums[i]){
                cnt2++;
            }else if(cnt2 == 0 && cand1 != nums[i]){
                cand2 = nums[i];
                cnt2++; 
            }else if(cand2 != nums[i] && cand1 != nums[i]){
                cnt1--;
                cnt2--;
            }
        }
        int c1 = 0 , c2 = 0;
        for(int i = 0; i < n ; i++){
            if(nums[i] == cand1){
                c1++;
            }
            if(nums[i] == cand2){
                c2++;
            }
        }
        if(c1 >= (int)(n/3)+1)
           vec.push_back(cand1);
        if(c2 >= (int) (n/3)+1)   
           vec.push_back(cand2);
        return vec;
    }
};    





class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int cand1 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;
        int cand2 = Integer.MIN_VALUE;
        // int cnt1= 1;
        // int cand1 = nums[0];
        // for(int i = 1; i < n ; i++){
        //     if(cand1 != nums[i]){
        //         cand2 = nums[i];
        //         break;
        //     }
        // }
        int i = 0;
        while(i < n){
            if(cnt2 == 0 && nums[i] != cand1 ){
                cand2 =  nums[i];
                cnt2++;
            }
            else if(cnt1 == 0 && nums[i] != cand2){
                cand1 = nums[i];
                cnt1++;
            }
            else if(cand1 == nums[i]){
                cnt1++;
            }
            else if(cand2 == nums[i]){
                cnt2++;
            }
            else if(nums[i] != cand1 && nums[i] != cand2){
                cnt1--;
                cnt2--;
            }
            i++;
        }
        int c1 = 0;
        int c2 = 0;
        for(int j = 0; j < n ; j++){
            if(nums[j] == cand1){
                c1++;
            }
            else if(nums[j] == cand2){
                c2++;
            }
        }
        if(c1  >= ((n/3)+1)){
            ans.add(cand1);
        }
        if(c2  >= ((n/3)+1)){
            ans.add(cand2);
        }
        return ans;
    }
}
