/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levels = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            return levels;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> llist =  new ArrayList<>();
            int size = queue.size();
            while(size--> 0){
                for(Node child : queue.peek().children){
                    queue.offer(child);
                }
                llist.add(queue.poll().val);
            }
            levels.add(llist);
        }
        return levels;
    }
}
