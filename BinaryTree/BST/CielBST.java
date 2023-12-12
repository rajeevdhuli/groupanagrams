public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {

        // Write your code here
       int ciel = -1;
       while(node != null){
           if(node.data == x){
               return x;
           }
           else if (node.data < x){
               node = node.right;
           }
           else if (node.data > x){
               ciel = node.data;
               node = node.left;
           }
       }
       return ciel;

    }
}
