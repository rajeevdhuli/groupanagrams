class Solution {
    
    public ListNode removeNodes(ListNode head) {

        if(head == null && head.next == null)
            return head;

        head = reverse(head);

        ListNode cur = head;
        int max = cur.val;
        ListNode prev = cur;
        cur = cur.next;
        
        while(cur != null){

            if(cur.val >= max){
                max = cur.val;
                prev = cur;
            }

            else{ 
                prev.next = cur.next;
            }
            
            cur = cur.next;
        }
        return reverse(head);

    }
    public static ListNode reverse(ListNode head){

        ListNode cur = head;
        ListNode prev = null;

        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }
}
