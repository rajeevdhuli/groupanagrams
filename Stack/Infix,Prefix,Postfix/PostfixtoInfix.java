class Solution {
    // Function to convert a postfix expression to an infix expression.
    static String postToInfix(String post_exp) {
        Stack<String> st = new Stack<>(); // Initialize a stack to hold intermediate results
        int n = post_exp.length(); // Get the length of the postfix expression

        // Loop through each character in the postfix expression
        for (int i = 0; i < n; i++) {
            char ch = post_exp.charAt(i); // Get the current character

            // If the character is a letter or digit, push it onto the stack as a string
            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } 
            // If the character is an operator
            else {
                // Pop two elements from the stack
                String op2 = st.pop();
                String op1 = st.pop();
                
  
