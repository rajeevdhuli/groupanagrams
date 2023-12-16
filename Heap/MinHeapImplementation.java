public class Solution {
    static class MinHeap {
        // Constructor for the class.
        int[] heapArray;
        int heapsize;
        int capacity;
        MinHeap(int size) {
            // Write your code here.
            heapArray = new int[size];
            heapsize = 0;
            capacity = size;
        }
        int parent(int index){
            return (index - 1)/2;
        }

        int left(int index){
            return ( 2 * index ) + 1;
        }
        int right(int index){
            return ( 2 * index ) + 2;
        }
        // Implement the function to remove minimum element.
        int extractMinElement() {
            // Write you code here.
            if(heapsize == 0){
                return -1;
            }
            if(heapsize == 1){
                heapsize--;
                return heapArray[0];
            }
            int value = heapArray[0];
            heapsize--;
            heapArray[0] = heapArray[heapsize];
            downheap(heapArray,0);
            return value;
        }

        void downheap(int[] heapArray,int index){
            int l = left(index);
            int r = right(index);
            int smallest = index;
            if(l < heapsize && heapArray[smallest]  > heapArray[l]){
                smallest = l;
            }
            if(r < heapsize && heapArray[smallest] > heapArray[r]){
                smallest = r;
            }
            if(smallest != index){
                swap(heapArray,smallest,index);
                downheap(heapArray,smallest);
            }
        }

        // Implement the function to delete an element.
        void deleteElement(int ind) {
            // Write you code here.
            if(ind >= heapsize){
                return;
            }
            heapsize--;
            heapArray[ind] = heapArray[heapsize];
            downheap(heapArray,ind);
        }

        // Implement the function to insert 'val' in the heap.
        void insert(int val) {
            // Write you code here.
            if(heapsize == capacity){
                return;
            }
            int index = heapsize;
            heapsize++;
            heapArray[index] = val;
            upheap(heapArray,index);
        }
        void upheap(int[] heapArray, int index){
            if(index == 0){
                return;
            }
            int p = parent(index);
            if(heapArray[index] < heapArray[p]){
                swap(heapArray,index,p);
                upheap(heapArray,p);
            }
        }
        void swap(int[] heapArray,int i , int j){
            int temp = heapArray[i];
            heapArray[i] =heapArray[j];
            heapArray[j] = temp;
        }
    }
};
