//Optimized with commnets for understanding
public static Node reverseDLL(Node head) {
    // Handle edge case: If the list is empty or has only one node, return the head as it is
    if (head == null || head.next == null) {
        return head;
    }
    
    // Initialize pointers
    Node pre = null; // This will eventually become the new head of the reversed list
    
    // Traverse the list and reverse the pointers
    while (head != null) {
        // Save the next node (the node after the current node)
        Node temp = head.next;
        
        // Reverse the current node's pointers
        head.next = head.prev; // Set the current node's next to its previous node
        head.prev = temp; // Set the current node's previous to the saved next node
        
        // Move the 'pre' pointer to the current node
        pre = head;
        
        // Move to the next node in the original list
        head = temp;
    }
    
    // After the loop, 'pre' points to the new head of the reversed list
    return pre;
}





public class Solution
{
    public static Node reverseDLL(Node head)
    {
        // Write your code here.
        if(head == null || head.next == null)
            return head;
            
        Node cur = head;
        Node pre = null;

        while(cur != null){
           Node temp = cur.next;
           cur.next = cur.prev;
           cur.prev = temp;
           pre = cur;
           cur = cur.prev;
        }
        return pre;
    }
}



/*
    Time Complexity: O(N)
    Space Complexity: O(1),

    Where N is the number of nodes in the doubly linked list
*/

public class Solution
{

    public static Node reverseDLL(Node head)
    {
        if(head.next == null)
        {
            return head;
        }

        Node curr = head;
        Node temp = null;

        // Traverse the linked list to the end
        while (curr != null)
        {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        head = temp.prev;

        // New head of the modified list is returned
        return head;
    }

}
