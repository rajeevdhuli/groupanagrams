class Solution {
public:
    int numberOfSubstrings(string s) {
        unordered_map<char,int> mp;
        int start = 0, end = 0;
        int n = s.length();
        int cnt = 0;
        while(end < n){
            mp[s[end]]++;
            while(mp['a'] >= 1 && mp['b'] >= 1 && mp['c'] >= 1){
                cnt+= n - end;
                if(mp[start] == 1){
                    mp.erase(start);
                }else{
                    mp[start]--;
                }
                start++;
            }
            end++;
        }
        return cnt;
    }
};


example - a b a b c b c a
  for 1st,
    a b a b c
    a b a b c | b 
    a b a b c | b c
    a b a b c | b c a
  so it reaches all characters then it will be same window for others hence cnt = n - j;
