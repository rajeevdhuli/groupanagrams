SLOW AND FAST - 
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast != null){
            while(fast.next != null && fast.val == fast.next.val)
                fast = fast.next;
            if(slow.next == fast)
                slow = slow.next;
            else
               slow.next = fast.next;

            fast = fast.next;    
        }
        return dummy.next;
    }
}


JAVA TREEMAP -

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        ListNode cur = head;
        while(cur != null){
            mp.put(cur.val, mp.getOrDefault(cur.val,0)+1);
            cur = cur.next;
        }
        ListNode ans = new ListNode(-1);
        ListNode res = ans;
        for(int i : mp.keySet())
        {
            if(mp.get(i) == 1)
            {
                ListNode temp = new ListNode(i);
                res.next = temp;
                res = res.next;
            }
        }
        ListNode fin = ans.next;
        ans = null;
        return fin;
    }
}


C++ ORDERED MAP -

 /**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(head== NULL)
            return NULL;
        map<int,int> mp;
        ListNode* cur = head;
        while(cur != NULL){
            mp[cur->val]++;
            cur = cur->next;
        }
        ListNode* ans = new ListNode(-1);
        ListNode* res = ans;
        for(auto i : mp)
        {
            if(i.second == 1)
            {
                ListNode* temp = new ListNode(i.first);
                res->next = temp;
                res = res->next;
            }
        }
        ListNode* fin = ans->next;
        delete ans;
        return fin;
    }
};   




SHORTER HASHMAP --


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        Map<Integer,Integer> mp = new HashMap<>();
        ListNode cur = head;
        while(cur != null){
            mp.put(cur.val, mp.getOrDefault(cur.val,0)+1);
            cur = cur.next;
        }
        ListNode prev = null;
        ListNode right = head;
        cur = head;
        while(right != null){
            if(mp.get(right.val)==1){
                cur.val = right.val;
                prev = cur;
                cur = cur.next;
            }
            right = right.next;
        }
        if(prev != null)
           prev.next = null;
        else
            head = prev;   
        return head;
    }
}    
    
