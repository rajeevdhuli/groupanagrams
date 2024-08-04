import java.util.Stack;

class Solution {
    // Function to evaluate a prefix expression.
    public static int evaluatePreFix(String S) {
        int n = S.length(); // Get the length of the prefix expression
        Stack<Integer> st = new Stack<>(); // Initialize a stack to hold intermediate results

        // Loop through each character in the prefix expression from right to left
        for (int i = n - 1; i >= 0; i--) {
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
                switch (ch) {
                    case '+':
                        c = a + b; // Addition
                        break;
                    case '-':
                        c = a - b; // Subtraction
                        break;
                    case '*':
                        c = a * b; // Multiplication
                        break;
                    case '/':
                        c = a / b; // Division
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }

                // Push the result of the operation back onto the stack
                st.push(c);
            }
        }

        // The final result is the only element left in the stack
        return st.pop();
    }

    public static void main(String[] args) {
        String prefix = "-+*2319"; // Example prefix expression
        System.out.println("Result: " + evaluatePreFix(prefix));
    }
}
