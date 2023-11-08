//User function Template for Java
class Solution
{
    public static Node modifyTheList(Node head)
    {
        /* 10 - 4 - 5 - 3 - 6
           split and reverse second -> 10 - 4 - 5
                                       6  - 3
        then perfrom calculations ->  (-4) - (-1) - 5
                                        10 - 4
        reverse second part and attach it  -4 -> -1 -> 5 -> 4 -> 10  */                          
        Node cur = head;
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow.next;
        slow.next = null;
        mid = reverse(mid);
        Node midHead = mid;
        while(mid != null){
            int temp = mid.data;
            mid.data = cur.data;
            cur.data = temp - cur.data;
            mid = mid.next;
            cur = cur.next;
        }
        midHead = reverse(midHead);
        slow.next = midHead;
        return head;
        
        
    }
    public static Node reverse(Node head){
        Node cur = head;
        Node prev = null;
        while(cur != null){
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
