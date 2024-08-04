class Solution {
    // Function to convert a prefix expression to a postfix expression.
    static String preToPost(String pre_exp) {
        int n = pre_exp.length(); // Get the length of the prefix expression
        Stack<String> st = new Stack<>(); // Initialize a stack to hold intermediate results
        
        // Loop through each character in the prefix expression in reverse order
        for (int i = n - 1; i >= 0; i--) {
            char ch = pre_exp.charAt(i); // Get the current character
            
            // If the character is a letter, push it onto the stack as a string
            if (Character.isLetter(ch)) {
                st.push(String.valueOf(ch));
            } 
            // If the character is an operator
            else {
                // Pop two elements from the stack
                String c1 = st.pop();
                String c2 = st.pop();
                
                // Form a new string with the format (operand1 operand2 operator)
                String temp = c1 + c2 + ch;
                
                // Push the new string back onto the stack
                st.push(temp);
            }
        }
        // The final result is the only element left in the stack
        return st.pop();
    }
}
