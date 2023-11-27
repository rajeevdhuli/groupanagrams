class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> trolly = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(),trolly);
        return trolly;
    }

    public void helper(int[] nums, int start, List<Integer> bag, List<List<Integer>> trolly) {
        if(bag.size() == nums.length){
            trolly.add(new ArrayList<>(bag));
        }
        for(int i =  0; i < nums.length; i++){
            if(bag.contains(nums[i])){
               continue;
            }     
            // System.out.println("before 1st "+i+" "+bag);
            bag.add(nums[i]);
            // System.out.println("after 1st "+i+" "+bag);
            helper(nums,0,bag,trolly);
            // System.out.println("before 2nd "+i+" "+bag);
            bag.remove(bag.size()-1);
            // System.out.println("after 2nd "+i+" "+bag);
        }
    }
}



class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> trolly = new ArrayList<>();
        helper(nums, new ArrayList<>(),trolly);
        return trolly;
    }

    public void helper(int[] nums,  List<Integer> bag, List<List<Integer>> trolly) {
        if(bag.size() == nums.length){
            trolly.add(new ArrayList<>(bag));
        }
        for(int num : nums){
            if(bag.contains(num)){
               continue;
            }     
            bag.add(num);
            helper(nums,bag,trolly);
            bag.remove(bag.size()-1);
        }
    }
}
