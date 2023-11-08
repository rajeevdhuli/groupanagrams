
class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        first = reverse(first);
        second = reverse(second);
        
        Node dummy = new Node(-1);
        Node res = dummy;
        int carry = 0;
        while(first != null || second != null){
            int sum = 0;
            if(first!=null && second != null){
               sum+= first.data + second.data;
               first = first.next;
               second = second.next;
            }
            else if(first != null){
                sum+= first.data;
                first = first.next;
            }
            else{
                sum+= second.data;
                second = second.next;
            }
            
            sum+= carry;
            carry = sum/10;
            
            Node temp = new Node(sum%10);
            res.next = temp;
            res = res.next;
        }
        if(carry == 1){
            Node temp = new Node(1);
            res.next = temp;
            res = res.next;
        }
        Node ans = reverse(dummy.next);
        
        return ans;
    }
    static Node reverse(Node head){
        Node cur = head;
        Node prev = null;
        while(cur != null){
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
