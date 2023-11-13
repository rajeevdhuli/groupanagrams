#include <iostream>
#include <stack>
#include <string>

using namespace std;


string postfixToPrefix(string &s){
    // Write your code here.
    string res = "";
    stack<string> st;
    for(int i = 0 ;i < s.length(); i++){
        if(isalpha(s[i]) || isdigit(s[i])){
            string temp(1,s[i]);
            st.push(temp);
        }

        else{
            string op1 = st.top();
            st.pop();
            string op2 = st.top();
            st.pop();
            string temp = s[i] + op2 + op1;
            st.push(temp);
        }
    }
    res = st.top();
    return res;
}
