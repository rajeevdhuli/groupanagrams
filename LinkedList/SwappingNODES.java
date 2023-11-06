JUST SWAPPING VLAUES

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        if(head ==  null || head.next == null)
           return head;

        int len = 0;
        while(cur!= null)
        {
            len++;
            cur = cur.next;
        }

        cur = head;
        int i = 1;
        while(i < k)
        {
            cur = cur.next;
            i++;
        }   
        ListNode left = cur;
        
        cur = head;
        int j = 1;
        while(j < (len-k+1))
        {
            cur = cur.next;
            j++;
        }
        ListNode right = cur;
        
        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return head;

    }
}

SWAPPING NODES

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        if(head == null || head.next == null)
           return head;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        ListNode prev1 = null,cur1 = head;
        int i = 1;
        while(cur1 != null && i < k)
        {
            prev1 = cur1;
            cur1 = cur1.next;
            i++;
        }
        
        i = 1;
        ListNode cur2 = head, prev2 = null;
        while(cur2 != null && i < (len - k + 1))
        {
            prev2 = cur2;
            cur2=cur2.next;
            i++;
        }
        if(prev1 == null)
        {
            head = cur2;
        }
        else
            prev1.next = cur2;
        if(prev2 == null)
           head = cur1;
        else 
           prev2.next = cur1;       
           
        if(cur1.next == cur2)
        {
            ListNode temp = cur2.next;
            cur1.next = temp;
            cur2.next = cur1;
        
        }
        else
        {
        ListNode temp = cur1.next;
        //prev2.next = cur1;
        cur1.next = cur2.next;
        cur2.next = temp;
        }
        return head;




    }
}
