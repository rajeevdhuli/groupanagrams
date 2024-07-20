class Solution {
    public int characterReplacement(String s, int k) {
        char[] c  = s.toCharArray();
        int n = c.length;
        int start = 0, end  = 0;
        int maxLength = 0;
        int mostFreq = 0;
        Map<Character,Integer> mp = new HashMap<>();
        while(end < n){
            mp.put(c[end],mp.getOrDefault(c[end],0)+1);
            //find longest repeating character replacement
            mostFreq = Math.max(mostFreq, mp.get(c[end]));
            //example - AABACAD k=2 , length(7) - mostfreq(4) = 3(B,D,C) >  2 hence skrink 
            while((end - start + 1) - mostFreq > k){
                if(mp.get(c[start]) == 1 )
                   mp.remove(c[start]);
                else   
                   mp.put(c[start],mp.get(c[start])-1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}









Approach
The optimal approach to solve this problem is to use the sliding window technique along with a frequency map. Here’s a step-by-step explanation:

Sliding Window Technique:

Use two pointers to represent the current window (left and right).
Expand the window by moving the right pointer to include more characters.
Maintain a frequency map to keep track of character counts within the current window.
Replacement Check:

Calculate the number of characters that need to be replaced to make all characters in the current window the same.
The formula for the number of replacements needed is: (window length) - (frequency of the most frequent character in the window).
If the number of replacements is less than or equal to k, the window is valid.
Shrink Window if Necessary:

If the window is not valid (i.e., the number of replacements needed is more than k), shrink the window by moving the left pointer.
Track the Maximum Length:

Keep track of the maximum window length encountered that satisfies the condition.
Implementation in Java
Here’s the implementation of the above approach in Java:

java
Copy code
public class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0, maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(right) - 'A']);

            // If the current window is invalid, shrink the window from the left
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.characterReplacement("AABABBA", 1)); // Output: 4
    }
}
Explanation
Frequency Map:
count array of size 26 to store the frequency of each character (assuming uppercase English letters).
Expanding Window:
Iterate through the string using the right pointer.
Update the frequency of the current character and the maxCount (the highest frequency of any character in the current window).
Validating Window:
Check if the window is valid by ensuring the number of replacements needed (right - left + 1 - maxCount) is within k.
If not, shrink the window from the left and update the frequency map accordingly.
Tracking Maximum Length:
Update the maxLength with the maximum length of the valid window encountered.
Time Complexity
The time complexity of this solution is 
�
(
�
)
O(n), where 
�
n is the length of the string s. This is because each character is processed at most twice (once by the right pointer and once by the left pointer).

Space Complexity
The space complexity is 
�
(
1
)
O(1) because the size of the frequency array count is fixed at 26, regardless of the input size.
