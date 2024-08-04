class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        long[] ans = new long[n];
        Stack<Long> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[i] >= st.peek()){
                st.pop();
            }
            ans[i] = (st.isEmpty()) ? (-1) : (st.peek());
            st.push(arr[i]);
        }
        return ans;
        
    } 
}
