import java.util.Stack;

class Solution {
    public int[] nearestSmallerToRight(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements that are greater than or equal to the current element
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }

            // If stack is empty, no smaller element to the right
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            // Push the current element onto the stack
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = sol.nearestSmallerToRight(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Output: 2 2 -1 8 -1
    }
}
