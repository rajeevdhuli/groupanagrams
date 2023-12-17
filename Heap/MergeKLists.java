 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        for(ListNode l : lists){
            if(l != null)
               pq.offer(l);
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while(!pq.isEmpty()){
            tail.next = pq.poll();
            tail = tail.next;
            if(tail.next != null){
                pq.add(tail.next);
            } 
        }
        return dummyHead.next;
    }
}
