
class Solution {
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode head2 = head;
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        int carry = 0;

        while(head != null || head2 != null || carry == 1){
            int sum = 0;

            if(head!=null && head2 != null){

               sum+= head.val + head2.val;
               head = head.next;
               head2= head2.next;

            }
            
            sum = sum + carry;
            carry = sum/10;

            ListNode temp = new ListNode(sum%10);
            res.next = temp;
            res = res.next;
        }

        return reverse(dummy.next);
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



WITHOUT USING EXTRA NODE - 

class Solution {
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode pre = null;
        int carry = 0;
        ListNode res = head;

        while(head != null ){

            int ans = head.val;
            ans*=2;
            ans+= carry;
            carry = ans /10;
            head.val = (ans%10);
            
            pre = head;
            head = head.next;
        }

        if(carry == 1){

            ListNode temp = new ListNode(1);
            pre.next = temp;
            temp.next = null;

        }

        return reverse(res);
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
