class Solution
{
    public:
    //Function to remove a loop in the linked list.
    void removeLoop(Node* head)
    {
        // code here
        // just remove the loop without losing any nodes
        Node* slow = head;
        Node* fast = head;
        Node* entry = head;
        bool hasloop = false;
        while(fast != nullptr && fast->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;
            if(fast == slow){
                hasloop = true;
                break;
            }
        }
        if(hasloop == true){
            if(slow != entry){
                while(slow->next != entry->next){
                    slow = slow->next;
                    entry = entry->next;
                }
                slow->next = nullptr;
            }
            else{
                while(slow->next != entry){
                    slow = slow->next;
                }
                slow->next = nullptr;
            }
        }
    }
};



JAVA--



class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        if(head == null||head.next == null) 
            return ;
        Node slow = head;
        Node fast= head;
        Node entry = head;
        boolean hasloop = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                hasloop = true;
                break;
            }
        }
         if (hasloop == true) {
            if(slow != entry){
              while(slow.next != entry.next) {
                   slow = slow.next;
                   entry = entry.next;
                }
                slow.next = null;
            }
            else{
                while(slow.next != entry)
                    slow = slow.next;
                slow.next = null;  
            }
        }
    }
}
