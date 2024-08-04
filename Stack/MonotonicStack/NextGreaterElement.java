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



#include <stack>
vector<int> nextGreaterElement(vector<int>& arr, int n)
{
	// Write your code here
    vector<int> v;
    stack<int> st;
    for(int i = n-1; i >= 0; i--)
    {
        while((!st.empty()) && st.top() <= arr[i])
            st.pop();
        int prev = (st.empty()) ? (-1) : (st.top());
        v.push_back(prev);
        st.push(arr[i]);
    }
    reverse(v.begin(),v.end());
    return v;
}
