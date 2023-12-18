O(NLOGN) O(N) - 
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        helper(root,minHeap);
        int ans = -1;
        for(int i =0 ;i < k; i++){
            ans = minHeap.poll();
        }
        return ans;
    }
    public void helper(TreeNode root, PriorityQueue<Integer> minHeap){
        if(root == null){
            return;
        }
        minHeap.offer(root.val);
        helper(root.left,minHeap);
        helper(root.right,minHeap);
    }
}


O(N),O(N) -

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        int ans = -1;
        for(int i =0 ;i < k; i++){
            ans = list.get(i);
        }
        return ans;
    }
    public void helper(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        if(list.size() > k)
          return;
        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);
    }
}



