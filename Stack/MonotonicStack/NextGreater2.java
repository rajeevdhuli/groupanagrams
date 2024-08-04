/* for circular array just loop twice 
  [1,2,1]
  First time - [2,-1,-1] and stack contains [1 2].
  when you rotate second time the next greater for index 2 (1) the next greater will be 2 
  hence ans - [2,-1, 2]. */

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        int j = 0;
        while(j < 2){
            for(int i = n - 1; i >= 0 ; i--){
                while(!st.isEmpty() && nums[i] >= st.peek()){
                    st.pop();
                }
                ans[i] = (st.isEmpty()) ? -1 : st.peek();
                st.push(nums[i]);
            }
            j++;
        }
        return ans;
    }
}
