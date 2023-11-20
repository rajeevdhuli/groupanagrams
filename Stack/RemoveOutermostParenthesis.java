USING STACK

class Solution {
    public  String removeOuterParentheses(String s)
    {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        String sb = "";
        int i = 0;
        while( i < n)
        {
            char ch = s.charAt(i);
            if(ch  == '(')
            {
                if(st.size() != 0)
                   sb+= ch;
                st.push(ch);
            }
            else if( ch == ')')
            {
                if(st.size() != 1)
                   sb+=ch;
                st.pop();   
            }
            i++;
        }
        return sb;
    }

   WITHOUT STACK-

    class Solution {
    public  String removeOuterParentheses(String s)
    {
        //Stack<Character> st = new Stack<>();
        int n = s.length();
        String sb = "";
        int i = 0;
        int count = 0;
        while( i < n)
        {
            char ch = s.charAt(i);
            if(ch  == '(')
            {
                if(count >= 1)
                {
                   sb+= ch;
                   count++;
                }
                else
                   count++;
            }
            else if( ch == ')')
            {
                if(count > 1)
                {
                    sb+=ch;
                    count--;
                }
                else
                    count--;   
            }
            i++;
        }
        return sb;
    }
}
}
