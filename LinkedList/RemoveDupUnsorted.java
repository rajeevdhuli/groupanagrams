


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

class Solution {
  public:
    Node *removeDuplicates(Node *head) {
        // your code goes here
if (head == nullptr) {
            return nullptr;
        }

        std::unordered_set<int> seen; // Set to track seen values
        Node* cur = head;
        Node* prev = nullptr;

        while (cur != nullptr) {
            if (seen.find(cur->data) != seen.end()) {
                // If the value has already been seen, skip the current node
                prev->next = cur->next;
                delete cur; // Clean up the skipped node
            } else {
                // If it's the first occurrence, add it to the set and move prev forward
                seen.insert(cur->data);
                prev = cur;
            }
            cur = cur->next;
        }

        return head;
    }
};
