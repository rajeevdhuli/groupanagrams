class Solution
{
    static Node subLinkedList(Node l1, Node l2)
    {
        // code here
        while(l1 != null && l1.data == 0){
            l1 = l1.next;
        }
        
        while(l2 != null && l2.data == 0){
            l2 = l2.next;
        }
        
        int len1 = length(l1);
        int len2 = length(l2);
        Node l1h = l1;
        Node l2h = l2;
        
        if(len1 == len2){
            while(l1h != null && l2h != null && l1h.data == l2h.data){
                l1h = l1h.next;
                l2h = l2h.next;
            }
            if(l1h != null && l2h != null && l1h.data > l2h.data){
               len2--;
            }
            else if(l1h != null && l2h != null && l1h.data < l2h.data){
                len1--;
            }
            // break;
            
        }
        
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        
        Node dummy = new Node(-1);
        Node res = dummy;

        
        

        while(l1 != null || l2 != null){
            int sub = 0;
            
            if(len1 > len2){
                l1.data = l1.data - carry;
            }else
                l2.data = l2.data - carry;
            
            if(l1 != null && l2 !=  null ){
                
                if(len1 >= len2){
                    sub = l1.data - l2.data;
                }else
                    sub = l2.data - l1.data;
                    
                l1 = l1.next;
                l2 = l2.next;
            }
            
            else if(l1 != null){
                if(l1.data != 0)
                    sub = l1.data;
                 l1 = l1.next;
                
            }
            
            else if (l2 != null){
                if(l2.data != 0)
                    sub = l2.data;
                l2 = l2.next;
                
            }
            
            if(sub < 0){
                sub+= 10;
                carry = 1;
            }
            else
                carry = 0;
                
            Node temp = new Node(sub);
            
 
               res.next = temp;
               res = res.next;
            
        }
        Node ans = reverse(dummy.next);
        Node prev = new Node(-1);
        while(ans != null && ans.next != null){
            if(ans.data != 0)
            {
                prev.next = ans;
                break;
            }
             ans = ans.next ;  
         }
         if(ans.next == null)
            return ans;
         return prev.next;
        
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
    
    static int length(Node head){
        
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
}
