class Solution {
    public boolean isValid(String x) {
         Stack<Character> s=new Stack<>();
        for(int i=-0;i<x.length();i++)
        {
            char ch=x.charAt(i);
            if( ch == '(' || ch == '{' || ch == '[' )
            {
                s.push(ch);
            }
            else
            {
                if(s.isEmpty())
                return false;
                else if((s.peek() == '(' && ch== ')') || (s.peek() == '{' && ch == '}' ) || (s.peek() == '[' && ch == ']'))
                s.pop();
                else
                return false; 
            }

        }
        return s.isEmpty();
    }
}
