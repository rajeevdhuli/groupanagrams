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


O(N) STACK -

import java.util.*;
public class Solution {
    public static int[] findStockSpans(int []prices) {
        // Write your code here.
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && prices[i] > prices[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty())
               ans[i] =i - st.peek() ;
            else{
                ans[i] = i + 1;
            }   
            st.push(i);

        }
        return ans;
    }
}


Optimized - 


import java.util.*;
public class Solution {
    public static int[] findStockSpans(int []prices) {
        // Write your code here.
        int n = prices.length;
        int[] ans = new int[n];
        Stack<int[]> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            int span = 1;
            while(!st.isEmpty() && prices[i] >st.peek()[0]){
                span+= st.peek()[1];
                st.pop();
            }
            ans[i] = span;
            st.push(new int[]{prices[i],span});
        }
        return ans;
    }
}    
