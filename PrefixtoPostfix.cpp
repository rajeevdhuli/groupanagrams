#include <iostream>
#include <stack>
#include <string>

using namespace std;

string preToPost(string s) {
    // Write Your Code Here
    int n = s.length();
    string res = "";
    stack<string> st;
    for(int i = n - 1; i >= 0; i--){
        if(isalpha(s[i]) || isdigit(s[i])){
            string temp(1,s[i]);
            st.push(temp);
        }else{
            string op1 = st.top();
            st.pop();
            string op2 = st.top();
            st.pop();
            string temp = op1 + op2 + s[i];
            st.push(temp);
        }
    }
    res = st.top();
    return res;
