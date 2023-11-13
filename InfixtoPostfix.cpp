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

