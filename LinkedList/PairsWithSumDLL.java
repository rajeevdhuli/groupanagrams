class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        while(head != null && tail != null && head.data < tail.data){
            // adding head.data < tail.data to make sure duplicates do not come
            int sum = head.data + tail.data;
            if(sum == target){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(head.data);
                temp.add(tail.data);
                list.add(temp);
                head = head.next;
                tail = tail.prev;
            }else if(sum > target){
                tail = tail.prev;
            }else{
                head = head.next;
            }
        }
        return list;
    }
}
