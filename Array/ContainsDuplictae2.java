USING HASHMAP - O(N),O(N)-


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indices = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            if(!indices.containsKey(nums[i])){
                indices.put(nums[i],i);
            }
            else{
                if(i - indices.get(nums[i]) <= k)
                    return true;
                else
                    indices.put(nums[i],i);    
            }   
        }
        return false;
    }
}


USING SLIDING WINDOW HASHSET- O(N),O(MIN(N,K+1))


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ;i < nums.length; i++){
            if(i > k){
                set.remove(nums[i-k-1]);
            }
            if(set.contains(nums[i]))
               return true;
            set.add(nums[i]);
        }
        return false;
    }
}
