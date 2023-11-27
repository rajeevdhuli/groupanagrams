class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),candidates,target,0,0);
        return trolly;
    }
    public void helper(List<List<Integer>> trolly,List<Integer> bag,int[] can , int target,int start,int sum){
        if(sum > target)
           return;
        if(sum == target)
           trolly.add(new ArrayList<>(bag));
        for(int i = start; i < can.length; i++){
            if(i > start && can[i] == can[i-1])
                continue;
            bag.add(can[i]);
            helper(trolly,bag,can,target,i+1,sum+can[i]);
            bag.remove(bag.size()-1);
        }
    }
}
