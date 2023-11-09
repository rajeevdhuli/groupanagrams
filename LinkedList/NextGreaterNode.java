class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<Integer>();

        ListNode tmp = head;
        int size = 0;

        while(tmp != null) {
            size++;
            list.add(tmp.val);
            tmp = tmp.next;
        }

        int ans[] = new int[size];

        for(int i = size - 1; i>= 0; i--){

            while(!st.isEmpty() && st.peek() <= list.get(i)  )
                 st.pop();

            ans[i] = (st.isEmpty()) ? (0):(st.peek());

            st.push(list.get(i));
        }

        return ans;
    }
}



C++



class Solution {
public:
    vector<int> nextLargerNodes(ListNode* head) {

        vector<int> list;
        stack<int> st;
        ListNode* cur = head;
        int size = 0;
        while(cur != NULL){
            size++;
            list.push_back(cur->val);
            cur = cur->next;
        }
        vector<int> v (size,0);
        for(int i = size - 1; i >= 0; i--){
            while(!st.empty() && st.top() <= list[i])
                st.pop();
            int p = (st.empty())?(0):(st.top());
            v[i] = p;
            st.push(list[i]);
        }
        return v;
    }
};
