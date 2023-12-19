class Solution {
    public long[] sumOfThree(long num) {
        long[] arr = new long[3];
        if(num % 3 != 0){
            return new long[0];
        }
        else{
            
            arr[1] = (long)num / 3;
            arr[0] = num/3 - 1;
            arr[2] = num/3 + 1;

        }
        return arr;
        
    }
}
