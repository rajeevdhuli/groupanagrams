class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        int n = S.length();
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ;i < n; i++){
            char ch = S.charAt(i);
            if(Character.isDigit(ch)){
                st.push(ch - '0');
            }else{
                int a = st.pop();
                int b = st.pop();
                int c = 0 ;
                if(ch == '+'){
                    c = b + a;
                }else if(ch == '-'){
                    c = b - a;
                }else if(ch == '*'){
                    c = b * a;
                }else if(ch == '/'){
                    c = b / a;
                }
                st.push(c);
            }
        }
        return st.pop();
    }
}
