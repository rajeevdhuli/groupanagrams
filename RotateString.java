class Solution {
    public boolean rotateString(String s, String goal) 
    {
        int n = s.length();
        if(s.length() != goal.length())
            return false;
        int index = s.indexOf(goal.charAt(0));
        while( index != -1)
        {
            String s1 = s.substring(0,index);
            String s2 = s.substring(index,n);
            String str= s2+s1;
            if(str.equals(goal))
                return true;     
            index = s.indexOf(goal.charAt(0),index+1);       
        }
        return false;       
    }
}
