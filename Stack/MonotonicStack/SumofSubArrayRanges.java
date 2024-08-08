class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        int[] nextSmall = new int[n];
        int[] prevSmall = new int[n];
        int[] nextGreater = new int[n];
        int[] prevGreater = new int[n];
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
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                st.pop();
            }
            nextSmall[i] = (st.isEmpty()) ?  n : (st.peek());
            st.push(i);
        }
        st.clear();
        for(int i  =  0 ; i < n ; i++){
            while(!st.isEmpty() && arr[i] >= arr[st.peek()]){
                st.pop();
            }
            prevGreater[i] = (st.isEmpty()) ?  -1 : (st.peek());
            st.push(i);
        }
        st.clear();
        for(int i  =  n - 1 ; i >= 0 ; i--){
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                st.pop();
            }
            nextGreater[i] = (st.isEmpty()) ?  n : (st.peek());
            st.push(i);
        }
        long minSum = 0 ;
        long maxSum = 0;
        for(int i = 0 ; i  < n ; i++){
            int leftMin = (i - prevSmall[i]);
            int rightMin = (nextSmall[i] - i);
            minSum+= (long)(leftMin * rightMin) * arr[i];
            // minSum = minSum % 1000000007;
            int leftMax = (i - prevGreater[i]);
            int rightMax = (nextGreater[i] - i);
            maxSum+= (long)(leftMax * rightMax) *  arr[i];
            // maxSum = maxSum % 1000000007;
        }
        return (maxSum - minSum);
    }
}




class Solution {
    public long subArrayRanges(int[] arr) {
       int n = arr.length;
        int[] leftl = new int[n];
        int[] rightl = new int[n];
        Stack<int []> st = new Stack<>();

        for(int i = 0; i < n ; i++){
            int cnt = 1;
            while(!st.isEmpty() && arr[st.peek()[0]] >= arr[i] ){
                cnt+= st.peek()[1];
                st.pop();
            }
            leftl[i] = cnt;
            st.push(new int[]{i,cnt}); 
        }

        while(!st.isEmpty()){
            st.pop();
        }

        for(int i = n - 1; i >= 0; i--){
            int cnt = 1;
            while(!st.isEmpty() && arr[st.peek()[0]] > arr[i]){
                cnt+= st.peek()[1];
                st.pop();
            }
            rightl[i] = cnt;
            st.push(new int[]{i,cnt});
        }
       
        while(!st.isEmpty()){
            st.pop();
        }

        int[] leftr = new int[n];
        int[] rightr = new int[n];

        for(int i = 0 ; i < n ; i++){
            int cnt = 1;
            while(!st.isEmpty() && arr[st.peek()[0]] <= arr[i]){
                cnt+= st.peek()[1];
                st.pop();
            }
            leftr[i] =cnt;
            st.push(new int[]{i,cnt});
        }

        while(!st.isEmpty()){
            st.pop();
        }

        for(int i = n - 1; i >= 0; i--){
            int cnt = 1;
            while(!st.isEmpty() && arr[st.peek()[0]] < arr[i]) {
                cnt+= st.peek()[1];
                st.pop();
            }
            rightr[i] =cnt;
            st.push(new int[]{i,cnt});
        }


        long min = 0 ;
        long max = 0;
        for(int i = 0 ; i < n; i++){
            min+= ((long)leftl[i] * rightl[i] * arr[i]);
            max+= ((long)leftr[i] * rightr[i] * arr[i]);
        }
        return max - min;
    }
}
