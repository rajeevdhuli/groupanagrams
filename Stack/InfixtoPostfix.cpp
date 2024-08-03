#include <iostream>
#include <stack>

using namespace std;

bool isOperator(char c);
int weight(char c);
bool higherPrec(char c1, char c2);

string infixToPostfix(string exp){
	// Write your code here
	stack<char> st ;
	string res = "";
	for(int i = 0 ;i < exp.length(); i++){

		if(isdigit(exp[i]) || isalpha(exp[i]))
		   res = res + exp[i];

		else if(isOperator(exp[i])){
            while(!st.empty() && st.top() != '(' && higherPrec(st.top(),exp[i])){
				res = res + st.top();
				st.pop();
			}
			st.push(exp[i]);
		}  

		else if (exp[i] == '(')
		   st.push(exp[i]);

		else if (exp[i] == ')'){
			while(!st.empty() && st.top() != '('){
				res = res + st.top();
				st.pop();
			}
			st.pop();
		} 
	} 
	while(!st.empty()){
		res = res + st.top();
		st.pop();
	}
	return res;    
	
}

bool isOperator(char c){
	if( c == '+'|| c == '-'|| c == '*'|| c == '/' || c == '^')
	    return true;
	return false;	
}

int weight(char c){
	int w = -1;
	switch (c) 
	{
        case '+':
        case '-':
            w = 1;
            break;
        case '*':
        case '/':
            w = 2;
            break;
        case '^':
            w = 3;
            break;
    }
    return w;   
       
}

bool higherPrec(char c1, char c2){
	int w1 = weight(c1);
	int w2 = weight(c2);
	if(w1 > w2){
		return true;
	}
	else if(w1 == w2){
		return true;
	}
	return false;
}




JAVA --


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        int n = exp.length();
        String res = "";
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < n; i++){
            char ch = exp.charAt(i);
            if(ch == '('){
                st.push(ch);
            }else if(Character.isLetter(ch) || Character.isDigit(ch)){
                res =  res + ch;
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'){
                while((!st.isEmpty()) && (st.peek() != '(' || st.peek() != ')') &&
                   (higherPrec(st.peek(),ch))){
                       res = res + st.pop();
                   }
                st.push(ch);
            }else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    res = res + st.peek();
                    st.pop();
                }
                st.pop();
            }
        }
        while(!st.isEmpty()){
            res = res + st.pop();
        }
        return res;
    }
    public static boolean higherPrec(char c1, char c2){
        int a = weight(c1);
        int b = weight(c2);
        if(a >= b){
            return true;
        }
        return false;
    }
    public static int weight(char c){
        int num = 0;
        switch (c){
            case '+':
                num = 1;
                break;
            case '-':
                num = 1;
                break;
            case '*':
                num = 2;
                break;
            case '/':
                num = 2;
                break;
            case '^':
                num = 3;
                break;
        }
        return num;
    }
}	
