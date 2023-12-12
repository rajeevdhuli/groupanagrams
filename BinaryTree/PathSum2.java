class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),root,targetSum);
        return trolly;
    }
    public void helper( List<List<Integer>> trolly, List<Integer> bag,TreeNode root, int sum){
        if(root == null)
            return; 
        int rem = sum - root.val;
        if(rem == 0 && root.left == null && root.right == null){
            bag.add(root.val); 
            trolly.add(new ArrayList<>(bag));
            bag.remove(bag.size()-1);
            return;
        }
        bag.add(root.val);  
        helper(trolly,bag,root.left,rem);
        helper(trolly,bag,root.right,rem);
        bag.remove(bag.size()-1);   
    }
}




class threePair{
    TreeNode root;
    int targetSum;
    List<Integer> path;
    threePair(TreeNode root,int targetSum,List<Integer> path){
        this.root = root;
        this.targetSum = targetSum;
        this.path = path;
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<threePair> queue = new LinkedList<>();
        if(root == null){
           return res;
        }
        queue.offer(new threePair(root, root.val, new ArrayList<>(Arrays.asList((root.val)))));
        while(!queue.isEmpty()) {
            threePair temp = queue.poll();
            TreeNode node = temp.root;
            int sum = temp.targetSum;
            List<Integer> list = temp.path;
            if(node.left == null && node.right == null && sum == targetSum){
                res.add(list);
            }
            if(node.left != null){
                List<Integer> leftList = new ArrayList<>(list);
                leftList.add(node.left.val);
                queue.offer(new threePair(node.left,node.left.val+sum,leftList));
            }
            if(node.right != null){
                List<Integer> rightList = new ArrayList<>(list);
                rightList.add(node.right.val);
                queue.offer(new threePair(node.right,node.right.val+sum,rightList));
            }
        }
        return res;
    }
}
