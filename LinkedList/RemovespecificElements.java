class Solution {
    public ListNode removeElements(ListNode head, int value) {
        if(head == null)
           return head;
        while(head !=null && head.val ==value)
           head = head.next;
        if(head == null)
            return null;    
        ListNode cur = head;
        while(cur != null && cur.next != null)
        {
            if(cur.next.val == value)
                cur.next = cur.next.next;
            else
               cur = cur.next;    
        }  
        return head;
    }
}
