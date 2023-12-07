USING STACK

class Solution {
public:
    string removeOuterParentheses(string s) {
        int n = s.length();
        int i = 0;
        stack<char> st;
        string res;
        while(i < n){
            if(s[i] == '('){
                st.push(s[i]);
                if(st.size() > 1){
                    res+= s[i];
                }
            }else if(s[i] == ')'){
                if(st.size() > 1){
                    res+= s[i];
                }
                st.pop();
            }
            i++;
        }
        return res;
    }
};




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
