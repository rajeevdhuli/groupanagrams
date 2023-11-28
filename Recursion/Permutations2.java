class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> trolly = new ArrayList<>();
        helper(nums, new ArrayList<>(),trolly,0,new boolean[nums.length]);
        return trolly;
    }

    public void helper(int[] nums,  List<Integer> bag, List<List<Integer>> trolly,int start,boolean used[]) {
        if(bag.size() == nums.length){
            trolly.add(new ArrayList<>(bag));
        }
        //System.out.println(bag);
        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1]) ){
               continue;
            }
            used[i] = true;     
            bag.add(nums[i]);
            helper(nums,bag,trolly,0,used);
            used[i] = false;
            bag.remove(bag.size()-1);
        }
    }
}
