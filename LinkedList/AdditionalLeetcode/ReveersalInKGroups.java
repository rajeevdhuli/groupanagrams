O(N) , O(1)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Edge case: if the list is empty, has fewer elements than k, or k is 0, return the original list
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int len = length(head);
        // If k is greater than the length of the list, no need to reverse any group, return the original list
        if(k > len){
            return head;
        }
        //calculate the amount reversals you require
        int no = (len/k);
        //the amount of nodes do not require reversing
        int rem = (len % k);
        ListNode cur = head;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        //iterate for each reversal
        for(int i  = 0 ; i < no; i++){
            ListNode presentHead = cur;
            ListNode prev = null;
            //Process each k group
            for(int j = 0; j < k ; j++){
                prev = cur;
                cur = cur.next;
            }
            //set the end of k group to null and reverse
            prev.next = null;
            //store in dummy pointer
            temp.next = reverse(presentHead);
            //interate until end of temp
            while(temp.next != null){
                temp = temp.next;
            }
        }
        //add the additonal left out nodes which do not require reversing
        while(cur != null ){
            temp.next = cur;
            temp = temp.next;
            cur = cur.next;
        }
        // terminate the list
        if(temp != null)
            temp.next = null;   
        return dummy.next;
    }
    //helper function to reverse
    public ListNode reverse(ListNode cur){
        ListNode prev = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
    //helper function to find length
    public int length(ListNode head){
        int len = 0 ;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
}
