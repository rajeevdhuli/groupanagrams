class Solution
{
    static void linkdelete(Node head, int M, int N)
    {
        // your code here
        
        Node cur = head;
        while(cur != null){
            int i = 1;
            while(cur != null && i < M){
                cur = cur.next;
                i++;
            }
            
            if(cur == null)
              break;
              
            Node temp = cur;
            while(temp != null && i < M + N){
                temp = temp.next;
                i++;
            }
            
            if(temp == null){
                cur.next = null;
                break;
            }
            
            cur.next = temp.next;
            cur = cur.next;
        }
    }
}
