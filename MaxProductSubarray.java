class Solution
{
    public int maxProduct(int[] arr) 
    {
       int prod = 1;
       int min_prod = 1;
       int max = arr[0];
  
       for(int i=0;i<arr.length;i++)
       {
            int temp = prod;

            if( arr[i] < arr[i]*prod && arr[i]*prod > arr[i]*min_prod )
            {
                prod = arr[i]*prod;
            }
            else if( arr[i] < min_prod*arr[i]  )
            {
                prod = min_prod*arr[i];
            }
            else
                prod = arr[i];
            


            if( arr[i] > arr[i]*min_prod && arr[i]*min_prod < temp*arr[i] )
            {
                min_prod = min_prod * arr[i];
            }
            else if(arr[i] > arr[i]*temp )
            {
                min_prod = temp *arr[i];
            }
            else 
                min_prod = arr[i];

             
            if(max < prod)
            {
                max = prod;
            }
       }
       return max;    
    }
}
