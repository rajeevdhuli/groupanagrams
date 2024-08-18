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
        ListNode right = prev;
        ListNode left = head;
        System.out.println(left.val+" "+right.val);
        while(left != null && right != null){
            ListNode temp1 = left.next;
            ListNode temp2 = right.next;

            left.next = right;
            right.next = temp1;

            left = temp1;
            right = temp2;
        }
        if(left != null){
            left.next = null;
        }
    }
}
