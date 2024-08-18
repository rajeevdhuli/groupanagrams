class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode les = new ListNode(-1);
        ListNode l = les;
        ListNode greater = new ListNode(-1);
        ListNode g = greater;
        while(cur != null){
            if(cur.val < x){
                l.next = cur;
                l = l.next;
            }else{
                g.next = cur;
                g = g.next;
            }
            cur = cur.next;
        }
        l.next = greater.next;
        g.next = null;
        return les.next;
    }
}
