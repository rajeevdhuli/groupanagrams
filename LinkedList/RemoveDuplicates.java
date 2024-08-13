O(N) , O(N) --
class Solution {
    public ListNode deleteDuplicates(ListNode llist) {
     Set<Integer> set = new HashSet<>();
    ListNode dummy = new ListNode(-1);
    ListNode head = dummy;
    while(llist != null){
        if(set.contains(llist.val)){
            llist = llist.next;
        }else{
        set.add(llist.val);
        head.next = llist;
        llist = llist.next;
        head = head.next;
        }
    }
    head.next = null;
    return dummy.next;
    }
}

O(N),O(1)---
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // Skip the duplicate node
            } else {
                current = current.next; // Move to the next distinct node
            }
        }

        return head;
    }
}
