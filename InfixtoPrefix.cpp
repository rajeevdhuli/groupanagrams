/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/
#include <iostream>
#include <stack>
#include <bits/stdc++.h>

using namespace std;

string infixToPrefix(string exp);
bool isOperator(char c);
int weight(char c);
bool higherPrec(char c1, char c2);

string infixToPrefix(string exp){
	// Write your code here
	reverse(exp.begin(),exp.end());
	stack<char> st ;
	for (int i = 0; i < exp.length(); i++) {
 
        if (exp[i] == '(') {
            exp[i] = ')';
        }
        else if (exp[i] == ')') {
            exp[i] = '(';
        }
    }
	string res = "";
	for(int i = 0 ;i < exp.length(); i++){

		if(isdigit(exp[i]) || isalpha(exp[i]))
		   res = res+exp[i];

		else if(isOperator(exp[i])){
            while(!st.empty() && st.top() != '(' && higherPrec(st.top(),exp[i])){
				res =res+  st.top() ;
				st.pop();
			}
			st.push(exp[i]);
		}  

		else if (exp[i] == '(')
		   st.push(exp[i]);

		else if (exp[i] == ')'){
			while(!st.empty() && st.top() != '('){
				res = res+ st.top() ;
				st.pop();
			}
			st.pop();
		} 
	} 
	while(!st.empty()){
		res =res+st.top() ;
		st.pop();
	}
	reverse(res.begin(),res.end());
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
	return false;
}

int main()
{
    string s = "(A-B/C)*(A/K-L)";
   
    // Function call
    cout << infixToPrefix(s) << std::endl;
    re
