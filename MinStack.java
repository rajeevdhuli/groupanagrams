lass MinStack {
    
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        st1.push(val);
        if(st2.isEmpty())
            st2.push(val);
        else{
            if(st2.peek() < val)
                st2.push(st2.peek());
            else
                st2.push(val);    
        }    
        
    }
    
    public void pop() {
        if(!st1.isEmpty()){
            st1.pop();
            st2.pop();
        }
        else
            return;    
        
    }
    
    public int top() {
        if(!st1.isEmpty())
           return st1.peek();
        return -1;   
        
    }
    
    public int getMin() {
        if(!st2.isEmpty())
            return st2.peek();
        return -1;    
    }
}
