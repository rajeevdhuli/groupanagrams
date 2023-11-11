class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        int j = 0;
        while(j< 2){
            for(int i = n - 1; i >= 0; i--){
                while(!st.isEmpty() && st.peek() <= nums[i ])
                    st.pop();
                ans[i] = (st.isEmpty()) ? (-1) : (st.peek());
                st.push(nums[i]);
            }
            j++;
        }
        return ans;
        
    }
}
