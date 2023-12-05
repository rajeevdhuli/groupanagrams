O(N^2),O(1) -


class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j = i ; j < n ; j++){
                minHeight = Math.min(minHeight,heights[j]);
                maxArea = Math.max(maxArea,minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
}



O(N) , O(3N) -


class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        Stack<Integer> st = new Stack<>();
        //left Boundary
        for(int i = 0; i < n ; i++){
            while(!st.empty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            leftSmall[i] = (st.isEmpty()) ? 0 : (st.peek() + 1);
            st.push(i);
        }
        //Empty Stack
        while(!st.isEmpty()){
            st.pop();
        }
        //Right Boundary
        for(int i = n - 1 ; i >= 0; i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            rightSmall[i] = (st.isEmpty()) ? (n-1) : (st.peek() - 1);
            st.push(i);
        }
        //Calaculate Area
        int maxArea = 0;
        for(int i = 0 ;i < n ;i++){
            maxArea =Math.max(maxArea, (rightSmall[i] - leftSmall[i] + 1 ) * heights[i]);
        }
        return maxArea;
    }
}






O(N),O(N) -


class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0 ;
        for(int i =0 ; i <= n; i++){
            while(!st.isEmpty() && (i == n ||  heights[i] <= heights[st.peek()])){
                int height = heights[st.peek()];
                st.pop();
                int width = (st.isEmpty()) ? i : (i - st.peek() - 1);
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        return maxArea;

    }
}    
