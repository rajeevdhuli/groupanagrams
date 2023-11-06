
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast != null){
            while(fast.next != null && fast.val == fast.next.val)
                fast = fast.next;
            if(slow.next == fast)
                slow = slow.next;
            else
               slow.next = fast.next;

            fast = fast.next;    
        }
        return dummy.next;
    }
}
