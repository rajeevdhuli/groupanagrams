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
