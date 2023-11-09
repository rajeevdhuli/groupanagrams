lass Solution {
    public int pairSum(ListNode head) {

        ListNode slow = head ;
        ListNode fast = head.next;
        int maxSum = Integer.MIN_VALUE;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode cur = second;
        ListNode prev = null;

        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        second = prev;
        ListNode first = head;

        while(first != null && second != null){
            int sum = first.val + second.val;
            maxSum = Math.max(sum,maxSum);
            first = first.next;
            second = second.next;
        }

        return maxSum;
    }
}
