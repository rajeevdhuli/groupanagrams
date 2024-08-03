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






JAVA - 


class Solution {
    static String preToPost(String pre_exp) {
        // code here
                Stack<String> st = new Stack<>();
        int n = pre_exp.length();

        // Traverse the prefix expression from right to left
        for (int i = n - 1; i >= 0; i--) {
            char ch = pre_exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                // Push operands (numbers or variables) onto the stack
                st.push(String.valueOf(ch));
            } else {
                // Pop two operands from the stack
                String op1 = st.pop();
                String op2 = st.pop();

                // Create the postfix expression and push it back to the stack
                String expr = op1 + op2 + ch;
                st.push(expr);
            }
        }

        // The final element of the stack is the postfix expression
        return st.pop();
    }
}

