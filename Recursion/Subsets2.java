

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> trolly = new ArrayList<>();
        List<Integer> bag = new ArrayList<>();
        helper(nums, 0, bag,trolly);
        return trolly;
    }

    public void helper(int[] nums, int start, List<Integer> bag, List<List<Integer>> trolly) {
        // if (trolly.contains((bag))){
        //     System.out.println("Already presnt " + bag);
        //     return;
        // }

        trolly.add(new ArrayList<>(bag));
        // System.out.println("Enter "+start+" "+trolly);
        for(int i = start; i < nums.length; i++){
            if( i > start && nums[i] == nums[i-1]){
                // System.out.println("continue "+i+" "+bag);
                continue; 
            }
            bag.add(nums[i]);
            // System.out.println("1st "+i+" "+bag);
            helper(nums , i + 1, bag, trolly);
            // System.out.println("before 2nd "+i+" "+bag);
            bag.remove(bag.size() - 1);
            // System.out.println("2nd "+i+" "+bag);
        }
    }
}




                        []
                      /  |  \
                     /   |   \
                 [1]   [2]   [2, 2]
               /   \     |
              /     \    |
          [1, 2] [1, 2, 2]
