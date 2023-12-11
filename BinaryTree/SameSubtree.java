class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(isSame(root,subRoot))
           return true;   
        boolean l = isSubtree(root.left,subRoot);
        if(l)
           return true;
        boolean r = isSubtree(root.right,subRoot);
        return r;  
    }
    public boolean isSame(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root.val != subRoot.val){
            return false;
        }
        if(root.val == subRoot.val){
            boolean left = isSame(root.left,subRoot.left);
            boolean right = isSame(root.right,subRoot.right);
            if(left && right){
                return true;
            }
        }
        return false;
    }
}
