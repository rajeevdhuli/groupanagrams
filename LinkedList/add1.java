Optimal - 

class Solution {
    public Node addOne(Node head) {
        // code here.
        Node cur = reverse(head);
        Node curHead = cur;
        while(cur != null){
            if(cur.data < 9){
                cur.data = cur.data + 1;
                return reverse(curHead);
            }else{
                cur.data = 0;
                if(cur.next == null){
                    cur.next = new Node(1);
                    cur = cur.next;
                    return reverse(curHead);
                }
                cur = cur.next;
            }
        }
        return null;
    }
    public Node reverse(Node head){
        Node prev = null;
        while(head != null){
            Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}










class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        head = reverse(head);
        Node cur = head;
        while(cur.next != null){
            if(cur.data < 9){
                cur.data = cur.data + 1;
                return reverse(head);
            }
            else{
                cur.data = 0;
            }
            cur = cur.next;
        }
        if(cur.data<9)
        {
            cur.data = cur.data + 1;
            return reverse(head);
        }
        else{
            cur.data = 0;
            cur.next = new Node(1);
        }
        return reverse(head);
        
    }
    
    public static Node reverse(Node head)
    {
        Node cur = head;
        Node prev = null;
        
        while(cur != null){
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
