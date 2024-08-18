O(N),O(1) - Brute froce - 
class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int len = length(head);
        k = (k < len) ?  k :  (k % len);
        if(k == 0){
            return head;
        }
        Node cur = head;
        Node prev = null;
        int i = 1;
        while(cur != null && i < (k + 1)){
            prev = cur;
            cur = cur.next;
            i++;
        }
        prev.next = null;
        Node newHead = cur;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }
    public int length(Node head){
        int length  = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        return length;
    }
}



Optimized using circular array -
class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
        if(head == null || head.next == null || k == 0){
            return head;
        }
        Node cur = head;
        int len = 0;
        Node last = null;
        while(cur != null){
            last = cur;
            cur = cur.next;
            len++;
        }
        last.next = head;
        int rot = (len > k) ? k : (k % len);
        if(rot == 0){
            return head;
        }
        cur = head;
        Node prev = null;
        while(cur != null && rot > 0){
            prev = cur;
            cur = cur.next;
            rot--;
        }
        if(prev != null)
            prev.next = null;
        return cur;
    }
}

