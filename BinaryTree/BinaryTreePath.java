class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        Queue<Pair<TreeNode,String>> queue = new LinkedList<>();
        if(root == null){
            return ans;
        }
        queue.offer(new Pair(root, root.val + ""));
        while (!queue.isEmpty()) {
            Pair<TreeNode, String> temp = queue.poll();
            TreeNode node = temp.getKey();
            String path = temp.getValue();
            if (node.left == null && node.right == null) {
                ans.add(path);
            }
            if (node.left != null) {
                queue.offer(new Pair(node.left, path + "->" + node.left.val));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, path + "->" + node.right.val));
            }
        }
        return ans;
    }
}






class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root,ans,"");
        return ans;
    }
    public void helper(TreeNode root, List<String> ans, String res){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            ans.add(res+root.val);
            return;

        }
        helper(root.left,ans,res+root.val+"->");
        helper(root.right,ans,res+root.val+"->");
    }
}
