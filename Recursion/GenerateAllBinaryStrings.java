import java.util.List;
import java.util.*;

public class Solution {
    public static void helper(List<String> trolly,int prev,int N, StringBuilder sb,int start){
        //System.out.println(start+" "+sb);
        if(sb.length() == N){
           trolly.add(new String(sb));
           return;
        }
        sb.append("0");
        helper(trolly,0,N,sb,start+1);
        sb.deleteCharAt(sb.length()-1);
        if(prev != 1){
            sb.append("1");
            helper(trolly,1,N,sb,start+1);
            sb.deleteCharAt(sb.length()-1);
        } 


       
    }
    public static List< String > generateString(int N) {
        // Write your code here.
        List<String> trolly = new ArrayList<>();
        helper(trolly,0,N,new StringBuilder(),0);
        return trolly;
    }
}




import java.util.List;
import java.util.*;

public class Solution {
    public static void helper(List<String> trolly,int prev,int N, String temp,int start){
        if(temp.length() == N){
           trolly.add(temp);
           return;
        }
        helper(trolly,0,N,temp+"0",start+1);
        if(prev != 1){
            helper(trolly,1,N,temp+"1",start+1);  
        }  
    }
    public static List< String > generateString(int N) {
        // Write your code here.
        List<String> trolly = new ArrayList<>();
        helper(trolly,0,N,"",0);
        return trolly;
    }
}
