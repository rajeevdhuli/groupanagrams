class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int n : nums){
            mp.put(n,mp.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Integer a,Integer b){
                return mp.get(a) - mp.get(b);
            }
        });
        for(int n : mp.keySet()){
            pq.offer(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] ans  = new int[k];
        for(int i = 0; i < k ; i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}
