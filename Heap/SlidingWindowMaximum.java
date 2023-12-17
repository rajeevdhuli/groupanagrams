class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Integer a,Integer b){
                return b - a;
            }
        });
        for(int i = 0 ; i < n ; i++){
            int start = i - k ;
            if(start >= 0){
                pq.remove(nums[start]);
            }
            pq.offer(nums[i]);
            if(pq.size() == k){
                ans[i - k + 1] = pq.peek();
            }
        }
        return ans;
    }
}
