O(2N), O(N)-
    
Class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode cur = head;
        while(cur != null)
        {
            st.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while(cur != null)
        {
            if(st.pop() != cur.val)
                return false;
            cur = cur.next;    
        }
        return true;

    }
}


O(N) , O(N) -

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        ListNode left = head;
        ListNode right = prev;
        while(left != null && right != null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
