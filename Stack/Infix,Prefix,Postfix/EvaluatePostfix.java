class Solution {
    // Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S) {
        int n = S.length(); // Get the length of the postfix expression
        Stack<Integer> st = new Stack<>(); // Initialize a stack to hold intermediate results

        // Loop through each character in the postfix expression
        for (int i = 0; i < n; i++) {
            char ch = S.charAt(i); // Get the current character

            // If the character is a digit, push its integer value onto the stack
            if (Character.isDigit(ch)) {
                st.push(ch - '0'); // '0' is subtracted to convert char digit to its integer value
            } else {
                // Pop two elements from the stack
                int a = st.pop();
                int b = st.pop();
                int c = 0;

                // Perform the appropriate operation based on the current operator
                if (ch == '+') {
                    c = b + a; // Addition
                } else if (ch == '-') {
                    c = b - a; // Subtraction
                } else if (ch == '*') {
                    c = b * a; // Multiplication
                } else if (ch == '/') {
                    c = b / a; // Division
                }

                // Push the result of the operation back onto the stack
                st.push(c);
            }
        }

        // The final result is the only element left in the stack
        return st.pop();
    }
}
