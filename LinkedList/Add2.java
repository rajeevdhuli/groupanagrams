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



Optimized - 

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode head = ans;
        int carry = 0;
        while(l1 != null || l2 != null || carry == 1){
            int sum = 0 ;
            sum+= carry;
            if(l1 != null){
                sum+= l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum+= l2.val;
                l2 = l2.next;
            }
            // carry cannot be more than1 beacuse max case 9+9+1 = 19
            carry = (sum < 10) ? 0 : 1;
            sum = (sum < 10) ? sum : (sum % 10);
            ListNode temp = new ListNode(sum);
            head.next = temp;
            head = head.next;
        }
        return ans.next;
    }
}
