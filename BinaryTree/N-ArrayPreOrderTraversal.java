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
        Stack<Node> st = new Stack<>();
        if(root == null){
            return preOrder;
        }
        st.push(root);
        while(st.size() > 0){
            root = st.peek();
            preOrder.add(root.val);
            st.pop();
            int size = root.children.size();
            for(int i = size - 1; i >= 0; i--){
                st.push(root.children.get(i));
            }
        }
        return preOrder;
    }
}
