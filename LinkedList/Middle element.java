class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head; ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
        // int n = 0;
    	// ListNode temp = head;
    	// while(temp != null) {
        // 	n++;
        // 		temp = temp.next;
    	// }
    	// temp = head;
   	 
    	// for(int i = 0; i < n / 2; i++) 
        // 		temp = temp.next;
    	// return temp;
    }
}
