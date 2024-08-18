O(2N),O(1) -
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        if(length == 1)
           return null;
        int positionFromHead = length - n;
        ListNode cur = head;
        if(length == n)
        {
            ListNode new_head = cur.next;
            return new_head;
        }
        while (positionFromHead -1 > 0) {
            cur = cur.next;
            positionFromHead--;
        }
        ListNode temp = cur.next;
        cur.next = cur.next.next;
        temp = null;
        return head;
    }
}

Optimized - 
  
The core idea is to create a gap of n nodes between two pointers (fast and slow) so that when fast reaches the end of the list,
slow is perfectly positioned to modify the list and remove the nth node from the end. This method is both time-efficient (O(n) complexity) and space-efficient (O(1) complexity).
  
O(N) , O(1) - 

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int i = 1;
        while(i <= n){
            fast = fast.next;
            i++;
        }
        // If fast is null, that means we're removing the head
        if(fast == null){
            return head.next;
        }
        while(slow !=  null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
