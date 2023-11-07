class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
           return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenFirst = even;
        
        while(head != null){

            if(even.next == null){
                odd.next = evenFirst;
                break;
            }


            odd.next = even.next;
            odd = odd.next;

            if(odd.next ==  null){
                odd.next = evenFirst;
                even.next = null;
                break;
            }

            even.next = odd.next;
            even = even.next;
        }
        return head;
    }
}
