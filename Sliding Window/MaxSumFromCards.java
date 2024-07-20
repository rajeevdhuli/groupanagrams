class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum+= cardPoints[i];
            
        }
        int cur = sum;
        for(int i = 0; i < k; i++){
            cur+=cardPoints[n-i-1] - cardPoints[k-i-1];
            sum = Math.max(sum,cur);
        }
        return sum;
        
    }
}





The optimal approach is to use a sliding window technique to find the minimum sum of a subarray of length n - k, where n is the length of the card points array, and k is the number of cards to be picked. The reason for this approach is that minimizing the sum of the remaining n - k cards will maximize the sum of the picked k cards.

Here is the detailed solution:

Calculate the total sum of the card points array.
Use a sliding window of size n - k to find the minimum sum of any subarray of that size.
Subtract this minimum sum from the total sum to get the maximum points.
Java Solution
java
Copy code
public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // Calculate the total sum of all card points
        int totalSum = 0;
        for (int point : cardPoints) {
            totalSum += point;
        }

        // Find the minimum sum of subarray of length n - k
        int windowSize = n - k;
        int minSubArraySum = 0;
        for (int i = 0; i < windowSize; i++) {
            minSubArraySum += cardPoints[i];
        }

        int currentSubArraySum = minSubArraySum;
        for (int i = windowSize; i < n; i++) {
            currentSubArraySum += cardPoints[i] - cardPoints[i - windowSize];
            minSubArraySum = Math.min(minSubArraySum, currentSubArraySum);
        }

        // The maximum points we can obtain
        return totalSum - minSubArraySum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(sol.maxScore(cardPoints, k)); // Output: 12
    }
}
Explanation
Calculate Total Sum:

We first calculate the total sum of the array cardPoints.
Sliding Window to Find Minimum Subarray Sum:

We initialize the sum of the first n - k elements.
We then slide the window from the start of the array to the end, updating the sum by subtracting the element that is left behind and adding the new element that enters the window.
During this process, we keep track of the minimum sum of any subarray of length n - k.
Compute the Maximum Points:

Subtract the minimum subarray sum from the total sum to get the maximum points obtainable by picking k cards from the beginning or end of the array.
Time Complexity
The time complexity of this solution is 
�
(
�
)
O(n), where 
�
n is the length of the input array. This is efficient enough for typical input sizes.
