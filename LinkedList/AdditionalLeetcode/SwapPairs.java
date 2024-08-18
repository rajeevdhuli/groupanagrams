class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy; 
        ListNode cur = head;
        while(cur != null && cur.next != null){
            ListNode first = cur;
            ListNode second = cur.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = prev.next.next;
            //prev = first;
            cur = first.next;
        }
        return dummy.next;
    }
}
