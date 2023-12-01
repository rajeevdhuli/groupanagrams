class Solution {
    public int calculate(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Integer> values = new Stack<>();
        int n = s.length();
        int i = 0;
        ops.push('+');
        values.push(0);
        while(i < n){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int j = i ;
                while(j < s.length() && Character.isDigit(s.charAt(j))){
                    j++;
                }
                int val = Integer.parseInt(s.substring(i,j)); 
                if(ops.peek() == '('){
                    values.push(val);
                }else{
                    char op = ops.pop();
                    if(op == '+'){
                        values.push(values.pop() + val);
                        System.out.println(values.peek() );
                    }else if (op == '-'){
                        values.push(values.pop() - val);
                        System.out.println(values.peek() );
                    }
                }
                i = j;  
            }
            else if(c == '('){
                if(!Character.isDigit(s.charAt(i+1))){
                    values.push(0);
                }
                ops.push(c);
                i++;
            }
            else if (c  == ')'){
                ops.pop();
                int v = values.pop();
                if(!ops.isEmpty() && ops.peek() == '+'){    
                    ops.pop();               
                    values.push(values.pop()+v);
                }else if (!ops.isEmpty() && ops.peek() == '-'){
                    ops.pop();
                    values.push(values.pop() - v);
                }
                i++;
            }
            else if(c == ' '){
                i++;
            }
            else{
                ops.push(s.charAt(i));
                i++;
            }
        } 
        int res = 0;
        while(!values.isEmpty()){
            res += values.pop();
        }
        return res; 
    }
}
