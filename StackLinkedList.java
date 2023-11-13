public class Solution {
    static class Stack {
        //Write your code here
        Node head;
        int size;

        Stack()
        {
            //Write your code here
            head = null;
            size = 0;
        }

        int getSize()
        {
            //Write your code here
            return size;
        }

        boolean isEmpty()
        {
            //Write your code here
            return (size == 0);
        }

        void push(int data)
        {
            //Write your code here
            Node new_node = new Node(data);
            new_node.next = head;
            head = new_node;
            size++;
            
        }

        void pop()
        {
            //Write your code here
            if(isEmpty() == true)
               return;
            size--;
            Node temp = head;
            head = temp.next;
            temp.next = null;   
        }

        int getTop()
        {
            //Write your code here
            if(isEmpty() == true)
               return -1;
            return head.data;   
        }
    }
}
