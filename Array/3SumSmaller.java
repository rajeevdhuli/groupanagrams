class Solution
{
    long countTriplets(long arr[], int n,int target)
    {
        Arrays.sort(arr);
        long cnt = 0;
        for(int i =0;i < n - 2;i++)
        {
            if( i > 0 && arr[i] == arr[i-1])
               continue;
            int j = i + 1;
            int k = n - 1;
            while( j < k )
            {
                long sum = arr[i] + arr[j] + arr[k];
                if( sum >= target)
                    k--;
                else 
                {
                    cnt+= k - j;
                    j++;
                }
            }
            
        }
        return cnt;

    }
}
