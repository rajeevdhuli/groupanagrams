class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int width = len / k;
        int rem = len % k ;
        System.out.println(width+ " "+rem);
        ListNode[] ans = new ListNode[k];
        cur = head;
        ListNode prev = null;
        for(int   j  = 0 ; j < k ; j++){
            ListNode temp = cur;
            for(int i  = 0;  i < width + (( j < rem )? 1 : 0); i++)
            {
                if(cur != null){
                   prev = cur;
                   cur = cur.next;
                }
            }
            if(prev != null){
               prev.next = null;
               ans[j] = temp;
               prev  = null;
            }
        }
        return ans;   
    }
}
