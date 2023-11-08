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
