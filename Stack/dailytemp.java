class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st= new Stack();
        int n=temperatures.length;
        int ans[]=new int[n];
        st.push(n-1);
        ans[n-1]= 0;
        for(int i = n-2; i >= 0 ;i-- )
        {
            while(st.size() != 0 && temperatures[i] >= temperatures[st.peek()])
                st.pop();
            ans[i] = (st.size()  == 0) ? (0) : (st.peek() - i);
            st.push(i);   
        }
        return ans;
    }
}





class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        int[] ans = new int[n];
        for(int i= n - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek().getKey() <= temperatures[i]){
                st.pop();
            }
            if(st.size() >0)
               ans[i] = st.peek().getValue() - i;
            st.push(new Pair<>(temperatures[i],i)) ;  
        }
        return ans;
    }
}
