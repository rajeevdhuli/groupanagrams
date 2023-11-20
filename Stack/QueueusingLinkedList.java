public class Solution extends Queue{
    Node front = null;
    Node rear = null;
    public void push(int x) {
        // Write Your Code Here
        Node temp = new Node(x);
        if(temp == null){
            return;
        }
        if(isEmpty()){
            front = temp;
            rear = temp;
        }
        else{
            rear.next = temp;
            rear = temp;
        }

        
    }

    public int pop() {
        // Write Your Code Here
        int temp = -1;
        if(isEmpty())
           return -1;
        else if(front ==  rear){
            temp = front.data;
            front = null;
            rear = null;
        } 
        else{  
         temp = front.data;
        front = front.next; 
        }  
        return temp;
    }

    boolean isEmpty(){
        if(front == null && rear == null)
            return true;
        return false;    
    }
}
