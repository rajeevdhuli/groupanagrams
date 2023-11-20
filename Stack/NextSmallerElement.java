public class Solution {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> st = new Stack<>();
        int n = A.length;
        int[] ans  = new int[n];
        for(int i= 0 ;i < n;i++)
        {
            while(!st.empty() && st.peek() >= A[i])
                st.pop();
            ans[i] = (st.empty())? (-1) : st.peek();
            st.push(A[i]);    
        }
        return ans;
        
    }
}
