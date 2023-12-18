class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++){
            addTree(root,preorder[i]);
        }
        return root;
    }
    public void addTree(TreeNode root,int n){
        if(n <= root.val){
            if(root.left == null){
                root.left = new TreeNode(n);
                return;
            }else{
                addTree(root.left,n);
            }
        }if(n  >  root.val){
            if(root.right == null){
                root.right = new TreeNode(n);
                return;
            }else{
                addTree(root.right,n);
            }
        }
    }
}
