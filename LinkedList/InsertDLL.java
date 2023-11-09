
public class Solution
{
    public static Node insertAtTail(Node list, int K) {
        // Write your code here
        Node cur = list;
        Node new_node = new Node(K);
        if(cur == null){
            cur = new_node;
            return cur;
        }
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = new_node;
        new_node.prev = cur;
        return list;
    }
}
