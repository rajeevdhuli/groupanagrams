class Solution
{
    public static Node addPolynomial(Node p1,Node p2)
    {
        //Add your code here.
        Node dummy = new Node(-1,-1);
        Node ans = dummy;
        
        while(p1 != null && p2 != null){
            
            if(p1.pow == p2.pow){
                Node temp = new Node((p1.coeff+p2.coeff),p1.pow);
                ans.next = temp;
                ans = ans.next;
                p1 = p1.next;
                p2 = p2.next;
            }
            
            else{
                
                if(p1.pow > p2.pow){
                    
                    Node temp = new Node(p1.coeff,p1.pow);
                    ans.next = temp;
                    ans = ans.next;
                    p1= p1.next;
                    
                }
                
                else{
                    
                    Node temp1 = new Node(p2.coeff,p2.pow);
                    ans.next = temp1;
                    ans = ans.next;
                    p2=p2.next;
                   
                    
                }
            }
            
           
        }
        while(p1 != null){
            
            Node temp = new Node(p1.coeff,p1.pow);
            ans.next = temp;
            ans = ans.next;
            p1 = p1.next;
            
        }
        
        while(p2 != null){
            
            Node temp = new Node(p2.coeff,p2.pow);
            ans.next = temp;
            ans = ans.next;
            p2 = p2.next;
            
        }
        
        Node res = dummy.next;
        dummy = null;
        
        return res;
    
    }
}

Without extra space - 
class Solution
{
    public static Node addPolynomial(Node p1,Node p2)
    {
        //Add your code here.
        Node dummy = new Node(-1,-1);
        Node ans = dummy;
        
        while(p1 != null && p2 != null){
            
            if(p1.pow == p2.pow){
                
                p1.coeff = p1.coeff+p2.coeff;
                ans.next = p1;
                ans = ans.next;
                p1 = p1.next;
                p2 = p2.next;
                
            }
            
            else{
                
                if(p1.pow > p2.pow){
                    
                    ans.next = p1;
                    ans = ans.next;
                    p1= p1.next;
                    
                }
                
                else{
                    
                    ans.next = p2;
                    ans = ans.next;
                    p2=p2.next;
                   
                    
                }
            }
            
           
        }
        while(p1 != null){
        
            ans.next = p1;
            ans = ans.next;
            p1 = p1.next;
            
        }
        
        while(p2 != null){

            ans.next = p2;
            ans = ans.next;
            p2 = p2.next;
            
        }
        
        Node res = dummy.next;
        dummy = null;
        
        return res;
    
    }
}
