class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        Stack<String> st = new Stack<>();
        int n = pre_exp.length();

        for (int i = n - 1; i >= 0; i--) {
            char ch = pre_exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                // Push operands (numbers or variables) onto the stack
                st.push(String.valueOf(ch));
            } else {
                // Pop two operands from the stack
                String op2 = st.pop();
                String op1 = st.pop();

                // Create the infix expression with parentheses and push it back to the stack
                String expr = "(" + op2 + ch + op1 + ")";
                st.push(expr);
            }
        }

        // The final element of the stack is the infix expression
        return st.pop();
    }
}
