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




brute force - 



import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int kDistinctChars(int k, String str) {
        int n = str.length();
        int maxLength = 0;

        for (int start = 0; start < n; start++) {
            Set<Character> distinctChars = new HashSet<>();
            for (int end = start; end < n; end++) {
                distinctChars.add(str.charAt(end));
                if (distinctChars.size() <= k) {
                    maxLength = Math.max(maxLength, end - start + 1);
                } else if (distinctChars.size() > k) {
                    break; // No need to check further as we already exceeded k distinct characters
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = "eceba";
        int k = 2;
        System.out.println(sol.kDistinctChars(k, str)); // Output: 3
    }
}

