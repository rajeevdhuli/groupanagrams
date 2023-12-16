public class Solution {
    public static int[] MinToMaxHeap(int n, int[] arr){
        // Write your code here
        for(int i = n/2; i >= 0; i--){
            downheap(arr,i,n);  
        }
        return arr;
    }
    public static int left(int index){
        return (index * 2) + 1;
    }
    public static int right(int index){
        return (index * 2) + 2;
    }

    public static void downheap(int[] arr, int index, int n){
        int l = left(index);
        int r = right(index);
        int largest = index;
        if(l < n && arr[l] > arr[largest]){
            largest  = l;
        }
        if(r < n && arr[r] > arr[largest]){
            largest = r;
        }
        if(largest != index){
            swap(arr,largest,index);
            downheap(arr,largest,n);
        }
        
    }
    public static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
