import java.util.List;
import java.util.*;

public class Solution {
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        List<Integer> res = new ArrayList<>();
        if(isLeaF(root) == false)
            res.add(root.data);    
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);
        return res;    
        
    }
    static boolean isLeaF(TreeNode root){
        if(root != null && root.left == null && root.right == null){
            return true;
        }
        return false;
    }

    static void addLeftBoundary(TreeNode root,List<Integer> res){
        TreeNode cur  = root.left;
        while(cur !=  null){
            if(isLeaF(cur) == false)
                res.add(cur.data); 
            if(cur.left != null){
                cur = cur.left;
            }else{
                cur = cur.right;
            };   
        }
    }

    static void addLeaves(TreeNode root,List<Integer> res){
        if(isLeaF(root)){
            res.add(root.data);
            return;
        }
        if(root.left != null)
            addLeaves(root.left,res);
        if(root.right != null){
            addLeaves(root.right,res);
        }    
    }

    static void addRightBoundary(TreeNode root, List<Integer> res){
        TreeNode cur = root.right;
        int index = res.size() ;
        while(cur != null){
            if(isLeaF(cur) == false){
                res.add(index,cur.data);
                //System.out.println(index+" "+res.get(index)+" "+cur.data);
            }
            if(cur.right != null){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
    }
}
