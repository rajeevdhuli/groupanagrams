public class Solution {
    public int[] prevSmaller(int[] A) {
        int n = A.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && A[i] <= st.peek()){
                st.pop();
            }
            ans[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(A[i]);
        }
        return ans;
    }
}
