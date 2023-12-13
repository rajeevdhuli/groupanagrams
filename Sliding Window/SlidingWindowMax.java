class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int j = 0;
        for(int i = 0; i < n ; i++){
            if(!deque.isEmpty() && deque.peek() == i - k){
                deque.poll();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if( i  >= k - 1){
                ans[j] = nums[deque.peek()];
                j++;
            }

        }
        return ans;
    }
}
