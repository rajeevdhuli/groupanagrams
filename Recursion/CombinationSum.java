class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),candidates,target,0,0);
        return trolly;
    }
    public void helper(List<List<Integer>> trolly, List<Integer> bag,int[] can, int target, int i,int sum){
        if(sum == target){
            List<Integer> newBag = new ArrayList<>();
            newBag.addAll(bag);
            trolly.add(newBag);
            return;
        }
        if(sum > target){
            //System.out.println("Greater "+ i +" "+bag+" "+sum);
            return;
        }
        if(i == can.length) {
            return;
        }
        //System.out.println("befor 1st "+ i +" "+bag+" "+sum);
        bag.add(can[i]);
        //System.out.println("after 1st "+ i +" "+bag+" "+sum);
        helper(trolly,bag,can,target,i,sum+can[i]);
        //System.out.println("befor 2nd "+ i +" "+bag+" "+sum);
        bag.remove(bag.size()-1);
        //System.out.println("after 2nd "+ i +" "+bag+" "+sum);
        helper(trolly,bag,can,target,i+1,sum);
    }
}






class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),candidates,target,0,0);
        return trolly;
    }
    public void helper(List<List<Integer>> trolly, List<Integer> bag,int[] can, int target, int start,int sum){
        if(sum > target)
           return;
        if(sum == target)
           trolly.add(new ArrayList<>(bag));
        for(int i = start; i < can.length; i++){
            // if(i > start && can[i] == can[i-1])
            //     continue;
            bag.add(can[i]);
            helper(trolly,bag,can,target,i,sum+can[i]);
            bag.remove(bag.size()-1);
        }
    }
}
