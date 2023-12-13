import java.util.Map;
import java.util.*;
public class Solution {

	public static int kDistinctChars(int k, String str) {
		char[] c = str.toCharArray();
		Map<Character,Integer> mp = new HashMap<>();
		int n = str.length();
		int right = 0 ;
		int left = 0 ;
		int maxLength = 0;
		while(right < n){
			mp.put(c[right],mp.getOrDefault(c[right], 0)+1);
			while(mp.size() > k){
				if(mp.get(c[left]) == 1){
					mp.remove(c[left]);
				}else{
					mp.put(c[left],mp.get(c[left])-1);
				}
				left++;
			}
			maxLength = Math.max(maxLength,right - left + 1);
			right++;
		}
		return maxLength;
	}

}
