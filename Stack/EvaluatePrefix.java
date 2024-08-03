import java.util.Stack;

class Solution {
    // Function to evaluate a prefix expression.
    public static int evaluatePreFix(String S) {
        Stack<Integer> st = new Stack<>();
        int n = S.length();

        // Traverse the prefix expression from right to left
        for (int i = n - 1; i >= 0; i--) {
            char ch = S.charAt(i);

            if (Character.isDigit(ch)) {
                // Convert character digit to integer and push to stack
                st.push(ch - '0'); // '0' to integer conversion
            } else {
                // Ensure there are at least two operands to apply the operator
                if (st.size() < 2) {
                    throw new IllegalArgumentException("Invalid prefix expression");
                }

                // Pop two operands
                int a = st.pop();
                int b = st.pop();
                int result = 0;

                // Apply the operator
                switch (ch) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }

                // Push the result back to stack
                st.push(result);
            }
        }

        // The result should be the only element left in the stack
        if (st.size() != 1) {
            throw new IllegalArgumentException("Invalid prefix expression");
        }
        
        return st.pop();
    }

    public static void main(String[] args) {
        String prefix = "-+231*9"; // Example prefix expression (equivalent to postfix "231*+9-")
        System.out.println("Result: " + evaluatePreFix(prefix));
    }
}
