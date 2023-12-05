class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ;i < n ; i++){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            left[i] = st.isEmpty() ? ( i + 1 ) : (i - st.peek());
            st.push(i);
        }
        while(!st.isEmpty()){
            st.pop();
        }
        for(int i = n - 1 ;i >= 0 ; i--){
            while(!st.isEmpty() && (arr[i] < arr[st.peek()])){
                st.pop();
            }
            right[i] = st.isEmpty() ? ( n - i ) : (st.peek() - i);
            st.push(i);
        }
        long res = 0;
        for(int i = 0; i< n; i++){
            res+= ((long)(right[i] * left[i])*arr[i]);
            res = res % 1000000007;
        }
        return (int)res;
    }
}
