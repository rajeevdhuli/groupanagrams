class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
    Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();
        
        int st1_sum = 0;
        for(int i = h1.size() - 1; i >= 0; i--){
            st1_sum+=h1.get(i);
            st1.push(st1_sum);
        }
        
        int st2_sum = 0;
        for(int i = h2.size() - 1; i >= 0; i--){
            st2_sum+=h2.get(i);
            st2.push(st2_sum);
        }
        
        int st3_sum = 0;
        for(int i = h3.size() - 1; i >= 0; i--){
            st3_sum+=h3.get(i);
            st3.push(st3_sum);
        }
        int ans = 0;
        
        while(!st1.isEmpty() && !st2.isEmpty() && !st3.isEmpty()){
            
            int st1_top = st1.peek();
            int st2_top = st2.peek();
            int st3_top = st3.peek();
            
            if(st1_top == st2_top && st2_top == st3_top){
                ans = st1_top;
                break;
            }
            
            else{
                if(st1_top >= st2_top && st1_top >= st3_top)
                     st1.pop();
                else if(st2_top >= st1_top && st2_top >= st3_top)
                    st2.pop();
                else if(st3_top >= st1_top && st3_top >= st2_top)
                    st3.pop();   
            }
            
        }
        return ans;

    }

}
