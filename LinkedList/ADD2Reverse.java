class Solution {
    // Function to add two numbers represented by linked lists.
    static Node addTwoLists(Node num1, Node num2) {
        // Reverse both input linked lists to make addition easier.
        // Reversing will allow us to add the numbers starting from the least significant digit.
        Node first = reverse(num1);
        Node second = reverse(num2);
        
        // Create a dummy node to facilitate easier construction of the resulting linked list.
        Node dummy = new Node(-1);
        Node res = dummy; // 'res' is a pointer that will be used to traverse and build the result list.
        
        int carry = 0; // Initialize carry to 0, used to handle the sum that exceeds 9.
        
        // Loop through both lists until both are exhausted and no carry is left.
        while (first != null || second != null || carry != 0) {
            int sum = 0;
            sum += carry; // Add any carry from the previous addition.

            // If the first list is not exhausted, add its value to sum.
            if (first != null) {
                //if (second == null && carry == 0) either works
                if (second == null && sum == 0) {
                    // Optimization: If the second list is exhausted and sum is 0, break the loop early.
                    break;
                }
                sum += first.data;
                first = first.next; // Move to the next node in the first list.
            }

            // If the second list is not exhausted, add its value to sum.
            if (second != null) {
                //if (first == null && carry == 0) either works
                if (first == null && sum == 0) {
                    // Optimization: If the first list is exhausted and sum is 0, break the loop early.
                    break;
                }
                sum += second.data;
                second = second.next; // Move to the next node in the second list.
            }

            // Calculate the new carry.
            carry = sum / 10;

            // Create a new node with the value of (sum % 10) and link it to the result list.
            Node temp = new Node(sum % 10);
            res.next = temp;
            res = res.next; // Move the result pointer forward.
        }

        // The resulting linked list is in reverse order, so reverse it to get the final answer.
        Node ans = reverse(dummy.next);
        
        return ans; // Return the head of the result linked list.
    }

    // Helper function to reverse a linked list.
    static Node reverse(Node head) {
        Node cur = head;  // 'cur' is the current node being processed.
        Node prev = null; // 'prev' will store the previous node in the reversed list.
        
        // Loop until all nodes are processed.
        while (cur != null) {
            Node temp = cur.next; // Temporarily store the next node.
            cur.next = prev; // Reverse the current node's pointer.
            prev = cur; // Move 'prev' to the current node.
            cur = temp; // Move to the next node in the original list.
        }
        return prev; // 'prev' now points to the head of the reversed list.
    }
}



if (second == null && sum == 0) {
     break;
}

this condiiotn is for leading zeros suppose first is  0 - > 0 - > 6 - > 3 and second is 0 - > 7 
so your answer should be  7 - > 0 no 0 - > 0 - > 7 - > 0
so if secnod is null only leading of first left and here we are checking sum == 0 (because we already added carry) then we do not  need to print
Edge case : 0 -> 0 ->  9
                       1
    carry :       1
    ans :   0 -> 1 -> 0
even though the second zero in first is leading but carry adds up 1 hence we are checking (sum == 0 or carry ==  0 )
