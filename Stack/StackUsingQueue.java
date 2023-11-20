class MyStack {
    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> p = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        while(!q.isEmpty()){
            p.add(q.remove());
        }
        q.add(x);
        while(!p.isEmpty())
           q.add(p.remove());
    }
    
    public int pop() {
        if(!q.isEmpty())
           return q.remove();
        return -1;   
    }
    
    public int top() {
        if(!q.isEmpty())
            return q.peek();
        return -1;    
    }
    
    public boolean empty() {
        return (q.isEmpty());
    }
}
