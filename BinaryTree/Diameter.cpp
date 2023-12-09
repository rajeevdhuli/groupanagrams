/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int diameterOfBinaryTree(TreeNode* root) {
        int diameter = 0 ;
        helper(root,diameter);
        return diameter;
    }
    int helper(TreeNode* &root,int& d){
        if(root == nullptr){
            return 0;
        }
        int lh = helper(root->left, d);
        int rh = helper(root->right,d);
        d = max(d,lh+rh);
        return max(lh,rh)+1;
    }
};











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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        helper(root,diameter);
        return diameter[0]; 
    }
    public int helper(TreeNode root, int[] d){
        if( root == null){
            return 0;
        }
        int lh = helper(root.left,d);
        int rh = helper(root.right,d);
        d[0] = Math.max(d[0],lh + rh);
        return Math.max(lh,rh)+1;
    }
}
