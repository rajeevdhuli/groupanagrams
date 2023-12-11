BFS - 

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return rightView;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode temp = queue.poll();
                if(size - 1 == 0){
                    rightView.add(temp.val);
                }
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
                size--;
            }
        }
        return rightView; 
    }
}
















class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        if(root == null){
            return rightView;
        }
        Map<Integer,Integer> mp = new TreeMap<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair<TreeNode,Integer> p = queue.poll();
            int l = p.getValue();
            TreeNode temp = p.getKey();
            if(!mp.containsKey(l)){
                mp.put(l,temp.val);
            }
            if(temp.right != null){
                queue.offer(new Pair(temp.right,l+1));
            }
            if(temp.left != null){
                queue.offer(new Pair(temp.left,l+1));
            }
            
        }
        for(int v:mp.values()){
            rightView.add(v);
        }
        return rightView; 
    }
}
