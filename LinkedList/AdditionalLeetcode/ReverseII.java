class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur =head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        int i;
        for(i = 1 ; i < m ;i++)
        {
            prev = cur;
            cur = cur.next;
        }
        ListNode rtail = cur;
        ListNode rhead = null;
        while(i <= n)
        {
            ListNode temp = cur.next;
            cur.next = rhead;
            rhead = cur;
            cur = temp;
            i++;
        }
        prev.next = rhead; 
        rtail.next = cur;
        return dummy.next;   
    }
}


WITHOUT DUMMY - 
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur =head;
        ListNode prev = null;
        int i;
        for(i = 1 ; i < m ;i++)
        {
            prev = cur;
            cur = cur.next;
        }
        ListNode rtail = cur;
        ListNode rhead = null;
        while(i <= n)
        {
            ListNode temp = cur.next;
            cur.next = rhead;
            rhead = cur;
            cur = temp;
            i++;
        }
        if(prev == null)
            head = rhead;
        else    
            prev.next = rhead; 
        rtail.next = cur;
        return head;   
    }
}
