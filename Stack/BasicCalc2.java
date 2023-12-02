class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int i = 0;
        int val = 0;
        char operation = '+';
        while(i < n){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                val = val*10 + (c - '0');
                i++;
            }else if (c == ' '){
                i++;
            }
            if((!Character.isDigit(c) && c != ' ') ||(i == n  )){
                switch(operation)
                {
                    case '+':
                        stack.push(val);
                        break;
                    case '-':
                        stack.push(-val);
                        break;
                    case '*':
                        stack.push(stack.pop() * val);
                        break;
                    case '/':
                        stack.push(stack.pop() / val);
                        break;           
                }
                operation = c;
                val  = 0;
                i++;
            }
        }
        int res = 0 ;
        while(!stack.isEmpty()){
            res+= stack.pop();
        }
        return res;
    }
}
