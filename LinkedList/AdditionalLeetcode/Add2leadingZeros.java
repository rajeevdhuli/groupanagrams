class Solution {
    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2) {
        // Reverse the input lists
        Node first = reverse(num1);
        Node second = reverse(num2);
        
        Node dummy = new Node(-1); // Dummy node to help with the result construction
        Node res = dummy;
        int carry = 0;
        
        // Traverse both lists and the carry
        while (first != null || second != null || carry != 0) {
            int sum = carry;
            
            if (first != null) {
                sum += first.data;
                first = first.next;
            }
            
            if (second != null) {
                sum += second.data;
                second = second.next;
            }
            
            carry = sum / 10;
            res.next = new Node(sum % 10); // Create a new node with the digit value
            res = res.next;
        }
        
        // Reverse the result list to restore the correct order
        Node ans = reverse(dummy.next);
        
        // Remove leading zeros from the result
        while (ans != null && ans.data == 0) {
            ans = ans.next;
        }
        
        // If the list is empty after removing zeros, return a single node with value 0
        return ans == null ? new Node(0) : ans;
    }
    
    // Function to reverse a linked list
    static Node reverse(Node head) {
        Node cur = head;
        Node prev = null;
        
        while (cur != null) {
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        return prev;
    }
}
