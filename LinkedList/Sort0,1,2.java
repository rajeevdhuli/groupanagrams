
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node cur = head;
        int cnt_0 = 0;
        int cnt_1 = 0;
        int cnt_2 = 0;
        while(cur != null){
            if(cur.data == 0)
               cnt_0++;
            else if(cur.data == 1)
                cnt_1++;
            else
               cnt_2++;
            cur = cur.next ;   
        }
        cur = head;
        while(cnt_0 > 0){
            cur.data = 0;
            cur = cur.next;
            cnt_0--;
        }
         while(cnt_1 > 0){
            cur.data = 1;
            cur = cur.next;
            cnt_1--;
        }
         while(cnt_2 > 0){
            cur.data = 2;
            cur = cur.next;
            cnt_2--;
        }
        return head;
    }
}


