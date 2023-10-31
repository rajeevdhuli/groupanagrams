
class Solution {
    public int maxDepth(String s) 
    {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int i = 0;
        int cnt = 0;
        int maxcnt = 0;
        while( i < n )
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                st.push(ch);
                cnt++;
                maxcnt  = Math.max(maxcnt, cnt);
            }
            else if (ch == ')')
            {
                st.pop();
                cnt--;
            }
            i++;
        }
        return maxcnt;
    }
}
