class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = 0;
            if(l1 != null){
                sum+= l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum+= l2.val;
                l2 = l2.next;
            }
             
            sum+= carry;  
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            res.next = temp;
            res = res.next; 
        }  
        if(carry == 1){
            ListNode temp = new ListNode(carry);
            res.next = temp;
            res = res.next;
        }
        res.next = null;
           
        return ans.next;
    }
}
