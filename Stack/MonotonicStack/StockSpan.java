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
