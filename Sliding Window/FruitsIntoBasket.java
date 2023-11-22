class Solution {
    public int totalFruit(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> mp = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLength = 0;
        while(end < n){
            mp.put(arr[end],mp.getOrDefault(arr[end], 0)+1);

            while(mp.size() > 2){
                if(mp.get(arr[start]) ==  1){
                    mp.remove(arr[start]);
                }else{
                    mp.put(arr[start],mp.get(arr[start])-1);
                }
                start++;
            }
            maxLength = Math.max(maxLength,end - start + 1);
            end++;
        }
        return maxLength;
    }
}
