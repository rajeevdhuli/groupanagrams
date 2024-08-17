class Solution {
    public int pairSum(ListNode head) {
        // Initialize slow and fast pointers to find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        
        // Move slow by 1 step and fast by 2 steps until fast reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half of the list starting from the slow pointer
        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;  // Temporarily store the next node
            slow.next = prev;           // Reverse the current node's link
            prev = slow;                // Move prev to the current node
            slow = temp;                // Move to the next node in the original list
        }
        
        // prev now points to the head of the reversed second half
        ListNode first = head;  // Pointer to the start of the first half
        ListNode second = prev; // Pointer to the start of the reversed second half
        
        int maxSum = Integer.MIN_VALUE; // Initialize the maximum sum to the smallest integer value
        
        // Traverse both halves and calculate the maximum sum of pairs
        while (first != null && second != null) {
            int sum = first.val + second.val; // Calculate the sum of the current pair
            maxSum = Math.max(maxSum, sum);   // Update maxSum if the current sum is greater
            first = first.next;               // Move to the next node in the first half
            second = second.next;             // Move to the next node in the second half
        }
        
        return maxSum; // Return the maximum sum of the pairs
    }
}
