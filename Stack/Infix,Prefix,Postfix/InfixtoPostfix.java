class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        int n = exp.length(); // Get the length of the input expression
        String res = ""; // Initialize the result string
        Stack<Character> st = new Stack<>(); // Initialize the stack to hold operators

        for (int i = 0; i < n; i++) {
            char ch = exp.charAt(i); // Get the current character

            // If the character is '(', push it to the stack
            if (ch == '(') {
                st.push(ch);
            } 
            // If the character is a letter or digit, append it to the result
            else if (Character.isLetter(ch) || Character.isDigit(ch)) {
                res += ch;
            } 
            // If the character is an operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                // While stack is not empty and the top of stack is not '(' and has higher precedence
                while ((!st.isEmpty()) && (st.peek() != '(') && (higherPrec(st.peek(), ch))) {
                    res += st.pop(); // Pop from stack and append to result
                }
                st.push(ch); // Push the current operator to the stack
            } 
            // If the character is ')', pop and append all operators until '(' is found
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res += st.pop();
                }
                st.pop(); // Remove the '(' from the stack
            }
        }
        // Pop all remaining operators from the stack and append to the result
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res; // Return the final postfix expression
    }

    // Function to check if the precedence of c1 is higher or equal to c2
    public static boolean higherPrec(char c1, char c2) {
        int a = weight(c1); // Get the precedence of c1
        int b = weight(c2); // Get the precedence of c2
        return a >= b; // Return true if c1 has higher or equal precedence
    }

    // Function to get the precedence weight of an operator
    public static int weight(char c) {
        int num = 0; // Initialize the weight
        switch (c) {
            case '+':
            case '-':
                num = 1;
                break;
            case '*':
            case '/':
                num = 2;
                break;
            case '^':
                num = 3;
                break;
        }
        return num; // Return the precedence weight
    }
}
