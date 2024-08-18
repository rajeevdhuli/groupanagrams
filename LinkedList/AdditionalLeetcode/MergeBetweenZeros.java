class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode cur = head.next;
        ListNode presHead = new ListNode(-1);
        ListNode ref = presHead; 
        while(cur != null){
            int sum = 0;
            while(cur.next != null && cur.next.val != 0){
                sum = sum + cur.val;
                cur = cur.next;
            }
            if(cur.next != null && cur.next.val == 0){
                cur.val = cur.val + sum;
                presHead.next = cur;
                presHead = presHead.next;
            }    
            cur = cur.next.next;
        }
        presHead.next = null;
        return ref.next;
    }
}



additional approach - 

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);  // Dummy node for the result list
        ListNode cur = dummy;  // Pointer to build the new list
        ListNode original = head.next;  // Skip the initial zero in the input list
        
        int sum = 0;  // To accumulate the sum of values between zeros
        
        while (original != null) {
            if (original.val == 0) {
                cur.next = new ListNode(sum);  // Add the sum to the new list
                cur = cur.next;  // Move the pointer forward
                sum = 0;  // Reset the sum for the next segment
            } else {
                sum += original.val;  // Accumulate the sum
            }
            original = original.next;  // Move to the next node
        }
        
        return dummy.next;  // Return the head of the new list
    }
}
