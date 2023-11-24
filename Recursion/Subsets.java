class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums, 0, new ArrayList<>(), new ArrayList<>());
    }

    public List<List<Integer>> helper(int[] nums, int i, List<Integer> bag, List<List<Integer>> trolly) {

        if(i == nums.length) {
            List<Integer> newBag = new ArrayList<>();
            newBag.addAll(bag);
            trolly.add(newBag);
            return trolly;
        }
        bag.add(nums[i]);
        helper(nums, i+1, bag, trolly);

        bag.remove(bag.size()-1);
        return helper(nums, i+1, bag, trolly);
         
    }
}


          []
        /    \
  [1]           []
 /   \       /     \
[1,2]  [1]  [2]    []
/  \   / \   / \   / \
[1,2,3] [1,3][2,3][3] []



Approach 2 - 

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    //Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){

    list.add(new ArrayList<>(tempList));
    //System.out.println("Enter "+start+" "+list);
     
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        //System.out.println("1st "+i+" "+tempList);

        backtrack(list, tempList, nums, i + 1);
       
        //System.out.println("2nd "+i+" "+tempList);
        tempList.remove(tempList.size() - 1);
    }
}
}



                            [] (empty set)
                   /                     \
           [1]                                 []
        /        \                          /       \
   [1, 2]       [1]                  [2]         []
   /    \       /    \              /    \      /     \
[1,2,3] [1,2] [1,3] [1]         [2,3] [2]  [3]      []



