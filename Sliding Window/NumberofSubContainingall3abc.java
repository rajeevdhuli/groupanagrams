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





More easy to understand



class Solution {
public:
    int numberOfSubstrings(string s) {
        int n = s.size();
        int start = 0;
        int cnt = 0 ;
        unordered_map<char,int> mp;
        for(int end = 0 ; end < n ; end++){
            mp[s[end]]++;
            while(mp.size() == 3){
                cnt+= (n-end);
                if(mp[s[start]] ==  1){
                    mp.erase(s[start]);
                }else{
                    mp[s[start]]--;
                }
                start++;
            }
        }
        return cnt;
    }
};



Brute force - 




#include <iostream>
#include <unordered_set>
#include <string>

class Solution {
public:
    int numberOfSubstrings(std::string s) {
        int n = s.size();
        int cnt = 0;
        
        for (int start = 0; start < n; start++) {
            std::unordered_set<char> distinctChars;
            for (int end = start; end < n; end++) {
                distinctChars.insert(s[end]);
                if (distinctChars.size() == 3) {
                    cnt += (n - end);
                    break;
                }
            }
        }
        
        return cnt;
    }
};

int main() {
    Solution sol;
    std::string s = "abcabc";
    std::cout << sol.numberOfSubstrings(s) << std::endl; // Output: 10
    return 0;
}
