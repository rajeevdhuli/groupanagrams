class GfG
{
    //Function to insert a new node at given position in doubly linked list.
    void addNode(Node head_ref, int pos, int data)
	{
		// Your code here
		
		int i = 1;
		Node new_node = new Node(data);
		Node cur = head_ref;
		while(i < pos+1 && cur != null){
		    cur = cur.next;
		    i++;
		}
		Node temp = cur.next;
		
		if(temp == null){
		    cur.next = new_node;
		    new_node.prev = cur;
		}
		else{
		new_node.next = cur.next;
		cur.next = new_node;
		new_node.prev = cur;
		temp.prev =new_node;
		}


		//return head;
	}
}
