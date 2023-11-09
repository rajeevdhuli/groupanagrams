lass Solution {
    public ListNode mergeNodes(ListNode head) {
        if(head == null) return head;
        ListNode cur = head;
        ListNode prev = new ListNode();
        ListNode ans = prev;
        cur = cur.next;
        int sum  = 0;
        while(cur != null){
            if(cur.val != 0){
                sum+= cur.val;
            }
            else{
                cur.val = sum;
                sum = 0;
                prev.next = cur;
                prev = prev.next;

            }
            cur = cur.next;
        }
        prev.next = null;
        return ans.next;
    }
}
