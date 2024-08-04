class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            if(!isOperator(tokens[i])) {
                st.push(Integer.parseInt(tokens[i]));
            }
            else if(isOperator(tokens[i])){
                int c1 = st.pop();
                int c2 = st.pop();
                int res = perform(tokens[i],c1,c2);
                st.push(res);
            }   
        }
        return st.pop();
    }
    public static int perform(String s,int i,int j){
        int ans = 1;
        switch (s)
        {
            case "+":
            ans = i + j;
            break;
            case "-":
            ans = j - i;
            break;
            case "*":
            ans = i * j;
            break;
            case "/":
            ans = j / i;
            break;
            default:
            ans = -1;
            break;
        }
        return ans;
    }
    boolean isOperator(String s){
        if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*"))
            return true;
        return false;    
    }
}
