class Solution
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {
	// Your code here
	
	int i = 1;
	Node cur = head;
	Node pre = null;
	
	while(i < x){
	    pre = cur;
	    cur = cur.next;
	    i++;
	}
	
	if(pre == null){
	    Node temp = head.next;
	    temp.prev = null;
	    return temp;
	}
	
	Node temp = cur.next;
	if(temp == null){
	    pre.next = temp;
	    cur.prev = null;
	    return head;
	}
	pre.next = cur.next;
	temp.prev = cur.prev;
	cur.prev = null;
	cur.next = null;
	return head;
    }
}
