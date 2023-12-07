class Solution {
public:
    int minAddToMakeValid(string s) {
        int n = s.length();
        int i = 0;
        int ans = 0;
        stack<char> st;
        while(i < n){
            if(s[i] == '('){
                st.push(s[i]);
            }else if(s[i] == ')'){
              if(!st.empty())
                st.pop();
              else{
                ans++;
              }  
            }
            i++;
        }
        return ans+st.size();
    }
};
