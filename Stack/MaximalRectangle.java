class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0)
            return 0;
        int area = 0;    
        int n = matrix[0].length;
        int[] heights = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j <n; j++){
                if(matrix[i][j] == '1'){
                    heights[j]+= 1;
                }else{
                    heights[j] = 0;
                }
            }
            area = Math.max(area,largestRectangleArea(heights,n));
        }
        return area;
    }
    public int largestRectangleArea(int[] heights, int n) {
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n ; i++){
            while(!st.empty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            leftSmall[i] = (st.isEmpty()) ? 0 : (st.peek() + 1);
            st.push(i);
        }

        while(!st.isEmpty()){
            st.pop();
        }

        for(int i = n - 1 ; i >= 0; i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            rightSmall[i] = (st.isEmpty()) ? (n-1) : (st.peek() - 1);
            st.push(i);
        }

        int maxArea = 0;
        for(int i = 0 ;i < n ;i++){
            maxArea =Math.max(maxArea, (rightSmall[i] - leftSmall[i] + 1 ) * heights[i]);
        }

        return maxArea;
    }
}
