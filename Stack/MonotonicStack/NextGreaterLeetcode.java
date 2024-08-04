class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        int m = nums2.length;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = m - 1; i >= 0 ; i--){
            while(!st.isEmpty() && nums2[i] >= st.peek()){
                st.pop();
            }
            mp.put(nums2[i],(st.isEmpty()) ?  -1 : st.peek());
            st.push(nums2[i]);
        }
        for(int i = 0 ; i < n ; i++){
            ans[i] = mp.get(nums1[i]);
        }
        return ans;
    }
}
