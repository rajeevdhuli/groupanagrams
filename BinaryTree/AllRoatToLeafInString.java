import java.util.List;
import java.util.*;
public class Solution {
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        // Write your code here.
        List<String> ans = new ArrayList<>();
        helper(ans,root,new String());
        return ans;
    }
    public static void helper(List<String> ans,BinaryTreeNode root,String res){
        if(root == null)
           return;
        if(root.right == null && root.left == null){
            ans.add((res+root.data));
            return;
        }   
        helper(ans,root.left,res+root.data+" ");  
        helper(ans,root.right,res+root.data+" ");
    }
}
