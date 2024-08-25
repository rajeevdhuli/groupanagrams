class Solution {
    public int minimumDeletions(int[] nums) {
        // Initialize variables to track the positions of the minimum and maximum elements
        int minPosition = -1;
        int maxPosition = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        int n = nums.length; // Length of the array

        // Traverse the array to find the positions of the minimum and maximum elements
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                minPosition = i; // Update minPosition if a new minimum is found
                min = nums[i];   // Update the minimum value
            }
            if (nums[i] > max) {
                maxPosition = i; // Update maxPosition if a new maximum is found
                max = nums[i];   // Update the maximum value
            }
        }

        // Calculate the number of deletions required from the left
        // This is the number of elements to delete from the start to cover both min and max positions
        int fromLeft = Math.max(minPosition, maxPosition) + 1;

        // Calculate the number of deletions required from the right
        // This is the number of elements to delete from the end to cover both min and max positions
        int fromRight = n - Math.min(minPosition, maxPosition);

        // Calculate the number of deletions required if removing from both ends
        // Remove elements up to the minimum position from the left
        // Plus remove elements after the maximum position from the right
        int fromBoth = Math.min(minPosition, maxPosition) + 1 + (n - Math.max(minPosition, maxPosition));

        // Return the minimum number of deletions required among the three calculated strategies
        return Math.min(fromLeft, Math.min(fromRight, fromBoth));
    }
}
