public class Solution
{
    public static int minValue(Node root) {
        // Write your code here.
        if(root == null)
           return -1;
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }
}
