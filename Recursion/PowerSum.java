Class Soluton{
   public static int powerSum(int X, int N) {
    // Write your code here
        List<List<Integer>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),X,N,1,0);
        return trolly.size();
    }
    public static void helper(List<List<Integer>> trolly,List<Integer> bag,int X, int N,int start,int sum){
        if(sum == X){
            trolly.add(new ArrayList<>(bag));
            System.out.println(trolly);
            return;
        }
        if(sum > X)
            return;
        for(int i = start; i < X /N; i++){
            bag.add(i);
            helper(trolly,bag,X,N,i+1,sum+(int)Math.pow(i,N));
            bag.remove(bag.size()-1);
        }
    }
}
