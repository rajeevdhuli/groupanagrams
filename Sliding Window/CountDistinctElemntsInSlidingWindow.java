import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    ArrayList<Integer> countDistinct(int A[], int n, int k) {
        Map<Integer, Integer> hM = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int[] ans = new int[n-k+1];


       // Traverse the first window and store count  of every element in hash map
        for (int i = 0; i < k; i++) {
            hM.put(A[i], hM.getOrDefault(A[i], 0) + 1);
        }

        ans.add(hM.size());

        for (int i = k; i < A.length; i++) {
            
             // Remove first element of previous window
            // If there was only one occurrence
            if (hM.get(arr[i - K]) == 1) {
                hM.remove(arr[i - K]);
            }

            else // reduce count of the removed element
                hM.put(arr[i - K], hM.get(arr[i - K]) - 1);

            // Add new element of current window
            // If this element appears first time,
            // set its count as 1,
            hM.put(A[i], hM.getOrDefault(A[i], 0) + 1);

          
            ans.add(hM.size());
        }
        return ans;
    }
}
