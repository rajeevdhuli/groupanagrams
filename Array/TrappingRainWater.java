class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        for (int i = 0; i < n; i++)
        {
            int j = i;
            int leftMax = 0;
            int rightMax = 0;
            while(j >= 0)
            {
                leftMax =  Math.max(leftMax, height[j]);
                j--;
            }
            j = i;
            while(j < n)
            {
                rightMax = Math.max(rightMax, height[j]);
                j++;
            }
            water+= Math.min(leftMax,rightMax) - height[i];
        }
        return water;
    }
}


class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n-1] = height[n-1];
        for(int i = 1; i < n; i++)
        {
            left[i] = Math.max( height[i], left[i-1]);
        }
        for(int i = n - 2; i >= 0; i--)
        {
            right[i] = Math.max( height[i], right[i+1]);
        }
        for(int i = 0; i < n; i++)
        {
            int count;
            count= Math.min(left[i], right[i]) - height[i];
            if(count > 0)
               water+= count;
        }
        return water;
    }
}
