O(N*M), O(1) - 

public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) 
    {
        while(head1 != null){
            ListNode temp = head2;
            while(temp  != null){
                if(head1 == temp )
                   return temp ;
                temp  = temp .next;   
            }
            head1= head1.next;
        }
        return null;
    }
}


O(N+M), O(N) - 

public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) 
    {
        Set<ListNode> st = new HashSet<>();
        while(head1 != null){
            st.add(head1);
            head1 = head1.next;
        }
        while(head2 != null){
            if(st.contains(head2))
                return head2;
            head2 = head2.next;    
        }
        return null;
    }
}


O(N+M+ABS(M-N)+N), O(1) - 

public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) 
    {
        int len1 = lengt(head1);
        int len2 = lengt(head2);
        if(len2 > len1){
            while(len2 != len1){
                head2 = head2.next;
                len2--;
            }
        }
        else if(len1 > len2){
            while(len2 != len1){
                head1 = head1.next;
                len1--;
            }
        }
        while(head1 != null){
            if(head1 == head2)
               return head1;
            head1 = head1.next;
            head2 = head2.next;   
        }
        return null;
    }

    public static int lengt(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
}



O(2*MAXLENGTH(N,M)),O(1) -

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}
O
