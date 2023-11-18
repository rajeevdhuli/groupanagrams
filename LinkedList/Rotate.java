class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if(head == NULL||head->next == NULL||k == 0) return head;
    //calculating length
    ListNode* temp = head;
    int length = 1;
    while(temp->next != NULL) {
        ++length;
        temp = temp->next;
    }
    //link last node to first node
    temp->next = head;
    k = k%length; //when k is more than length of list
    int end = length-k; //to get end of the list
    while(end != 0) {temp = temp->next;end--;}
    //breaking last node link and pointing to NULL
    head = temp->next;
    temp->next = NULL;
        
    return head;
    }
};






JAVA 


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        ListNode cur = head;
        ListNode prev = null;
        int len = 0;
        while(cur != null){
            prev = cur;
            cur = cur.next;
            len++;
        }
        prev.next = head;
        k = k % len;
        cur = head;
        int i = 0;
        prev = null;
        while(i < (len - k)){
            i++;
            prev = cur;
            cur = cur.next;
        }
        head = cur;
        prev.next = null;
        return head; 
    }
}
