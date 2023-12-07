class Solution {
public:
    int maxDepth(string s) {
        int n = s.length();
        int i = 0;
        int cnt = 0;
        stack<int> st;
        int depth = 0;
        while(i < n){
            if(s[i] == '('){
                cnt++;
                depth = max(depth,cnt);
            }else if (s[i] == ')'){
                cnt--;
            }
            i++;
        }
        return depth;
    }
};
