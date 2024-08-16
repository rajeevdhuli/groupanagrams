class GfG
{
    public static Node sortedInsert(Node head, int x)
    {
        // add your code here
        Node cur = head;
        Node pre = null;
        while(cur != null){
            if(cur.data > x){
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        Node new_node = new Node(x);
        //System.out.println(cur.data +" "+ head.data);
        if(cur == head){
            new_node.next = head;
            new_node.prev = null;
            cur.prev = new_node;
            head = new_node;
        }

         if(cur == null){
            pre.next = new_node;
            new_node.prev = pre;
            new_node.next = null;
        }
        
        else if(cur != null && pre != null){
            pre.next = new_node;
            new_node.prev = pre;
            new_node.next = cur;
            cur.prev = new_node;
        }
        
        return head;
    }
}



optimized - 


public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
    // Write your code here
    DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
    if(llist == null){
        return newNode;
    }
    //insert at beginning
    if(llist.data > newNode.data){
        newNode.next = llist;
        llist.prev = newNode;
        return newNode;
    }
    DoublyLinkedListNode cur = llist;
    //move until u meet a element greater then the element to be inserted
    while(cur.next != null && cur.next.data < data){
        cur = cur.next;
    }
    DoublyLinkedListNode nextNode = cur.next;
    cur.next = newNode;
    newNode.prev= cur;
    //if the nextNode is not null
    if(nextNode != null){
       newNode.next = nextNode;
       nextNode.prev = newNode;
    }else{
        newNode.next = null;
    }
    return llist;
}
