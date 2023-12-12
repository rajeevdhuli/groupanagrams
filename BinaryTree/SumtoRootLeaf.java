DFS

class Solution {
    public int sumNumbers(TreeNode root) {
        int[] ans = new int[1];
        helper(root,0,ans);
        return ans[0];
    }
    public int helper(TreeNode root,int sum,int[] ans){
        if(root == null){
            return 0;
        }
        sum = sum *10 + root.val;
        if(root.left == null && root.right == null){
            ans[0]+= sum;
            return ans[0];
        }
        helper(root.left,sum,ans);
        helper(root.right,sum,ans);
        return ans[0];
    }
}



DFS
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    public int helper(TreeNode root,int sum){
        if(root == null){
            return 0;
        }
        sum = sum *10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }
        int leftsum = helper(root.left,sum);
        int rightsum =helper(root.right,sum);
        return leftsum + rightsum;
    }
}








BFS

class Solution {
    public int sumNumbers(TreeNode root) {
         Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        int res = 0;
        if (root != null) {
            queue.offer(new Pair(root,root.val));
        }
        while (!queue.isEmpty()) {
            var temp = queue.poll();
            TreeNode node = temp.getKey();
            int curSum = temp.getValue();
            if(node.left == null && node.right == null){
                res+= curSum;
            }
            if(node.left != null){
                queue.offer(new Pair(node.left,curSum*10 + node.left.val));
            }
            if(node.right != null){
                queue.offer(new Pair(node.right,curSum*10 + node.right.val));
            }
        }
        return res;
    }
}
