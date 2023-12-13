import java.util.* ;
import java.io.*; 
public class Solution {
	public static int getLongestSubarray(int []nums, int k) {
		// Write your code here.
		int n = nums.length;
		Map<Integer,Integer> mp = new HashMap<>();
		int sum = 0 ;
		int maxLength = 0;
		for(int i = 0 ;i < n; i++){
			sum = sum + nums[i];
			if(sum == k){
				maxLength = Math.max(maxLength, i+1);
			}
			int rem = sum - k;
			if(mp.containsKey(rem)){
				maxLength = Math.max(maxLength,i - mp.get(rem));
			}
			if(!mp.containsKey(sum)){
				mp.put(sum,i);
			}
		}
		return maxLength;
	}
}


EDGE CASE -
example -
[ 2 4 0 0 0 1 3 ]
  0 1 2 3 4 5 6
k  = 4;
if we do not put -
  if(!mp.containsKey(sum)){
				mp.put(sum,i);
	}  
the zeros will overwrite in map  - (6,4) instead of (6,1) 
  so when you go to end and sum becomes 10 and search for rem = 10 -4 =6 ,
maxLength will be (i - mp.get(rem)) = 2 [ 1 3]
but if you look closely it is [0 0 0 1 3]
maxLength will be 5 hence you do not overwrite in map to get Longest Distance.  
