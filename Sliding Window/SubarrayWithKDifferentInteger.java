class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
		return window(nums,k)  - window(nums,k-1);
    }
    public int window(int[] nums,int k){
        Map<Integer,Integer> mp = new HashMap<>();
		int n = nums.length;
		int right = 0 ;
		int left = 0 ;
		int maxLength = 0;
        int cnt = 0;
		while(right < n){
			mp.put(nums[right],mp.getOrDefault(nums[right], 0)+1);
			while(mp.size() > k){
				if(mp.get(nums[left]) == 1){
					mp.remove(nums[left]);
				}else{
					mp.put(nums[left],mp.get(nums[left])-1);
				}
				left++;
			}
            cnt+= right - left + 1;
			right++;
		}
		return cnt;
    }
}
