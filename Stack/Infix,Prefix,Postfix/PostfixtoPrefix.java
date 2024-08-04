class Solution {
    // Function to convert a postfix expression to a prefix expression.
    static String postToPre(String post_exp) {
        int n = post_exp.length(); // Get the length of the postfix expression
        Stack<String> st = new Stack<>(); // Initialize a stack to hold intermediate results
        
        // Loop through each character in the postfix expression
        for (int i = 0; i < n; i++) {
            char ch = post_exp.charAt(i); // Get the current character
            
            // If the character is a letter, push it onto the stack
            if (Character.isLetter(ch)) {
                st.push(String.valueOf(ch));
            } 
            // If the character is an operator
            else {
                // Pop two elements from the stack
                String c1 = st.pop();
                String c2 = st.pop();
                
                // Form a new string with the operator followed by the two popped elements
                String temp = ch + c2 + c1;
                
                // Push the new string back onto the stack
                st.push(temp);
            }
        }
        // The final result is the only element left in the stack
        return st.pop();
    }
}
