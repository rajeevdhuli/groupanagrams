class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        if(k == 0){
            return num;
        }
        if(k >= n){
            return "0";
        }
        for(int i = 0 ; i < n; i ++){
            char ch = num.charAt(i);
            int j = ch - '0';
            while(!st.isEmpty() && k > 0 && st.peek() > j){
                st.pop();
                k--;
            }
            st.push(j);
            /****leading zero delete it******/
            if(st.size() == 1 && st.peek() == 0){
                st.pop();
            }
        }
        while(k > 0 && !st.isEmpty()){
            /****edge case - 123345*****/
            k--;
            st.pop();
        }
        while(!st.isEmpty()){
            sb = sb.append(String.valueOf(st.pop()));
        }
        sb.reverse();
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}
