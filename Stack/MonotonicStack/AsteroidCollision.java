class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i : asteroids){
            if( i > 0){
                st.push(i);
            }else{
                /*if negative is larger than positive */
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(i)){
                    st.pop();
                }
                /*if it is empty or before elemnt is negative then they cant collide*/
                if(st.isEmpty() || st.peek() < 0){
                    st.push(i);
                }
                /*if they are equal of different sign then none should be present */
                if(!st.isEmpty() && (st.peek() + i == 0)){
                    st.pop();
                }
                
            }
        }
        int len = st.size();
        int[] ans = new int[len];
        for(int i = len - 1; i >= 0; i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}



