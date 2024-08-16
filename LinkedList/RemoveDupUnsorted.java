


C++ -

class Solution {
  public:
    Node *removeDuplicates(Node *head) {
        // your code goes here
        Node* cur= head;
     unordered_map<int,int> mp;
     while(cur!= nullptr){
         mp[cur->data]++;
         cur = cur->next;
     }
     Node dummy(-1);
     Node* pre = &dummy;
     while(head != nullptr){
         if(mp.count(head->data) > 0 && mp[head->data] > 1){
             //keep first one and delete
             pre->next = head;
             pre = pre->next;
             mp.erase(head->data);
         }else if(mp.count(head->data) == 1){
             //keep ones whihc are occurin one time
             pre->next = head;
             pre = pre->next;
         }
         head = head->next; 
     }
     pre->next = nullptr;
     return dummy.next;
    }
};




shorter - optimized

public Node removeDuplicates(Node head) {
        if (head == null) {
            return null;
        }

        Set<Integer> seen = new HashSet<>();
        Node cur = head;
        Node prev = null;

        while (cur != null) {
            if (seen.contains(cur.data)) {
                // If the value has already been seen, skip the current node
                prev.next = cur.next;
            } else {
                // If it's the first occurrence, add it to the set and move prev forward
                seen.add(cur.data);
                prev = cur;
            }
            cur = cur.next;
        }

        return head;
    }
