JAVA - 

class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
         // Your code here
        Map<Integer,Integer> mp = new HashMap<>();
        Node cur = head;
        while(cur != null){
            mp.put(cur.data,1);
            cur = cur.next;
        }
        cur = head;
        Node prev = null;
        Node right = head;
        while(right != null){
            if(mp.containsKey(right.data)){
                mp.remove(right.data);
                cur.data = right.data;
                prev = cur;
                cur = cur.next;
            }
            right = right.next;
        }
        prev.next = null;
        return head;
    }
}



C++ -

class Solution
{
    public:
    //Function to remove duplicates from unsorted linked list.
    Node * removeDuplicates( Node *head) 
    {
     // your code goes here
     Node* cur= head;
     unordered_map<int,int> mp;
     while(cur!= NULL){
         mp[cur->data] = 1;
         cur = cur->next;
     }
     cur = head;
     Node* right = head;
     Node* prev = NULL;
     while(right != NULL){
         if(mp.count(right->data))
         {
             mp.erase(right->data);
             cur->data = right->data;
             prev = cur;
             cur = cur->next;
         }
         right = right->next;
     }
     prev->next = NULL;
     return head;
     
    }
};
