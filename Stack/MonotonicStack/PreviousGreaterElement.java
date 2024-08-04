/*previous greater or next greater to the left*/
class Solution {
    public int[] prevGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n ; i++{
            while(!st.isEmpty() && nums[i] >= st.peek()){
                st.pop();
            }
            ans[i] =  (st.isEmpty()) ? -1 : st.peek();
            st.push(nums[i]);
        }
        return ans;
    }
}
