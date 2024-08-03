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




JAVA - 
    
class Solution {
    static String postToPre(String post_exp) {
        // code here
        int n = post_exp.length();
        Stack<String> st = new Stack<>();
        
        for(int i = 0 ; i < n ; i++){
            char ch = post_exp.charAt(i);
            if(Character.isLetter(ch)){
                st.push(String.valueOf(ch));
            }else{
                String c1 = st.pop();
                String c2 = st.pop();
                String temp = ch + c2 + c1;
                st.push(temp);
            }
        }
        return st.pop();
    }
}

