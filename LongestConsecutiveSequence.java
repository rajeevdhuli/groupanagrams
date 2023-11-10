class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }
        int cnt = 1;
        int Maxcnt = 0;
        for(int i : set){
            if(set.contains(i-1))
                continue;
            else{
                while(set.contains(i+1)){
                    cnt++;
                    i++;
                }
                Maxcnt=Math.max(cnt,Maxcnt);
                cnt = 1;  
            }
              
        }
        return Maxcnt;

    }
}
