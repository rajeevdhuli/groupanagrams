RECURSIVE O(N),O(N) -
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> inOrder = new ArrayList<>(); 
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
          return inOrder;
        }
        inorderTraversal(root.left);
        inOrder.add(root.val);
        inorderTraversal(root.right);
        return inOrder;
    }
}










/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(st.size()>0||root != null){
            while(root !=  null){
                st.push(root);
                root = root.left;
            }
            root = st.peek();
            inOrder.add(root.val);
            st.pop();
            root = root.right;
        }
        return inOrder;
    }
}






















/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(true){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            if(st.isEmpty())
               break;
            root = st.peek();
            inOrder.add(root.val);
            st.pop();
            root = root.right;
        }
        return inOrder;
    }
}
