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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        int i = 0;
        while(cur1 != null && i < b + 1){
            cur1 = cur1.next;
            i++;
        }
        ListNode tail = cur1;
        cur1 = list1;
        i = 0;
        while( i < a - 1){
            cur1 = cur1.next;
            i++;
        }
        cur1.next = cur2;
        cur1 = cur1.next;
        while( cur1.next != null){
            cur1 = cur1.next;
        }
        cur1.next = tail;
        return list1;
    }
}
