class Solution {
    public int minSubArrayLen(int k, int[] arr)
    {
        int start = 0, end = 0, sum = 0, maxLength = Integer.MAX_VALUE;
        int n = arr.length;
        while (end < n) 
        {
            sum = sum + arr[end];
            while(start <= end && sum >= k)
            {
                maxLength = Math.min(maxLength , (end - start +1));
                sum-= arr[start];
                start++;
            }
            end++;  
        }
        if(maxLength == Integer.MAX_VALUE)
           return 0;
        return maxLength;
    }
}





class Solution {
    public int minSubArrayLen(int k, int[] arr)
    {
         int start = 0, end = 0, sum = 0, maxLength = Integer.MAX_VALUE;
        int n=arr.length;
        while (end < n) 
        {
            sum = sum + arr[end];
            end++;
            
            while(start<end && sum>=k)
            {
                sum -= arr[start];
                start++;
                maxLength = Math.min(maxLength, (end - start +1));
            }
            
               
        }
        if(maxLength == Integer.MAX_VALUE)
           return 0;
        return maxLength;
        
    }
}
