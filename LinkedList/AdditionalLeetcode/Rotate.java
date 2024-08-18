Brute force O(n) , O(1) -----

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Edge case: if the list is empty, has one element, or no rotation is needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Calculate the length of the linked list
        int len = length(head);

        // Step 2: Calculate the effective number of rotations needed
        // If k is greater than the length of the list, reduce k using modulo
        int rot = (len > k) ? k : (k % len);

        // If the effective rotation is 0, return the original list
        if (rot == 0) {
            return head;
        }

        // Step 3: Find the (len - rot)-th node, which will be the new tail
        int i = 1; 
        ListNode prev1 = null; // Will hold the node before the new head
        ListNode cur = head;
        while (cur != null && i < (len - rot + 1)) {
            prev1 = cur;
            cur = cur.next;
            i++;
        }

        // Step 4: Break the list at the new tail and set the new head
        prev1.next = null; // Terminate the current list
        ListNode newHead = cur; // The (len - rot + 1)-th node becomes the new head

        // Step 5: Find the last node of the new list and connect it to the original head
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head; // Connect the last node of the rotated part to the original head

        // Step 6: Return the new head
        return newHead;
    }

    // Helper method to calculate the length of the linked list
    public int length(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}





Optimal Approach - making use of circular array - 

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // If the list is empty, has only one node, or no rotation is needed, return the head as is.
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Calculate the length of the linked list and get the last node.
        int len = 0;
        ListNode cur = head;
        ListNode last = null;
        while (cur != null) {
            len++;
            last = cur; // 'last' will point to the last node after the loop.
            cur = cur.next;
        }

        // Step 2: Connect the last node to the head, making the list circular.
        last.next = head;

        // Step 3: Calculate the actual number of rotations needed.
        k = k % len; // If k >= len, rotating len times would bring the list back to the original position.
        int rotations = len - k; // Number of nodes to traverse to find the new head.

        // Step 4: Traverse to the node before the new head.
        cur = head;
        ListNode prev = null;
        while (rotations > 0) {
            prev = cur;
            cur = cur.next;
            rotations--;
        }

        // Step 5: Break the circular list to form the new list.
        prev.next = null; // The new end of the list should point to null.
        
        // Step 6: Return the new head of the rotated list.
        return cur;
    }
}

