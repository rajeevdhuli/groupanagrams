class Solution {
    public int minSteps(String s, String t) {
       int[] arr1 = func(s);
       int[] arr2 = func(t);
       int step  = 0;
       for(int i = 0 ; i < 26; i++){
           if(arr1[i] != arr2[i]){
               step+= Math.abs(arr1[i] - arr2[i]);
           }
       } 
       return step;
    }
    public int[] func(String s){
        int[] arr = new int[26];
        for(char c: s.toCharArray()){
            arr[c - 'a']++;
        }
        return arr;
    }
}
