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
    public List<Integer> preorder(Node root) {
        List<Integer> preOrder = new ArrayList<>();
        helper(preOrder,root);
        return preOrder;
    }
    public void helper(List<Integer> preOrder, Node root){
        if( root == null){
            return;
        }
        preOrder.add(root.val);
        for(Node child : root.children){
            helper(preOrder,child);
        }
    }
}
