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
