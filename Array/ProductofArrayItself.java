O(n) , O(2n) space

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        int leftp = 1, rightp = 1;
        for(int i = 0; i < n; i++)
        {
            left[i] = leftp;
            leftp*= nums[i];
        }
         for(int i = n-1 ; i >= 0; i--)
        {
            right[i] = rightp;
            rightp*= nums[i];
        }
        for(int i = 0; i < n; i++)
        {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}


Without extra space - 


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        int leftp = 1, rightp = 1;
        for(int i = 0; i < n; i++)
        {
            ans[i]=ans[i]*leftp;
            leftp=leftp*nums[i];

            ans[n-i-1]*=rightp;
            rightp*=nums[n-i-1];
        }
         
        return ans;
    }
}
