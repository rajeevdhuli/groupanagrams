import java.util.Stack;
public class Solution {
    public static String prefixToInfixConversion(String exp) {
        // Write your code here
        Stack<String> st = new Stack<>();
        String res = "";
        for(int i = exp.length() - 1; i >= 0 ; i--){
            if(Character.isLetterOrDigit(exp.charAt(i))){
                //String temp =""+ exp.charAt(i);
                String temp = String.valueOf(exp.charAt(i));
                st.push(temp);
            }
            else{
                String op1 = st.pop();
                String op2 = st.pop();
                String temp = '(' + op1 + exp.charAt(i) + op2 + ')';
                st.push(temp);
            }
        }
        res= st.pop();
        return res;
    }
}
