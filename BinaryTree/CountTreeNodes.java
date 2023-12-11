class Solution {
    public int countNodes(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int cnt = 0;
        if(root == null){
            return 0;
        }
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            cnt+= size;
            while(size-- > 0){
                if(q.peek().left != null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right != null){
                    q.offer(q.peek().right);
                }
                q.poll();
               
            }
        }
        return cnt;
    }
}









class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper(root);
    }
    public static int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        return 1 + l + r;
    }
}












class Solution {
    public static  int leftHeight(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
    }
    public static  int rightHeight(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.right;
        }
        return height;
    }
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lh = leftHeight(root.left);
        int rh = rightHeight(root.right);
        if(lh == rh){
            return ((int)Math.pow(2,lh+1) - 1);
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}








