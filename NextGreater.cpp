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
