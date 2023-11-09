class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow.next = fast.next;
            fast.next = slow.next.next;
            slow.next.next = fast;

            slow = fast;
            fast = fast.next;

        }
        return dummy.next;
        
    }
}
