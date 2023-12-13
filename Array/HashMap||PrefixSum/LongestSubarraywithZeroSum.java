import java.util.Map;
import java.util.*;

public class Solution {
    public static int getLongestZeroSumSubarrayLength(int []arr){
        // Write your code here.
        int n = arr.length;
        Map<Integer,Integer> mp = new HashMap<>();
        int maxLength = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = sum + arr[i];
            if(sum == 0){
                maxLength = Math.max(maxLength,i+1);
            }
            int rem = sum - 0;
            if(mp.containsKey(rem)){
                maxLength = Math.max(maxLength,i -mp.get(rem));
            }
            if(!mp.containsKey(sum)){
                mp.put(sum,i);
            }
        }
        return maxLength;
    }
}
