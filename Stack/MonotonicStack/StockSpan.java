O(N^2)-

    vector<int> v;
    for(int i=0;i<n;i++)
    {
        int span=1;
        for(int j=i-1;j>=0;j--)
        {
            if(price[i]>price[j])
            {
                span++;
                
            }
        }
        v.push_back(span);
    }
    return v;


O(N) --
class Solution {
    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        // Your code here
        Stack<Integer> st = new Stack<>();
        int[] stock = new int[n];
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && price[i] >= price[st.peek()]){
                st.pop();
            }
            stock[i] = (st.isEmpty()) ? (i+1) :(i -  st.peek());
            st.push(i);
        }
        return stock;
    }
}
