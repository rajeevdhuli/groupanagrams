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
                    // ()) in this case you dont have to add anything
                    st.pop();
                    i++;
                }else if(!st.isEmpty()  && st.peek() == '('){
                   // () in this case you have to one more')' to balance
                   cnt++;
                   st.pop();
                }else if(st.isEmpty() && i < n - 1 && s.charAt(i+1) == ')'){ 
                    // )) in this case you have to add one more '(' to balance
                    cnt++;
                    i++;
                }else if(st.isEmpty() ){
                    // ) in this case you have to add one opening '(' and one closing ')'
                    // therefore you increment count by 2
                    cnt+= 2;
                }
            }
        }
        if(!st.isEmpty())
        // (((( if all are opening brackets or if string is ending with opening brackets
        //you have to add twp closing brackets for each (2*st.size()) to balance it.
            cnt+= 2*st.size();
        return cnt;
    }
}
