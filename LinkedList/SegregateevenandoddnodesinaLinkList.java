class Solution{
    Node divide(int N, Node head){
        // code here
        Node cur = head;
        Node evenHead = new Node(-1);
        Node oddHead = new Node(-1);
        Node i = evenHead;
        Node j = oddHead;
        while(cur != null){
            if(cur.data%2 == 0){
                i.next = cur;
                i = i.next;
            }
            else if(cur.data % 2 != 0){
                j.next = cur;
                j = j.next;
            } 
            cur = cur.next;
        }
        i.next = oddHead.next;
        j.next = null;
        Node ans = evenHead.next;
        evenHead = null;
        oddHead = null;
        return ans;
    }
}
