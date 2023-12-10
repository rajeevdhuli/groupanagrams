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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return zigzag;
        }
        int cnt = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list =new ArrayList<>();
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                list.add(queue.poll().val);
            }
            if(cnt % 2 == 0){
                zigzag.add(list);
            }else{
                Collections.reverse(list);
                zigzag.add(list);
            }
            cnt++;
        }
        return zigzag;
    }
}







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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return zigzag;
        }
        boolean flag = true;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list =new ArrayList<>(size);
            for(int i = 0 ; i < size ; i++){
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                if(flag)
                   list.add(queue.poll().val);
                else{
                    list.add(0,queue.poll().val);
                }   
            }
            flag = !flag;
            zigzag.add(list);
        }
        return zigzag;
    }
}














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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root == null){
            return zigzag;
        }
        dq.offer(root);
        int l = 1;
        TreeNode temp ;
        zigzag.add(new ArrayList<>(Arrays.asList(root.val)));
        while(!dq.isEmpty()){
            int size = dq.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < size; i++){
                if(l % 2 == 0){
                    temp = dq.pollLast();    
                }
                else{
                    temp = dq.pollFirst();   
                }
                if(l % 2 == 0){
                    if(temp.left != null){
                        dq.offerFirst(temp.left);
                        list.add(temp.left.val);
                    }
                    if(temp.right != null){
                        dq.offerFirst(temp.right);
                        list.add(temp.right.val);
                    }

                }
                else{
                    if(temp.right!= null){
                       dq.offerLast(temp.right);
                       list.add(temp.right.val);
                    }
                    if(temp.left != null){
                        dq.offerLast(temp.left);
                        list.add(temp.left.val);
                    }
                }
            }
            l++;
            if(list.size() > 0)
                zigzag.add(list);
        }
        return zigzag;
    }
}
