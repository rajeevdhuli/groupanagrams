o(n), o(n) -

class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int depth = 0;
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
                depth++;
            }else if(ch == ')'){
                st.pop();
                depth--;
            }
            maxDepth = Math.max(maxDepth,depth);
        }
        return maxDepth;
    }
}


o(n), o(1) -

class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')') {
                currentDepth--;
            }
        }

        return maxDepth;
    }
}
