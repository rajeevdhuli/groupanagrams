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



class Solution {
    public boolean rotateString(String s, String goal) 
    {
        String str = s + s;
        int n = goal.length();
        if(s.length() != goal.length())
            return false;
        int index = s.indexOf(goal.charAt(0));
        while( index != -1)
        {
            String s1= str.substring(index,index+n);
            if(s1.equals(goal))
                return true;     
            index = s.indexOf(goal.charAt(0),index+1);       
        }
        return false;       
    }
}


SHORTCUT - DIRECTLY SEARCH FOR STRING -

    class Solution {
    public boolean rotateString(String s, String goal) 
    {
        if(s.length() != goal.length())
           return false;       
        String str = s + s;
        int index = str.indexOf(goal);
        if(index != -1)
           return true;
        return false;   
    }
}






class Solution {
    public boolean rotateString(String s, String goal) 
    {
        if(s.length() != goal.length()){
            return false;
        }
        String str = s + s;
        int n = goal.length();
        int j = n ;
        int i = 0;
        while(j < str.length()){
            String st = str.substring(i,j);
            if(st.equals(goal)){
                return true;
            }
            i++;
            j++;
        }
        return false;
    }
}

