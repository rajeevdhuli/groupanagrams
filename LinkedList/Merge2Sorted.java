/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1 ,ListNode l2) 
    {
        if(l1 == null && l2 == null)
            return null;
        else if(l1 == null )
            return l2;
        else if(l2 == null)
            return l1;
        ListNode l3 = null;
        ListNode l3_head = null;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                if(l3 != null)
                    l3.next = l1;
                l3 = l1;
                l1 = l1.next;
            }
            else if (l1.val > l2.val)
            {
                if(l3 != null)
                    l3.next = l2;
                l3 = l2;
                l2 = l2.next;    
            }
            if(l3_head == null)
               l3_head = l3;
        }
        while(l1 != null)
        {
            l3.next = l1;
            l3 = l1;
            l1 = l1.next;
        }
        while(l2 != null)
        {
            l3.next = l2;
            l3 = l2;
            l2 = l2.next;
        }
        return l3_head;
                   
    }
}
