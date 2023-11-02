O(n+m) - 

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        int left = 0;
        int right = 0;
        int i = 0;
        int[] nums3 = new int[n+m];
        while( left < m && right < n)
        {
            if(nums1[left] <= nums2[right])
            {
               nums3[i]=nums1[left];
               left++;
               i++;
            }
            else
            {
                nums3[i] = nums2[right];
                right++;
                i++;
            }
        }
        while(right < n)
        {
            nums3[i] = nums2[right];
            right++;
            i++;
        }
        while(left < m)
        {
            nums3[i]=nums1[left];
            left++;
            i++; 
        }
        for(int j = 0; j< (n+m);j++)
        {
            nums1[j]=nums3[j];
        }
    }
}



