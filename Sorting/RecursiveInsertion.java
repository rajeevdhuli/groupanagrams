public class Solution {
    public static void insertionSort(int[] arr, int size) {
        //Your code goes here
        
        insert(arr,0,size);
        
        
    }
    public static void insert(int[] arr, int i , int n){

            if(i == n)
               return ;
            int j = i;
            while( j > 0 && arr[j] < arr[j-1]){ 
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }

            insert(arr,i+1,n);

    }
}
