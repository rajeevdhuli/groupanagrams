import java.util.List;
import java.util.*;
public class Solution {
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        // Write your code here.
        List<Integer> list1 = new ArrayList<>();
        addToArray(root1,list1);
        List<Integer> list2 = new ArrayList<>();
        addToArray(root2,list2);
        return mergeArrays(list1,list2);
    }
    public static void addToArray(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        addToArray(root.left, list);
        list.add(root.data);
        addToArray(root.right, list);
    }
    public static List<Integer>  mergeArrays(List<Integer> list1, List<Integer> list2){
        int i = 0 ; 
        int j = 0;
        int n = list1.size();
        int m = list2.size();
        List<Integer> list3 = new ArrayList<>();
        while(i < n && j < m){
            if(list1.get(i) <= list2.get(j)){
                list3.add(list1.get(i));
                i++;
            }else if(list1.get(i) > list2.get(j)){
                list3.add(list2.get(j));
                j++;
            }
        }
        while(i < n){
            list3.add(list1.get(i));
            i++;
        }
        while(j < m){
            list3.add(list2.get(j));
            j++;
        }
        return list3;
    }
}
