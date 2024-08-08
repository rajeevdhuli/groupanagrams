class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nextSmall = new int[n];
        int[] prevSmall = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i  =  0 ; i < n ; i++){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            prevSmall[i] = (st.isEmpty()) ?  -1 : (st.peek());
            st.push(i);
        }
        st.clear();
        for(int i  =  n - 1 ; i >= 0 ; i--){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            nextSmall[i] = (st.isEmpty()) ?  n : (st.peek());
            st.push(i);
        }
        int res = 0 ;
        for(int i = 0 ; i  < n ; i++){
            int left = (i - prevSmall[i]);
            int right = (nextSmall[i] - i);
            res+= (long)(left * right *  arr[i]);
            res = res % 1000000007;
        }
        return (int) res;
    }
}
