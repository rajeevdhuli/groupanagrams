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
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Calculate the total length of the linked list
        int len = length(head);

        // Create an array of size k to store the head of each split part
        ListNode[] ans = new ListNode[k];

        // Determine the base size of each part
        int size = (len < k) ? 1 : (len / k);

        // Determine the number of parts that will have an extra node
        int width = (len < k) ? 0 : len % k;

        ListNode cur = head;
        ListNode prev = null;

        // Iterate over the number of parts
        for (int i = 0; i < k; i++) {
            ListNode newHead = cur;  // The head of the current part
            int j = 0;

            // Calculate the current size of the part (base size + 1 if extra width remains)
            int add = (width <= 0) ? 0 : 1;
            
            while (j < (size + add) && cur != null) {
                prev = cur;
                cur = cur.next;
                j++;
            }

            // Reduce the extra width after assigning an additional node
            width--;

            // Break the link to the next part if it's not the end of the list
            if (prev != null)
                prev.next = null;

            // Store the current part's head in the result array
            ans[i] = newHead;
        }

        return ans;
    }

    // Helper function to calculate the length of the linked list
    public int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
