class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();
        if(k == 0){
            return num;
        }
        if(n <= k){
            return "0";
        }
        for(int i = 0 ; i < n ; i++){
            while((k > 0 && !st.isEmpty()) && ((st.peek() - '0') > (num.charAt(i) - '0'))){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
            if(st.size() == 1 && st.peek() == '0')
                st.pop();
        }
        while(k > 0 && !st.isEmpty()){
            k--;
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        sb.reverse();
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}
