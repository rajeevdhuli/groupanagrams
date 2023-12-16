public class Solution {
    static class MinHeap {
        // Constructor for the class.
        private int capacity;
        private int heapsize;
        private int[] heapArray;
        MinHeap(int size) {
            // Write your code here.
            heapsize = 0; 
            capacity = size;
            heapArray = new int[capacity];
        }
        int parent(int index){
            return (index-1)/2;
        }
        int left(int index){
            return (index * 2) + 1;
        }
        int right(int index){
            return (index * 2) + 2;
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
            int root = heapArray[0];
            heapsize--;
            heapArray[0] = heapArray[heapsize];
            downheap(heapArray,0);
            return root;
        }
        void downheap(int[] heapArray,int index){
            int l = left(index);
            int r = right(index);
            int smallest = index;
            if(l < heapsize && heapArray[smallest] > heapArray[l]){
                smallest = l;
                
            }
            if(r < heapsize && heapArray[smallest] > heapArray[r]){
                smallest = r;
                
            }
            if(smallest != index){
               swap(heapArray,index,smallest);
               downheap(heapArray,smallest);
            }

        }

        // Implement the function to delete an element.
        void deleteElement(int ind) {
            // Write you code here.
            if(ind >= heapsize){
                return;
            }
            swap(heapArray,ind,heapsize);
            heapsize--;
            downheap(heapArray,ind);

        }

        // Implement the function to insert 'val' in the heap.
        void insert(int val) {
            // Write you code here.
            if(heapsize == capacity)
               return;
            int ind = heapsize;
            heapsize++;
            heapArray[ind] = val;
            upheap(heapArray,ind);
        }
        void upheap(int[] heapArray,int ind){
            if(ind <= 0)
               return;
            int p = parent(ind);
            if(heapArray[p] > heapArray[ind]){
                swap(heapArray,ind,p);
                upheap(heapArray,p);
            }   
        }
        void swap(int[] heapArray, int i , int j){
            int temp = heapArray[i];
            heapArray[i] = heapArray[j];
            heapArray[j] =temp;
        }
    }
};
