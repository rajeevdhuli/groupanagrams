class Solution {
    public int minInsertions(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        int cnt = 0;
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch == '('){
                st.push(ch);
            }else if (ch == ')'){
                if(i < n - 1  && s.charAt(i+1) == ')' && !st.isEmpty()){
                    st.pop();
                    i++;
                }
                else if(st.isEmpty() && i < n - 1 && s.charAt(i+1) == ')'){ 
                    cnt++;
                    i++;
                }else if(st.isEmpty() ){
                  cnt+= 2;
                }else if(!st.isEmpty()  && st.peek() == '('){
                   cnt++;
                   st.pop();
                }
            }
        }
        if(!st.isEmpty() )
            cnt+= 2*st.size();
        return cnt;
    }
}
