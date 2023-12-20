   public static SinglyLinkedListNode RotateLL(SinglyLinkedListNode start, int k) {
    // Write your code here
        int len = 0 ;
        SinglyLinkedListNode cur = start;
        SinglyLinkedListNode prev = null;
        while(cur != null){
            len++;
            prev = cur;
            cur = cur.next;
        }
        k = k % len;
        prev.next = start;
        cur = start;
        prev = null;
        int  i = 0;
        while(i < k){
            i++;
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;
        start = cur;
        return start;
    }
