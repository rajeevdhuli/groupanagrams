class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),n,k,1);
        return trolly;
    }
    public void helper(List<List<Integer>> trolly,List<Integer> bag,int n,int k,int i){
        if(bag.size() == k ){
            trolly.add(new ArrayList<>(bag));
            return;
        }
        if(bag.size() > k)
           return;
        if(i > n){
            return;
        }   
        bag.add(i);
        helper(trolly,bag,n,k,i+1);
        bag.remove(bag.size()-1);
        helper(trolly,bag,n,k,i+1);
    }
}






class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),n,k,1);
        return trolly;
    }
    public void helper(List<List<Integer>> trolly,List<Integer> bag,int n,int k,int start){
        if(bag.size() == k ){
            trolly.add(new ArrayList<>(bag));
            return;
        }
        if(bag.size() > k)
           return;

        for(int i = start; i <= n; i++){
            bag.add(i);
            helper(trolly,bag,n,k,i+1);
            bag.remove(bag.size()-1);
        }
    }
}
