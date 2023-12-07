O(N^2) O(2N) - 

class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int i = 0;
        String res = "";
        Stack<Character> st = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        while( i < n ){
            if(s.charAt(i) == '('){
                st.push('(');
            }else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                st.push(s.charAt(i));
            }else if (s.charAt(i) == ')'){
                while(st.peek() != '('){
                   q.add(st.pop());
                }
                st.pop();
                while(!q.isEmpty()){
                  st.push(q.remove());
                }
            } 
            i++;
        }
        while(!st.isEmpty()){  
          res= st.pop() + res;
        }
        return res;
    }
}





class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        String str = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                str += s.charAt(i);
            }else if(s.charAt(i) == '('){
                st.push(str);
                str = "";
            }else{
                String p = st.pop();
                System.out.println(p);
                String r = new StringBuilder(str).reverse().toString();
                str = p + r;               
            }                
        }
        return str;
    }
}
