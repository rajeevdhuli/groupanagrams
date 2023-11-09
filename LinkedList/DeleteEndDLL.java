public class Solution
{
    public static Node deleteLastNode(Node head) {
        // Write your code here
        Node cur = head;
        if(cur == null ||cur.next == null)
            return null;
        Node pre = null;
        while(cur.next != null){
            pre = cur;
            cur = cur.next;
        }    
        pre.next = null;
        cur.prev = null;
        return head;

    }
}
