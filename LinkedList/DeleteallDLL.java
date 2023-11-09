class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        Node cur = head;
        Node pre = null;
        if(head == null)
           return null;
        if(head.next == null && head.data == x)
            return null;
        while(cur != null){
            
            while(cur.data == x && cur.next != null && cur != head){
                pre.next = cur.next;
                cur.next.prev = pre;
                cur = cur.next;
            }
            
            if (cur.data == x && cur.next == null && cur != head){
                pre.next = cur.next;
                cur.prev = null;
                // pre = cur.next;
                // cur = cur.next;
                break;
            }
            else if (cur.data == x &&  cur == head){
                head = cur.next;
                cur = head;
                cur.prev = null;
            }
            else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}



class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        Node cur = head;
        while(cur != null){
            if(cur.data == x){
                if(cur.prev != null){
                    cur.prev.next = cur.next;
                }
                else{
                    head = cur.next;
                }
                if(cur.next != null){
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
        return head;
    }
}
