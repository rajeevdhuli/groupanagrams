O(N*M) , O(M) - 
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0 ;
        int[] heights= new int[m];
        for(int row = 0 ; row < n; row++){
            for(int col = 0; col < m; col++){
                if(matrix[row][col] == '1'){
                    heights[col]+= 1;
                }else{
                    heights[col] = 0;
                }
            }
            maxArea = Math.max(maxArea,largestRectangleArea(heights));
        }
        return maxArea;
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0 ;
        int n = heights.length;
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =  0; i < n ; i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            leftSmall[i] = (st.isEmpty()) ? -1 : (st.peek());
            st.push(i);
        }
        st.clear();
        for(int i =  n - 1; i >= 0 ;i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            } 
            rightSmall[i] = (st.isEmpty()) ? n :(st.peek());
            st.push(i);
        }
        for(int i = 0; i < n; i++){
            maxArea = Math.max(maxArea,(rightSmall[i] - leftSmall[i] - 1) * heights[i]);
        }
        return maxArea;
    }
}
