/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head.next;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        ListNode left = head;
        ListNode prev = null;
        ListNode temp = right;
        slow.next = null;
        while(temp != null)
        {
            ListNode nex = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nex;
        }
        right = prev;
        while(right != null && left != null)
        {
            ListNode i = left.next;
            ListNode j = right.next;
            left.next = right;
            right.next = i;
            right = j;
            left = i;
        }
    }
}
