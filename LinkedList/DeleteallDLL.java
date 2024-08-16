class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        Node cur = head;
        if(head == null)
           return null;
        while(cur != null){
            Node nextNode = cur.next;
            //remove head of a dll
            if(cur.data == x && cur == head){
                head = head.next;
                cur.prev = null;
            }//remove head of a dll if it contains only one element
            else if (cur.data == x && cur.next == null && cur == head){
                head = null;
            }//remove the middle ones
            else if(cur.data == x && cur.next != null && cur != head){
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
            }//remove the last element of dll
            else if(cur.data == x && cur.next == null && cur != head){
                cur.prev.next = cur.next;
            }
            //clean up the garbage
            if(cur.data == x){
                cur.prev = null;
                cur.next = null;
            }
            //move cur to next 
            //u can cur = cur.next, if u were not clenaing up
            cur = nextNode;
        }
        return head;
    }
}

class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        if(head == null){
            return null;
        }
        Node cur = head;
        while(cur != null){
            if(cur.data == x){
                if(cur.prev != null){
                    cur.prev.next = cur.next;
                }else{
                    head = cur.next;//update first node if deleting the first node
                }
                if(cur.next != null){
                    cur.next.prev = cur.prev;
                }
                //clean the node being deleted
                cur.next = null;
                cur.prev = null;
            }
            cur = cur.next;
        }
        return head;
    }
}
