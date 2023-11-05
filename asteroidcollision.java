class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        //st.push(asteroids[0]);
        int n = asteroids.length;
        for(int i = 0; i < n; i++)
        {
            if(st.size() == 0)
               st.push(asteroids[i]);
            else
            {
                boolean flag  = false;
                if((st.peek()  > 0 && asteroids[i] > 0 ) || (st.peek() < 0  && asteroids[i] < 0))
                    st.push(asteroids[i]);
                if(!st.isEmpty() && (st.peek() < 0 && asteroids[i] > 0))
                    st.push(asteroids[i]);
                while(!st.isEmpty() &&  (st.peek() > 0 ) && (st.peek() < Math.abs(asteroids[i])))
                {    
                    st.pop();
                    flag = true;
                }
                if(!st.isEmpty() && (st.peek() > Math.abs(asteroids[i])))
                    flag = false;
                 
                if(!st.isEmpty() && (st.peek() > 0 ) && (st.peek() + asteroids[i] == 0))
                {
                    st.pop(); 
                    flag = false;
                }
                if(flag  == true)
                    st.push(asteroids[i]);         
            }
        }
        int len = st.size();
        int[] ans = new int[len];
        for(int i = len - 1; i >= 0 ;i--)
        {
            ans[i] = st.pop();
        }
        return ans;
    }
}


OPTIMIZED-


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        for(int i:asteroids)
        {
            if(i > 0)
               st.push(i);
            else
            {
                while(!st.empty() && st.peek() > 0 && (st.peek() < Math.abs(i)))
                    st.pop();
                if(st.empty() || st.peek() < 0)
                    st.push(i);
                if(st.peek() > 0 && (st.peek() + i == 0))
                    st.pop();        
            }   
        }
        int len = st.size();
        int[] ans = new int[len];
        for(int i = len - 1; i >= 0 ;i--)
        {
            ans[i] = st.pop();
        }
        return ans;
    }
}  
  
