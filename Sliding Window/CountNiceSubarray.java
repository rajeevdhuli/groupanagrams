USING SLIDING WINDOW AT MOST METHOD -

class Solution {
    public int window(int[] nums, int k){
        if(k < 0){
            return 0;
        }
        int sum = 0 ;
        int cnt  = 0 ;
        int right = 0 , left = 0;
        while(right < nums.length){
            if(nums[right] % 2 == 1){
                sum++;
            }
            while(sum > k && left <= right){
                if(nums[left] % 2 ==1)
                   sum--;
                left++;  
            }
            cnt+= right - left + 1;
            right++;
        }
        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k){
        return window( nums, k) - window(nums, k-1);
    }
}







HASHMAP -



class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
        int cnt =0;
        int sum =0;
        for(int i =0; i < n; i++)
        {
            if(nums[i]%2 == 1)
               sum++;
            if(sum == k)
               cnt++;
            int rem = sum -k;
            if(mp.containsKey(rem))
               cnt+= mp.get(rem);
            mp.put(sum,mp.getOrDefault(sum,0)+1);         
        }
        return cnt;
    }
}  
  
  
