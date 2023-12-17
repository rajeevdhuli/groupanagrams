class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }   
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        int res = 1;
        queue.offer(new Pair<>(root,1));
        int maxWidth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int end = 0 ;
            int start = 0;
            for(int i = 0; i < size; i++){
                Pair<TreeNode,Integer> p = queue.poll();
                TreeNode node = p.getKey();
                int index = p.getValue();
                if( i == 0){
                    start  = index;
                }
                if(i == size - 1){
                    end = index;
                }
                if(node.left != null){
                    queue.offer(new Pair<>(node.left,2*index));
                }
                if(node.right != null){
                    queue.offer(new Pair<>(node.right,2*index+1));
                }
            }
            maxWidth = Math.max(maxWidth,end-start+1);
        }
        return maxWidth;
    }
}
