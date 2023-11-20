class Solution {
    public int minAddToMakeValid(String s) {
        int cnt = 0;
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '('){
                st.push(c);
            }
            else{
                if(!st.isEmpty()){
                    st.pop();
                }
                else
                    cnt++;
            }
        }
        if(st.size() != 0)
           cnt = cnt +st.size();
        return cnt;
    }
}
