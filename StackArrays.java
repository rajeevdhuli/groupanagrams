public class Solution{
    static class Stack {
        //int[] arr = new int[capacity];
        int top ;
        int capacity;
        int arr[];
        Stack(int capacity) {
            // Write your code here.
            arr = new int[capacity];
            top = -1;
            this.capacity = capacity;
        }
        public void push(int num) {
            // Write your code here.
            if(isFull() == 1)
               return ;
            else   
               arr[++top] = num;
            
         

        }
        public int pop() {
            // Write your code here.
            if(top == -1)
               return -1;
            return arr[top--];   
        }
        public int top() {
            // Write your code here.
           if(isEmpty()==1)
              return -1;
           return arr[top];
        }
        public int isEmpty() {
            // Write your code here.
            if (top ==  -1)
                return 1;
            return 0;
        }
        public int isFull() {
            // Write your code here.
            if(top == capacity - 1)
               return 1;
            return 0;   


        }
    }
}
