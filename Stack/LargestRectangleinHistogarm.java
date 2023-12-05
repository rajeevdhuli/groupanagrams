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









class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        // this problem should be solved using stack .
        /* whenever you see a monotonic increase in the input which      
		would yield  the answer closest to 
		required you gotta understand that you should
		use  a stack datastructure to  calculate the answer*/
        // so let's begin by creating a stack and ans that we return 
        stack<int> st;
        int ans=0;
        //just to make our code understand better i'm adding 0 at the end of
        //heights
        heights.push_back(0);
        /* how do you add the elements to the stack ? mmmmmm? okay 
		let us think 
        way ,lets add all the ascending order elements to the stack so that 
		it
        looks like climbing steps .coz in that way we can have atleast the 
		min
        size step * number of elements in the stack .if we encounter any 
		bar with         lesser height than the top element of the stack ,we 
		will compute the 
        existing stack element area and pop the top element just to check 
		if the 
        current top < bar height ,if it is so ..add it to the stack ..i think it        
		will be more clearer if you go through the code*/
         //very important note .. we are adding indices ..not the values
        for(int i=0;i<heights.size();i++){
            while(!st.empty() && heights[st.top()]>heights[i]){
                //here we are checking if stack is empty or if we encounter 
				any 
                // number that doesn't satisfy our stack filling property
                int top=heights[st.top()];
                st.pop();
                int ran=st.empty()?-1:st.top();
                //this is to check if stack is empty, if so we will just take the                 //index
                ans=max(ans,top*(i-ran-1));
                // this is just to take the max area covered so far
            }
            st.push(i);
            //we push into the stack as long as it satsifies our stack condition
        }
        return ans;
        // i know it's not a very clever explanation ..but i tried to explain 
        //whatever i can ...HAPPY CODING!!
    }
};
