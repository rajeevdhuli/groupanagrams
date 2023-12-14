class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i< n ; i++){
            int j = (Math.abs(nums[i]) - 1);
            if(nums[j] < 0){
                list.add(Math.abs(nums[i]));
                continue;
            }else{
                nums[j] = nums[j] * -1;
            }
        }
        return list;
    }
}
