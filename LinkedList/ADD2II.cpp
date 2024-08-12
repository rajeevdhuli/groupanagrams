class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
    
        ListNode* dummy = new ListNode(-1);
        ListNode* res = dummy;

        while(l1 != NULL || l2 != NULL || carry == 1){
            int sum = 0;

            if(l1 != NULL && l2 != NULL){
                sum+= l1->val + l2->val;
                l1 = l1->next;
                l2 = l2->next;
            }

            else if(l1 != NULL){
                sum+= l1->val;
                l1 = l1->next;
            }

            else if( l2 != NULL){
                sum+= l2->val;
                l2 = l2->next;
            }
             
            sum+= carry; 
            carry = sum / 10; 
            ListNode* temp = new ListNode(sum%10);
            res->next = temp ;
            res = res->next;
        }  
        res->next = NULL;
        ListNode* ans = dummy->next;
        delete dummy;

        return reverse(ans);
    }

    public:
    ListNode* reverse(ListNode* head){

        ListNode* cur = head;
        ListNode* prev = NULL;

        while(cur != NULL){
            ListNode* temp = cur->next;
            cur->next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }
};


Optimized - 

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = reverse(l1);
        ListNode b = reverse(l2);
        ListNode ans = new ListNode(-1);
        ListNode head = ans;
        int carry = 0;
        while(a != null || b != null || carry == 1){
            int sum = 0 ;
            sum+= carry;
            if(a != null){
                sum+= a.val;
                a = a.next;
            }
            if(b != null){
                sum+= b.val;
                b = b.next;
            }
            // carry cannot be more than1 beacuse max case 9+9+1 = 19
            carry = (sum < 10) ? 0 : 1;
            sum = (sum < 10) ? sum : (sum % 10);
            ListNode temp = new ListNode(sum);
            head.next = temp;
            head = head.next;
        }
        return reverse(ans.next);
        
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}




Differnt Approach 
Instead of reversing use a Stack - 

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Pointers for traversing the input lists
        ListNode a = l1;
        ListNode b = l2;
        
        // Stacks to store the digits of each number in reverse order
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        // Push all digits of the first number onto the stack
        while (a != null) {
            st1.push(a.val);
            a = a.next;
        }
        
        // Push all digits of the second number onto the stack
        while (b != null) {
            st2.push(b.val);
            b = b.next;
        }
        
        // Dummy node to start the resulting linked list
        ListNode ans = new ListNode(-1);
        ListNode head = ans;
        
        // Variable to keep track of the carry
        int carry = 0;
        
        // Loop until both stacks are empty and there's no carry left
        while ((!st1.isEmpty()) || (!st2.isEmpty()) || carry == 1) {
            int sum = 0;
            
            // Add the carry from the previous step
            sum += carry;
            
            // Add the top of the first stack if it's not empty
            if (!st1.isEmpty()) {
                sum += st1.pop();
            }
            
            // Add the top of the second stack if it's not empty
            if (!st2.isEmpty()) {
                sum += st2.pop();
            }
            
            // Determine the new carry
            carry = (sum < 10) ? 0 : 1;
            
            // Get the digit to store in the current node
            sum = (sum < 10) ? sum : (sum % 10);
            
            // Store the digit in the current node
            head.val = sum;
            
            // Move the head pointer and create a new node at the front
            ListNode temp = new ListNode(0);
            temp.next = head;
            head = temp;
        }
        
        // Return the resulting linked list, skipping the dummy node
        return head.next;
    }
}


            head.val = sum;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            head = dummy;


you are changing the value of head(calcuate sum of last digit) and then insert at end of linked list, by creating a dummy.
example - sum for last digit is 7,next digit is 4
so first inset 7 in head, then dummy of -1 . -1 .next will be 7.Then move head to dummy, so for next digit you change -1 to 4. for next digit insert 4. -1 - > 4 - > 7
you do not need to reverse the linked list.
you add the value and then basically you ar moving behind.
Then return head.next as you will have -1 at start additionally.
