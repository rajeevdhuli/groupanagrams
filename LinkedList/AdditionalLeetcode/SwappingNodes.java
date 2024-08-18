//Swapping Values

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = 0;
        ListNode cur = head;
        ListNode left = null;
        //calculate kth from start and length of linked list at same time 
        while(cur != null){
            if(len == k - 1){
                left = cur;
            }
            len++;
            cur = cur.next;
        }
        //calcaulte the kth pointer from end
        cur = head;
        int i = 1;
        while(i < (len - k + 1)){
            cur = cur.next;
            i++;
        }
        ListNode right = cur;
        // Swap the values
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }
}
