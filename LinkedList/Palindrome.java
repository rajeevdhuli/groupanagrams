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
        ListNode cur = head;
        ListNode slow = cur;
        ListNode fast = cur;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow;
        ListNode prev = null;
        ListNode temp = right;
        while(temp != null)
        {
            ListNode nex = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nex;
        }
        ListNode left = head;
        while(prev != null)
        {
            if(prev.val != left.val)
               return false;
            prev = prev.next;
            left = left.next;

        }
        return true;
    }
}    
    
