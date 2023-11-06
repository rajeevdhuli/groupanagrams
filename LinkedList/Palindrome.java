lass Solution {
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
