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
    public String tree2str(TreeNode root) {
      if( root == null){
        return "";
      }
      StringBuilder sb = new StringBuilder();
      helper(root,sb);
      return sb.toString();
    }
    private void helper(TreeNode root, StringBuilder sb){
      sb.append(root.val);
      if(root.left == null && root.right == null){
        return;
      }
      if(root.left != null){
        sb.append('(');
        helper(root.left,sb);
        sb.append(')');
      }
       if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }
            sb.append("(");
            helper(root.right, sb);
            sb.append(")");
        }
    }
}




C++ CODE -------------------------------------------------------------------------------------------------------



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
    string tree2str(TreeNode* root) {
                if (root == nullptr) {
            return "";
        }
        string result;
        helper(root, result);
        return result;
    }
    
private:
    void helper(TreeNode* root, string& result) {
        result += to_string(root->val);
        if (root->left == nullptr && root->right == nullptr) {
            return;
        }
        if (root->left != nullptr) {
            result += '(';
            helper(root->left, result);
            result += ')';
        }
        if (root->right != nullptr) {
            if (root->left == nullptr) {
                result += "()";
            }
            result += '(';
            helper(root->right, result);
            result += ')';
        }
    }  
};



