#include <iostream>
#include <stack>
#include <string>

using namespace std;

bool isOperator(char c);

string postToInfix(string postfix) {
    // Write your code here.
    stack<string> st;
    string res = "";

    for(int i = 0; i < postfix.length(); i++){

        if (isalpha(postfix[i]) || isdigit(postfix[i])) {
           string temp (1,postfix[i]);
           st.push(temp);
        }else if (isOperator(postfix[i])) {
           string op1 = st.top();
           st.pop();
           string op2 = st.top();
           st.pop();
           string temp = '(' + op2 + postfix[i] + op1 + ')';
           st.push(temp);
        }
    }
    res = st.top();
    return res;
}

bool isOperator(char c){
    if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
        return true;
    return false;    
}




import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        String postfixExpression = "ab+c*d-";
        String infixExpression = postToInfix(postfixExpression);
        System.out.println("Infix Expression: " + infixExpression);
    }

    static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    static String postToInfix(String postfix) {
        Stack<String> stack = new Stack<>();
        String result = "";

        for (int i = 0; i < postfix.length(); i++) {
            if (Character.isLetterOrDigit(postfix.charAt(i))) {
                stack.push(String.valueOf(postfix.charAt(i)));
            } else if (isOperator(postfix.charAt(i))) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "(" + op2 + postfix.charAt(i) + op1 + ")";
                stack.push(temp);
            }
        }

        result = stack.pop();
        return result;
    }
}
