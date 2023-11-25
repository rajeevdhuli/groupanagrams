subarray sum with goal =  subarray with atmost goal - subarray with atmost goal-1

class Solution {
    public int window(int[] arr, int goal) {
        if(goal < 0)
           return 0;
        int alen = arr.length;
        int cnt =  0;
        int sum = 0;
        int left = 0;
        int right = 0;
        while(right < alen){
            sum+= arr[right];
            while(sum > goal){
                sum-= arr[left];
                left++;
            }
            cnt+=(right-left+1);
            right++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] arr, int goal) {
        return window(arr,goal) - window(arr,goal - 1);
    }
}



USING HASHMAP - 


class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < n ; i++){
            sum+= nums[i];
            if(sum == goal){
                cnt++;
            }
            int rem = sum - goal;
            if(mp.containsKey(rem)){
                cnt+= mp.get(rem);
            }
            mp.put(sum, mp.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}  
