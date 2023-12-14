O(n2) O(n) using stack -
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] nextGreater = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n -1; i >= 0; i--){
            while(!st.isEmpty() && nums[i] >= nums[st.peek()]){
                st.pop();
            }
            nextGreater[i] = (st.isEmpty()) ? n : st.peek();
            st.push(i);
        }
        int[] ans = new int[n - k + 1];
        int j = 0;
        for(int i = 0 ; i < n - k + 1 ; i++){
            if(j < i){
                j = i;
            }
            while(nextGreater[j] < i + k){
                j = nextGreater[j];
            }
            ans[i] = nums[j];
        }    
        return ans;
    }
}



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





