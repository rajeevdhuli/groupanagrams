class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head .next == null){
            return head;
        }
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode o = odd;
        ListNode e = even;
        int i = 1;
        while(head != null){
            if(i % 2 == 1){
                o.next = head;
                o = o.next;
            }else if(i % 2 == 0){
                e.next = head;
                e = e.next;
            }
            head = head.next;
            i++;
        }
        e.next = null;
        o.next = even.next;
        return odd.next;
    }
}


SHORTER 


class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null)
           return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenFirst = even;
        
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenFirst;
        return head;
    }
}    
