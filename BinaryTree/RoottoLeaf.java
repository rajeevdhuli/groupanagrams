class Tree{
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        // Code here
        ArrayList<ArrayList<Integer>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),root);
        return trolly;
    }
    public static void helper(ArrayList<ArrayList<Integer>> trolly,ArrayList<Integer> bag,Node root){
        if(root == null)
           return;
        if(root.left == null && root.right == null){
            bag.add(root.data);
            trolly.add(new ArrayList<>(bag));
            bag.remove(bag.size()-1);
            return;
        }   
        bag.add(root.data);
        helper(trolly,bag,root.left);
        helper(trolly,bag,root.right);
        bag.remove(bag.size()-1);
    }
    
}
