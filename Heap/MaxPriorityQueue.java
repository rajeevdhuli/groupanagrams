import java.util.List;
public class Solution {
    public static int pop(List<Integer> heap) {
        // Write you code here.
        if(heap.isEmpty()){
            return -1;
        }
        int root = heap.get(0);
        int last = heap.remove(heap.size()-1);
        if(!heap.isEmpty()){
            heap.set(0,last);
            downheap(heap,0);
        }
        return root;
    }
    public static void downheap(List<Integer> heap,int index){
        int l = (2 * index) + 1;
        int r = (2 * index) + 2;
        int largest = index;
        if(l < heap.size() && heap.get(l) > heap.get(largest)){
            largest = l;
        }
        if(r < heap.size() && heap.get(r) > heap.get(largest)){
            largest = r;
        }
        if(largest != index){
            swap(heap,index,largest);
            downheap(heap,largest);
        }
    }
    public static void swap(List<Integer> heap,int i , int j){
        int temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }
