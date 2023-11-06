public class Solution
{
    public static int lengthOfLoop(Node head) {
        // Write your code here
        Node slow = head;
        Node fast = head;
        Node entry = head;
        Node temp = null;
        int len = 0;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                while(slow != entry)
                {
                    slow = slow.next;
                    entry = entry.next;
                }
                temp = entry;
                entry = entry.next;
                while(entry != temp )
                {
                    entry = entry.next;
                    len++;
                }
                return (len+1);
            }
        }
        return len;
    }
}
