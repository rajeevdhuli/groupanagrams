class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        int level = 1;
        queue.offer(new Pair(root,1));
        int minVal = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                var temp = queue.poll();
                TreeNode node = temp.getKey();
                int l = temp.getValue();
                if(node.left == null && node.right == null)
                     minVal  = Math.min(minVal,l);
                if(node.left!=null){
                    int l_level = l+1;
                    queue.offer(new Pair(node.left,l_level));
                }
                if(node.right!=null){
                    int r_level = l+1;
                    queue.offer(new Pair(node.right,r_level));
                }
                size--;
            }
            level++;
        }
        return minVal;
    }
}






class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        queue.offer(root);
        int minVal = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null)
                    return level
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }
            level++;
        }
        return minVal;
    }
}









class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
           return 0;
        return helper(root);   
    }
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = helper(root.left);
        int rh = helper(root.right);
       return (lh == 0 || rh == 0) ? lh + rh + 1 : Math.min(lh, rh) + 1; 

    }
}
