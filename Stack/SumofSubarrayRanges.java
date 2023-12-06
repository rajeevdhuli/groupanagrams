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
