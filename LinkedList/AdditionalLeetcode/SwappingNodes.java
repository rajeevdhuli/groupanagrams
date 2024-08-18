//Swapping Values

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = 0;
        ListNode cur = head;
        ListNode left = null;
        //calculate kth from start and length of linked list at same time 
        while(cur != null){
            if(len == k - 1){
                left = cur;
            }
            len++;
            cur = cur.next;
        }
        //calcaulte the kth pointer from end
        cur = head;
        int i = 1;
        while(i < (len - k + 1)){
            cur = cur.next;
            i++;
        }
        ListNode right = cur;
        // Swap the values
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }
}


//Swapping Nodes 


class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;  // No need to swap if the list is empty or has only one node
        }

        int len = 0;
        ListNode cur = head;
        
        // Calculate the length of the linked list
        while (cur != null) {
            cur = cur.next;
            len++;
        }

        // Find the k-th node from the beginning
        ListNode cur1 = head;
        ListNode prev1 = null;
        int i = 1;
        while (cur1 != null && i < k) {
            prev1 = cur1;
            cur1 = cur1.next;
            i++;
        }

        // Find the k-th node from the end
        ListNode prev2 = null;
        i = 1;
        ListNode cur2 = head;
        while (cur2 != null && i < (len - k + 1)) {
            prev2 = cur2;
            cur2 = cur2.next;
            i++;
        }

        // Handle the case when swapping the head node
        if (prev1 == null) {
            head = cur2; // k-th node from start becomes new head
        } else {
            prev1.next = cur2; // Connect the node before cur1 to cur2
        }

        if (prev2 == null) {
            head = cur1; // k-th node from end becomes new head
        } else {
            prev2.next = cur1; // Connect the node before cur2 to cur1
        }

        // Swap the next pointers of cur1 and cur2
        ListNode temp = cur1.next; // Save cur1.next
        cur1.next = cur2.next; // Point cur1.next to cur2.next
        cur2.next = temp; // Point cur2.next to cur1.next

        return head; // Return the modified list
    }
}



Let's break down how the code handles the case when the linked list is `[1, 2, 3, 4, 5, 6]` and `k = 3`, which means we want to swap the 3rd node from the start with the 3rd node from the end.

### Steps of the Algorithm

1. **Initial List:**
   - Original List: `1 -> 2 -> 3 -> 4 -> 5 -> 6`

2. **Calculate the Length of the List:**
   - `len = 6`

3. **Find the k-th Node from the Start (`cur1`):**
   - `k = 3`
   - `cur1` is the 3rd node from the start.
   - Traversal:
     - Start at `head` (1), move to 2 (2), move to 3 (3).
   - `cur1` points to node `3`.
   - `prev1` points to node `2` (node before `cur1`).

4. **Find the k-th Node from the End (`cur2`):**
   - `k = 3`
   - From the end: `len - k + 1 = 4` (4th node from the start)
   - `cur2` is the 4th node from the start.
   - Traversal:
     - Start at `head` (1), move to 2 (2), move to 3 (3), move to 4 (4).
   - `cur2` points to node `4`.
   - `prev2` points to node `3` (node before `cur2`).

5. **Swapping Nodes:**
   - Before swapping:
     - `cur1` points to `3`, and `cur2` points to `4`.
     - `prev1` points to `2`, and `prev2` points to `3`.
   - Update the next pointers:
     - Set `prev1.next` to `cur2` (2 now points to 4).
     - Set `prev2.next` to `cur1` (3 now points to 3).
     - Swap `cur1.next` and `cur2.next`:
       - `cur1.next` (originally pointing to 4) now points to `cur2.next` (5).
       - `cur2.next` (originally pointing to 5) now points to `cur1.next` (4).

6. **Resulting List After Swapping:**
   - `1 -> 2 -> 4 -> 3 -> 5 -> 6`

### Detailed Steps of Swapping

1. **Before Swap:**
   - List: `1 -> 2 -> 3 -> 4 -> 5 -> 6`
   - `cur1` points to `3`, `cur2` points to `4`
   - `prev1` points to `2`, `prev2` points to `3`

2. **Update Pointers:**
   - `prev1.next` (which was `2 -> 3`) is updated to point to `cur2` (which is `4`):
     - Now `2 -> 4`.
   - `prev2.next` (which was `3 -> 4`) is updated to point to `cur1` (which is `3`):
     - Now `3 -> 3` (not changed).
   - Swap `cur1.next` and `cur2.next`:
     - `cur1.next` (originally `4 -> 5`) is set to `cur2.next` (which is `5`):
       - `3 -> 5`.
     - `cur2.next` (originally `5 -> 6`) is set to `cur1.next` (which is `4`):
       - `4 -> 3`.

3. **Final Swapped List:**
   - `1 -> 2 -> 4 -> 3 -> 5 -> 6`

### Summary
- **Swapped Nodes:** `3` and `4` are swapped with each other.
- **Adjacency:** Since nodes `3` and `4` are not adjacent, the code correctly updates their pointers without affecting the overall structure of the list.

The code correctly handles swapping nodes that are not adjacent by updating the previous nodes’ pointers and swapping the `next` pointers of the nodes to be swapped.
