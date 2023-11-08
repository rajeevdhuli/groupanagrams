class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode les = new ListNode(-1);
        ListNode greater = new ListNode(-1);
        ListNode l = les;
        ListNode g = greater;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                l.next = cur;
                l = l.next;
            }
            
            else{
                g.next = cur;
                g = g.next;
            }
            
            cur = cur.next;
        }
        l.next = greater.next;
        greater = null;
        g.next = null;
        head = les.next;
        les = null;
        return head;
    }
}
