import java.util.ArrayList;
import java.util.*;

public class Solution {
    public static void helper(List<List<Integer>> trolly,List<Integer> bag, int []a,int k,int start,int sum){
        if(sum == k){
            trolly.add(new ArrayList<>(bag));
            return;
        }
        if(sum > k)
           return;
        if(trolly.size()>0){
            return ;
        }   
        for(int i = start; i <  a.length; i++){
            bag.add(a[i]);
            helper(trolly,bag,a,k,i+1,sum+a[i]);
            bag.remove(bag.size()-1);
        }
    }
    public static boolean isSubsetPresent(int n, int k,int []a) {
        // Write your code here
        List<List<Integer>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),a,k,0,0);
        return (trolly.size() > 0);
    }
}
