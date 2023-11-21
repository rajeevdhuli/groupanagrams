class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        Node tail = cur;
        cur = head;
        
        
        while(cur.data < tail.data){
            
            int sum = cur.data + tail.data;
            ArrayList<Integer> res = new ArrayList<>();
            
            if( sum ==  target){
                res.add(cur.data);
                res.add(tail.data);
                ans.add(res);
                cur = cur.next;
                tail = tail.prev;
            }
            
            else if(sum > target){
                tail= tail.prev;
            } 
            
            else if (sum <  target){
                cur = cur.next;
            }

        }
        return ans;
    }
}
