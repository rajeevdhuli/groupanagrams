CODING NINGAS-

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

Direct in place -

public class Solution {
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        // Write your code here.
       int n = a.length;
       int m = b.length;
       int left = n-1;
       int right = 0;
       while(left >=0 && right < m)
       {
           if(a[left] > b[right])
           {
               long temp = b[right];
               b[right] = a[left];
               a[left] = temp;
               left--; 
               right++;
           }
           else  
              break;
       }
       Arrays.sort(a);
       Arrays.sort(b);
    }
}
    

LEETCODE VERSION PROBLEM-

class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) 
    {
        int left = m - 1;
        int right = n - 1;
        int end = n + m - 1;
        while(left >= 0 && right >= 0)
        {
            if( arr1[left] >= arr2[right])
            {
                arr1[end] = arr1[left];
                end--;
                left--;
            }
            else
            {
                arr1[end] = arr2[right];
                end--;
                right--;
            }
        }
        while(right >= 0)
        {
            arr1[end] = arr2[right];
            end--;
            right--;
        }
        // while(left >= 0)
        // {
        //     arr1[end] = arr1[left];
        //     end--;
        //     left--;
        // }
        //NOT REQUIRED
    }    
    

