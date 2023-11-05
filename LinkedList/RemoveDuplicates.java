public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
    // Write your code here
    SinglyLinkedListNode cur = llist;
    while(cur.next !=null)
    {
        SinglyLinkedListNode temp = cur.next;
        if(temp.data == cur.data)
        {
            cur.next = temp.next;
        }
        else 
           cur = cur.next;
    }
    return llist;
    }

}
