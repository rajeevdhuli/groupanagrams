RECURSIVE O(N) , O(N) -

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
  List<Integer> preOrder = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
      
      if(root == null)
        return preOrder;
      preOrder.add(root.val);
      preorderTraversal(root.left);
      preorderTraversal(root.right);
      return preOrder; 
    }
}




ITERATIVE O(N),O(N) ------------------------------------------------------------------------------------------------------------------------



  
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
    public List<Integer> preorderTraversal(TreeNode root) {  
        List<Integer> preOrder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root != null)
           st.push(root);
        while(root != null){
            preOrder.add(st.peek().val);
            st.pop();
            if(root.right!= null){
                st.push(root.right);
            }
            if(root.left!= null){
                st.push(root.left);
            }
            if(root.left != null){
                root = root.left;
            }else if(root.right != null){
                root = root.right;
            }else if(!st.isEmpty()){
              root =  st.peek();
            }else{
              break;
            }
        }
        return preOrder;
    }
}




MORE OPTIMIZED --




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
    public List<Integer> preorderTraversal(TreeNode root) {  
        List<Integer> preOrder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root != null)
           st.push(root);
        while(!st.isEmpty()){
            TreeNode cur = st.peek();
            preOrder.add(cur.val);
            st.pop();
            if(cur.right!= null){
              st.push(cur.right);
            }
            if(cur.left!= null){
              st.push(cur.left);
            }
        }
        return preOrder;
    }
}  
  
