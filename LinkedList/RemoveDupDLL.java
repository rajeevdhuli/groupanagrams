class Solution{
    Node removeDuplicates(Node head){
        // Code Here.
        if(head == null || head.next == null){
            return head;
        }
        Node fast = head;
        Node dummy = new Node(-1);
        Node slow = dummy;
        while(fast != null){
            while(fast.next != null && fast.data == fast.next.data){
                fast = fast.next;
            }
            slow.next = fast;
            fast.prev = slow;
            slow = slow.next;
            fast= fast.next;
            
        }
        Node newHead = dummy.next;
        newHead.prev = null;
        dummy.next = null;
        return newHead;
    }
}
