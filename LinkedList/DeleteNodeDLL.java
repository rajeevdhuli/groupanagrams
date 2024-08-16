public class Solution {
    public Node deleteNode(Node head, int x) {
        // Edge case: if the list is empty
        if (head == null) {
            return null;
        }

        // Case 1: Deleting the head node
        if (x == 1) {
            Node newHead = head.next; // New head is the next node
            if (newHead != null) {
                newHead.prev = null; // Update the new head's prev pointer
            }
            // Clean up the old head
            head.next = null;
            head.prev = null;
            return newHead; // Return the new head of the list
        }

        // Case 2: Traverse to the node before the one we want to delete
        Node current = head;
        int i = 1;
        while (i < x - 1 && current != null) {
            current = current.next;
            i++;
        }

        // If the node to be deleted is beyond the end of the list
        if (current == null || current.next == null) {
            return head;
        }

        // Node to be deleted
        Node nodeToDelete = current.next;
        Node nextNode = nodeToDelete.next;

        // Update links to skip over the node to be deleted
        current.next = nextNode;
        if (nextNode != null) {
            nextNode.prev = current;
        }

        // Clean up the deleted node
        nodeToDelete.next = null;
        nodeToDelete.prev = null;

        return head;
    }
}
